package com.architecture.em.utils.exception;

import com.architecture.em.utils.ResultInfo;
import com.architecture.em.utils.errorcode.CommonExceptionCode;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理 RequestMapping的请求如果发生异常该类会捕获并且返回一个响应
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    public ResultInfo<Object> handle(Throwable cause) {
        LOGGER.error("统一异常处理器捕获系统异常", cause);
        ResultInfo<Object> resultInfo ;
        if (cause instanceof BaseRuntimeException) {
            BaseRuntimeException baseRuntimeException = (BaseRuntimeException) cause;
            resultInfo = ResultInfo.buildFailureResultInfo(baseRuntimeException.getErrorCode(),
                    baseRuntimeException.getErrorMsg());
        } else if (cause instanceof BaseException) {
            BaseException baseException = (BaseException) cause;
            resultInfo = ResultInfo.buildFailureResultInfo(baseException.getErrorCode(), baseException.getErrorMsg());
        } else {
            resultInfo = ResultInfo.buildFailureResultInfo(CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorMsg());
        }
        resultInfo.setStackTrace(ExceptionUtils.getStackTrace(cause));
        LOGGER.error("统一异常处理器捕获系统异常处理结束");
        return resultInfo;
    }
}
