package com.huzhu.pojo;


public class HuZhu_Request {
    private int request_id;//请求表的id
    private String tag_01;//请求标签（必填）
    private String tag_02;//请求标签2
    private String tag_03;//请求标签3
    private String title;//请求的标题
    private String text;//请求体
    private int pay;//愿意为此支付的价格
    private int order_taker_id;//接单人的id

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getTag_01() {
        return tag_01;
    }

    public void setTag_01(String tag_01) {
        this.tag_01 = tag_01;
    }

    public String getTag_02() {
        return tag_02;
    }

    public void setTag_02(String tag_02) {
        this.tag_02 = tag_02;
    }

    public String getTag_03() {
        return tag_03;
    }

    public void setTag_03(String tag_03) {
        this.tag_03 = tag_03;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getOrder_taker_id() {
        return order_taker_id;
    }

    public void setOrder_taker_id(int order_taker_id) {
        this.order_taker_id = order_taker_id;
    }
}
