package com.jtl.controller.wxapi;

import com.jtl.bo.SubmitOrderBo;
import com.jtl.pojo.PayReq;
import com.jtl.service.OrderService;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

@Api(value = "微信支付相关",tags = {"微信支付相关"})
@RestController
@RequestMapping("/wxpay")
public class WxPayController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "微信测试环境",notes = "微信测试环境",httpMethod = "POST")
    @PostMapping("/wxCshi")
    public JTLJSONResult wxCshi(@RequestBody SubmitOrderBo submitOrderBo){

        HashMap<Object,Object> resultMap = new HashMap<>();
        //测试环境
        //微信默认从单位为分，所以用此方法将单位调整成元
        int price100 = new BigDecimal("0.01").multiply(new BigDecimal(100)).intValue();
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", ConfigUtil.APPID);
        parameters.put("mch_id", ConfigUtil.MCH_ID);
        parameters.put("nonce_str", ConfigUtil.CreateNoncestr());
        parameters.put("body", "message");
        parameters.put("out_trade_no", UUID.randomUUID().toString().substring(0, 15)); //订单id
        parameters.put("fee_type", "CNY");
        parameters.put("total_fee", String.valueOf(price100));
        parameters.put("spbill_create_ip", "127.0.0.1");
        //回调方法 待测试
        parameters.put("notify_url", "http://192.168.0.102:8088/wxpay/wxNotifySignContract");
        parameters.put("trade_type", "APP");
        //设置签名
        String sign = ConfigUtil.createSign("UTF-8", parameters);
        parameters.put("sign", sign);
        //封装请求参数结束
        String requestXML = ConfigUtil.getRequestXml(parameters);
        //调用统一下单接口
        String result = ConfigUtil.httpsRequest(ConfigUtil.UNIFIED_ORDER_URL, "POST", requestXML);

        System.out.println("\n" + result);
        PayReq payReq = new PayReq();
        try {
            /**统一下单接口返回正常的prepay_id，再按签名规范重新生成签名后，将数据传输给APP。参与签名的字段名为appId，partnerId，prepayId，nonceStr，timeStamp，package。注意：package的值格式为Sign=WXPay**/
            Map<String, String> map = XMLUtil.doXMLParse(result);
            SortedMap<Object, Object> parameterMap2 = new TreeMap<Object, Object>();



            payReq.setAppId(ConfigUtil.APPID);
            payReq.setPartnerId(ConfigUtil.MCH_ID);
            payReq.setPrepayId(map.get("prepay_id"));
            payReq.setPackageValue(ConfigUtil.PACKAGEVALUE);
            payReq.setNonceStr(ConfigUtil.CreateNoncestr());
            payReq.setTimeStamp(Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0, 10)));

            parameterMap2.put("appid", payReq.getAppId());
            parameterMap2.put("partnerid", payReq.getPartnerId());
            parameterMap2.put("prepayid",payReq.getPrepayId());
            parameterMap2.put("package", payReq.getPackageValue());
            parameterMap2.put("noncestr", payReq.getNonceStr());
            //本来生成的时间戳是13位，但是ios必须是10位，所以截取了一下
            parameterMap2.put("timestamp", payReq.getTimeStamp());
            String sign2 = ConfigUtil.createSign("UTF-8", parameterMap2);
            parameterMap2.put("sign", sign2);//此 parameterMap2内容送到ios调用就可以了
            payReq.setSign(sign2);
            System.out.println(parameterMap2);

            resultMap.put("code", "200");
            resultMap.put("msg", parameterMap2);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //明天把放回的数据添加到app前端页面上，已经成功了
        return JTLJSONResult.ok(payReq);
    }


    @ApiOperation(value = "订单提交",notes = "订单提交",httpMethod = "POST")
    @PostMapping("/wxOrderPay")
    public JTLJSONResult wxOrderPay(@RequestBody SubmitOrderBo submitOrderBo){



        //double money = Double.valueOf(price);
        HashMap<Object,Object> resultMap = new HashMap<>();
        //测试环境
        //微信默认从单位为分，所以用此方法将单位调整成元
        int price100 = new BigDecimal(submitOrderBo.getItemPriceSum()).multiply(new BigDecimal(100)).intValue();
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", ConfigUtil.APPID);
        parameters.put("mch_id", ConfigUtil.MCH_ID);
        parameters.put("nonce_str", ConfigUtil.CreateNoncestr());
        parameters.put("body", "message");
        parameters.put("out_trade_no", UUID.randomUUID().toString().substring(0, 15)); //订单id
        parameters.put("fee_type", "CNY");
        parameters.put("total_fee", String.valueOf(price100));
        parameters.put("spbill_create_ip", "127.0.0.1");
        //回调方法 待测试
        parameters.put("notify_url", "http://192.168.0.102:8088/wxpay/wxNotifySignContract");
        parameters.put("trade_type", "APP");
        //设置签名
        String sign = ConfigUtil.createSign("UTF-8", parameters);
        parameters.put("sign", sign);
        //封装请求参数结束
        String requestXML = ConfigUtil.getRequestXml(parameters);
        //调用统一下单接口
        String result = ConfigUtil.httpsRequest(ConfigUtil.UNIFIED_ORDER_URL, "POST", requestXML);

        System.out.println("\n" + result);
        PayReq payReq = new PayReq();
        try {
            /**统一下单接口返回正常的prepay_id，再按签名规范重新生成签名后，将数据传输给APP。参与签名的字段名为appId，partnerId，prepayId，nonceStr，timeStamp，package。注意：package的值格式为Sign=WXPay**/
            Map<String, String> map = XMLUtil.doXMLParse(result);
            SortedMap<Object, Object> parameterMap2 = new TreeMap<Object, Object>();
            payReq.setAppId(ConfigUtil.APPID);
            payReq.setPartnerId(ConfigUtil.MCH_ID);
            payReq.setPrepayId(map.get("prepay_id"));
            payReq.setPackageValue(ConfigUtil.PACKAGEVALUE);
            payReq.setNonceStr(ConfigUtil.CreateNoncestr());
            payReq.setTimeStamp(Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0, 10)));

            parameterMap2.put("appid", payReq.getAppId());
            parameterMap2.put("partnerid", payReq.getPartnerId());
            parameterMap2.put("prepayid",payReq.getPrepayId());
            parameterMap2.put("package", payReq.getPackageValue());
            parameterMap2.put("noncestr", payReq.getNonceStr());
            //本来生成的时间戳是13位，但是ios必须是10位，所以截取了一下
            parameterMap2.put("timestamp", payReq.getTimeStamp());
            String sign2 = ConfigUtil.createSign("UTF-8", parameterMap2);
            parameterMap2.put("sign", sign2);//此 parameterMap2内容送到ios调用就可以了
            payReq.setSign(sign2);
            System.out.println(parameterMap2);

            resultMap.put("code", "200");
            resultMap.put("msg", parameterMap2);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        orderService.createOrder(submitOrderBo);
        //明天把放回的数据添加到app前端页面上，已经成功了
        return JTLJSONResult.ok(payReq);
    }




