package com.jtl.controller.upload;

import com.jtl.bo.ImgBO;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Iterator;

@Api(value = "图片上传",tags = {"图片上传相关的相关接口"})
@Controller
@RequestMapping(value="/uploadFile")
public class UploadFile {
	
	//上传的文件夹路径
	private static final String uploadServerDir = "E:/img/";
	
	private static final String separator = "/";
	/*@RequestMapping(value="/upload")*/
	@PostMapping(value="/upload")
	@ResponseBody
	public JTLJSONResult upload( MultipartFile file,HttpServletRequest request, HttpServletResponse response){

		ImgBO imgBO = new ImgBO();

		//文件名称
		String fileName = "";
		//图片网络路径
		String picHttpUrl = "";

		String fileExt = "";

		String imgHttpUrl = null;

		String newPath = DateUtil.getTodayDate2();
		String millisecond = DateUtil.getMillisecondDate().split("/")[1];

		//创建服务器上的图片目录
		File savePath = new File(uploadServerDir+newPath);
		if (!savePath.exists()) {
			savePath.mkdirs();
		}

		//创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(multipartResolver.isMultipart(request)){
			//转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			//取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();

			while(iter.hasNext()){
				//取得上传文件
				file = multiRequest.getFile(iter.next());
				file.getOriginalFilename();
				if(file != null){
					//取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					if(StringUtils.isNotBlank(myFileName.trim())){
						//重命名上传后的文件名
						fileExt = myFileName.substring(myFileName.lastIndexOf("."), myFileName.length());
						fileName =millisecond+"@"+ToolUtil.getSixRandom()+fileExt;

						picHttpUrl =newPath+separator+fileName;
						imgHttpUrl ="img/"+newPath+separator+fileName;
						imgBO.setValue(imgHttpUrl);

						File uploadFile = new File(savePath+separator+fileName);
						try {
							//上传文件
							file.transferTo(uploadFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return JTLJSONResult.ok(imgBO);
	}


}
