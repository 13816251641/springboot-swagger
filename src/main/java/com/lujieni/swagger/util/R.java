package com.lujieni.swagger.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 */
@Data
public class R <T> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "当调用成功时，返回的数据")
	private T data;

	@ApiModelProperty(value = "调用结果代码")
	private int code;

	@ApiModelProperty(value = "调用结果消息")
	private String msg;

	private R(T t) {
		this.data = t;
		code = HttpStatus.SC_OK;
	}

    private R() {
        this.code = HttpStatus.SC_OK;
    }

	private R(int code,String msg){
		this.code = code;
		this.msg = msg;
	}

	private R(String msg){
		this.msg = msg;
		this.code = HttpStatus.SC_INTERNAL_SERVER_ERROR;
	}

	public static <T> R<T> ok(T t) {
		return new R<>(t);
	}

    public static <T> R<T> ok() {
        return new R<>();
    }


	public static R error(int code, String msg) {
		return new R(code,msg);
	}

	public static R error(String msg) {
		return new R(msg);
	}
}
