package com.jhbh.jxyqyd.responseResult;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author:hou
 * @Date:2018/12/17
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T>{
    private Integer code = 200;
    private String msg = "成功";
    private T data;


    public ResponseResult() {
    }


    public ResponseResult(Integer code, Exception e) {
        this.code = code;
        this.msg = e.getMessage();
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
