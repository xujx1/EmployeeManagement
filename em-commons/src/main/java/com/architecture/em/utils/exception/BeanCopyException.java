package com.architecture.em.utils.exception;

/**
 * Created by xujinxin on 2017/2/22.
 */
public class BeanCopyException extends BaseRuntimeException {
    private static final long serialVersionUID = 7390836820547512937L;

    public BeanCopyException() {
        super();
    }

    public BeanCopyException(Throwable cause) {
        super(cause);
    }

    public BeanCopyException(Integer errorCode) {
        super(errorCode);
    }

    public BeanCopyException(Integer errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BeanCopyException(Integer errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public BeanCopyException(Integer errorCode, String errorMessage, Throwable cause) {
        super(errorCode, errorMessage, cause);
    }

}