/*


    /**
     * 微信异步通知 （签约支付）
     */

    @PostMapping("/wxNotifySignContract")
    public void wxNotifySignContract(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException {

        try {
            //读取参数
            InputStream inputStream;
            StringBuffer sb = new StringBuffer();
            inputStream = request.getInputStream();
            String s;
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((s = in.readLine()) != null) {
                sb.append(s);
            }
            in.close();
            inputStream.close();
            //解析xml成map
            Map<String, String> m = new HashMap<String, String>();
            m = XMLUtil.doXMLParse(sb.toString());
            for (Object keyValue : m.keySet()) {
                System.out.println(keyValue + "=" + m.get(keyValue));
            }
            //过滤空 设置 TreeMap
            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            Iterator it = m.keySet().iterator();
            while (it.hasNext()) {
                String parameter = (String) it.next();
                String parameterValue = m.get(parameter);

                String v = "";
                if (null != parameterValue) {
                    v = parameterValue.trim();
                }
                packageParams.put(parameter, v);
            }
            //判断签名是否正确
            String resXml = "";
            if (ConfigUtil.isTenpaySign("UTF-8", packageParams)) {
                if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
                    // 这里是支付成功
                    //////////执行自己的业务逻辑////////////////
                    String appid = (String) packageParams.get("appid");//appid
                    String sign = (String) packageParams.get("sign");//签名
                    String total_fee = (String) packageParams.get("total_fee");//总金额
                    String mch_id = (String) packageParams.get("mch_id"); //商户号
                    String openid = (String) packageParams.get("openid");  //用户标识

                    //微信回调 商户号回调的商户订单号是out_trade_no
                    //（需要唯一，同一个订单号执行下单接口会报错），这里笔者使用
                    //nonce_str作为订单号，后续还需要改动。这个字段官方文档解释为随机字
                    //符串，但后来发现回调的时候返回的nonce_str跟下单填进去的nonce_str
                    //一致，所以暂时用来当订单号了。）
                    String out_trade_no = (String) packageParams.get("nonce_str"); //商户订单号
                    String transaction_id = (String) packageParams.get("transaction_id"); //微信支付订单号
                    //this.contractpayReturn(appid, sign, total_fee, mch_id, openid, out_trade_no, transaction_id);
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                            + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                } else {
                    //logger.info("支付失败,错误信息：" + packageParams.get("err_code"));
                    resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                            + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
                }
            } else {
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[通知签名验证失败]]></return_msg>" + "</xml> ";
               // logger.info("通知签名验证失败");
            }
            //------------------------------
            //处理业务完毕
            //------------------------------
            BufferedOutputStream out = new BufferedOutputStream(
                    response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();

            System.out.println("微信回调接口成功--------");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("微信回调接口失败--------");

        }

    }

}
