package com.love.loveme.vo;

import lombok.Data;

/**
 * @author zlx
 * @ClassName ResultLove.java
 * @Description TODO
 * @createTime 2021年11月08日 14:59:00
 */
@Data
public class ResultLove {


    private Integer code;

    private Object data;

    private String msg;

    public static ResultLove success(String msg,Object data) {
        ResultLove resultLove = new ResultLove();
        resultLove.setMsg(msg);
        resultLove.setData(data);
        resultLove.setCode(200);
        return resultLove;

    }

    public static ResultLove success(Object data) {
        ResultLove resultLove = new ResultLove();
        resultLove.setMsg("success");
        resultLove.setData(data);
        resultLove.setCode(200);
        return resultLove;

    }

    public static ResultLove fail(Object data) {
        ResultLove resultLove = new ResultLove();
        resultLove.setMsg("fail");
        resultLove.setData(data);
        resultLove.setCode(-1);
        return resultLove;

    }

    public static ResultLove fail(String msg,Object data) {
        ResultLove resultLove = new ResultLove();
        resultLove.setMsg(msg);
        resultLove.setData(data);
        resultLove.setCode(-1);
        return resultLove;

    }



}
