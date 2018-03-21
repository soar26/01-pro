package com.zgf.dto;

public class AjaxDto {

    private String msg;
    private Integer status;

    public AjaxDto(String msg,Integer status){
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AjaxDto{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                '}';
    }
}
