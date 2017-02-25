package com.architecture.em.utils.exception;

import com.architecture.em.utils.errorcode.CommonExceptionCode;
import org.springframework.dao.DataAccessException;

/**
 * 异常统一封装类 系统封装了ProxyException，ServiceException，BusinessException
 */
public class ExceptionHandlerUtil {

    public static void wrapAndThrowBusinessException(Throwable cause) {
        BusinessException businessException = null;
        if (cause == null) {// 未知异常
            businessException = new BusinessException(CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorMsg(), null);
        } else if (cause instanceof BusinessException) {// 如果是BusinessException直接抛
            businessException = (BusinessException) cause;
        } else if (cause instanceof BaseRuntimeException) {// 业务异常
            BaseRuntimeException baseRuntimeException = (BaseRuntimeException) cause;
            businessException = new BusinessException(baseRuntimeException.getErrorCode(),
                    baseRuntimeException.getErrorMsg(), baseRuntimeException.getNestedThrowable());
        } else if (cause instanceof DataAccessException) {// 据库异常码
            businessException = new BusinessException(CommonExceptionCode.DATABASE_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.DATABASE_EXCEPTION.getErrorMsg(), cause);
        } else {
            businessException = new BusinessException(CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorMsg(), cause);
        }
        throw businessException;
    }

    public static void wrapAndThrowBusinessException(Integer errorCode, Throwable cause) {
        throw new BusinessException(errorCode, cause);
    }

    public static void wrapAndThrowBusinessException(Integer errorCode, String errorMsg) {
        throw new BusinessException(errorCode, errorMsg);
    }

    public static void wrapAndThrowBusinessException(Integer errorCode, String errorMsg, Throwable cause) {
        throw new BusinessException(errorCode, errorMsg, cause);
    }

    /**
     * 将所有异常转换为ServiceException，然后抛出
     * @param cause 原始异常
     */
    public static void wrapAndThrowServiceException(Throwable cause) {
        ServiceException serviceException = null;
        if (cause == null) {// 未知异常
            serviceException = new ServiceException(CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorMsg(), null);
        } else if (cause instanceof ServiceException) {
            serviceException = (ServiceException) cause;
        } else if (cause instanceof BaseRuntimeException) {// 业务异常
            BaseRuntimeException baseRuntimeException = (BaseRuntimeException) cause;
            serviceException = new ServiceException(baseRuntimeException.getErrorCode(),
                    baseRuntimeException.getErrorMsg(), baseRuntimeException.getNestedThrowable());
        } else if (cause instanceof DataAccessException) {// 数据库异常
            serviceException = new ServiceException(CommonExceptionCode.DATABASE_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.DATABASE_EXCEPTION.getErrorMsg(), cause);
        } else {// 设置未知异常码
            serviceException = new ServiceException(CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getErrorMsg(), cause);
        }
        throw serviceException;
    }

    public static void wrapAndThrowServiceException(Integer errorCode, Throwable cause) {
        throw new ServiceException(errorCode, cause);
    }

    public static void wrapAndThrowServiceException(Integer errorCode, String errorMsg) {
        throw new ServiceException(errorCode, errorMsg);
    }

    public static void wrapAndThrowServiceException(Integer errorCode, String errorMsg, Throwable cause) {
        throw new ServiceException(errorCode, errorMsg, cause);
    }
}
