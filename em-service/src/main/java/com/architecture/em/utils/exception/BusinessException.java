package com.architecture.em.utils.exception;

/**
 * Created by xujinxin on 2017/2/25.
 */
public class BusinessException extends BaseRuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6863063675145470994L;

    public BusinessException() {
        super();
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(Integer errorCode) {
        super(errorCode);
    }

    public BusinessException(Integer errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BusinessException(Integer errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public BusinessException(Integer errorCode, String errorMessage, Throwable cause) {
        super(errorCode, errorMessage, cause);
    }
}
