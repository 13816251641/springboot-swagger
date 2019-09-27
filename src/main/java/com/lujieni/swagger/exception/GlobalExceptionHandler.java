package com.lujieni.swagger.exception;

import com.lujieni.swagger.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 异常处理器
 * 
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 自定义业务异常
	 */
	@ExceptionHandler(GlobalException.class)
	public R handleRRException(GlobalException e){
		log.error("自定义异常", e);
		return R.error(e.getMsg());
	}


	/**
	 * 全局异常
	 * @param e
	 * @param httpRequest
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public R handleException(Exception e,HttpServletRequest httpRequest){
		log.error("全局异常", e);
		return R.error(e.getMessage());
	}
	
	/**
     *  校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R validationBodyException(MethodArgumentNotValidException exception){
        FieldError fieldError = exception.getBindingResult().getFieldError();
        log.error(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        return R.error(fieldError.getDefaultMessage());
    }

    /**
     * 参数类型转换错误
     *
     * @param exception 错误
     * @return 错误信息
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public R parameterTypeException(HttpMessageConversionException exception){
        log.error("类型转换错误",exception);
        
        return R.error("类型转换错误");
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R httpRequestMethodNotSupportedExceptionException(HttpRequestMethodNotSupportedException exception){
    	log.error("不支持请求类型",exception);
    	return R.error("不支持请求类型");
    }
}
