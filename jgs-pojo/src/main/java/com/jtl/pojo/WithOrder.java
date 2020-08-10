package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "with_order")
public class WithOrder {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 联系人
     */
    @Column(name = "wo_name")
    private String woName;


    @Column(name = "wo_phone")
    private String woPhone;

    /**
     * 发货地址
     */
    @Column(name = "wo_fh_address")
    private String woFhAddress;

    /**
     * 收货地址
     */
    @Column(name = "wo_sh_address")
    private String woShAddress;

    /**
     * 距离
     */
    @Column(name = "wo_jl")
    private String woJl;

    /**
     * 车型
     */
    @Column(name = "wo_cx")
    private String woCx;

    /**
     * 配单价格
     */
    @Column(name = "wo_money")
    private String woMoney;

    /**
     * 骑手ID
     */
    @Column(name = "rider_id")
    private Integer riderId;

    /**
     * 订单状态
     */
    @Column(name = "wo_state")
    private String woState;

    @Column(name = "create_time")
    private Date createTime;
    //骑手电话
    private String riderPhone;
    //跟车人数
    private String gcrs;
    //额外需求
    private String ewxq;
    //配单备注
    private String woNote;

    public String getRiderPhone() {
        return riderPhone;
    }

    public void setRiderPhone(String riderPhone) {
        this.riderPhone = riderPhone;
    }

    public String getGcrs() {
        return gcrs;
    }

    public void setGcrs(String gcrs) {
        this.gcrs = gcrs;
    }

    public String getEwxq() {
        return ewxq;
    }

    public void setEwxq(String ewxq) {
        this.ewxq = ewxq;
    }

    public String getWoNote() {
        return woNote;
    }

    public void setWoNote(String woNote) {
        this.woNote = woNote;
    }

    public String getWoPhone() {
        return woPhone;
    }

    public void setWoPhone(String woPhone) {
        this.woPhone = woPhone;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取联系人
     *
     * @return wo_name - 联系人
     */
    public String getWoName() {
        return woName;
    }

    /**
     * 设置联系人
     *
     * @param woName 联系人
     */
    public void setWoName(String woName) {
        this.woName = woName;
    }

    /**
     * 获取发货地址
     *
     * @return wo_fh_address - 发货地址
     */
    public String getWoFhAddress() {
        return woFhAddress;
    }

    /**
     * 设置发货地址
     *
     * @param woFhAddress 发货地址
     */
    public void setWoFhAddress(String woFhAddress) {
        this.woFhAddress = woFhAddress;
    }

    /**
     * 获取收货地址
     *
     * @return wo_sh_address - 收货地址
     */
    public String getWoShAddress() {
        return woShAddress;
    }

    /**
     * 设置收货地址
     *
     * @param woShAddress 收货地址
     */
    public void setWoShAddress(String woShAddress) {
        this.woShAddress = woShAddress;
    }

    /**
     * 获取距离
     *
     * @return wo_jl - 距离
     */
    public String getWoJl() {
        return woJl;
    }

    /**
     * 设置距离
     *
     * @param woJl 距离
     */
    public void setWoJl(String woJl) {
        this.woJl = woJl;
    }

    /**
     * 获取车型
     *
     * @return wo_cx - 车型
     */
    public String getWoCx() {
        return woCx;
    }

    /**
     * 设置车型
     *
     * @param woCx 车型
     */
    public void setWoCx(String woCx) {
        this.woCx = woCx;
    }

    /**
     * 获取配单价格
     *
     * @return wo_money - 配单价格
     */
    public String getWoMoney() {
        return woMoney;
    }

    /**
     * 设置配单价格
     *
     * @param woMoney 配单价格
     */
    public void setWoMoney(String woMoney) {
        this.woMoney = woMoney;
    }

    /**
     * 获取骑手ID
     *
     * @return rider_id - 骑手ID
     */
    public Integer getRiderId() {
        return riderId;
    }

    /**
     * 设置骑手ID
     *
     * @param riderId 骑手ID
     */
    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }

    /**
     * 获取订单状态
     *
     * @return wo_state - 订单状态
     */
    public String getWoState() {
        return woState;
    }

    /**
     * 设置订单状态
     *
     * @param woState 订单状态
     */
    public void setWoState(String woState) {
        this.woState = woState;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}