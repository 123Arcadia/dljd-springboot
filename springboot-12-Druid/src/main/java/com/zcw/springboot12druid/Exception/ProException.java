package com.zcw.springboot12druid.Exception;

import com.zcw.springboot12druid.Res.Code;
import com.zcw.springboot12druid.Res.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 使用getById测试这些异常
 */
@RestControllerAdvice
public class ProException {
    /**
     * 处理系统异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException exception) {
        return new Result(null, exception.getCode(), exception.getMessage());
    }


    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException exception) {
        return new Result(null, exception.getCode(), exception.getMessage());
    }


    /**
     * 处理未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception) {
        return new Result(null, Code.SYSTEM_UNKNOW_ERR, "系统繁忙，请稍后再试");
    }
}
