package com.architecture.em.utils.exception;

/**
 * Created by xujinxin on 2017/2/22.
 */
public class BaseRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 681940322569501515L;



    private Throwable nestedThrowable;

    private ExceptionInfo exceptionInfo = new ExceptionInfo();

    public BaseRuntimeException() {

    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
        this.nestedThrowable = cause;
    }

    public BaseRuntimeException(Integer errorCode) {
        super();
        this.exceptionInfo.setErrorCode(errorCode);
    }

    public BaseRuntimeException(Integer errorCode, Throwable cause) {
        super(cause);
        this.nestedThrowable = cause;
        this.exceptionInfo.setErrorCode(errorCode);
    }

    public BaseRuntimeException(Integer errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.nestedThrowable = cause;
        this.exceptionInfo.setErrorCode(errorCode);
        this.exceptionInfo.setErrorMsg(errorMessage);
    }

    public BaseRuntimeException(Integer errorCode, String errorMessage) {
        super(errorMessage);
        this.exceptionInfo.setErrorCode(errorCode);
        this.exceptionInfo.setErrorMsg(errorMessage);
    }

    public Throwable getNestedThrowable() {
        return nestedThrowable;
    }

    public void setNestedThrowable(Throwable nestedThrowable) {
        this.nestedThrowable = nestedThrowable;
    }

    public Integer getErrorCode() {
        return this.exceptionInfo.getErrorCode();
    }

    public void setErrorCode(Integer errorCode) {
        this.exceptionInfo.setErrorCode(errorCode);
    }

    public String getErrorMsg() {
        return this.exceptionInfo.getErrorMsg();
    }

    public void setErrorMsg(String errorMsg) {
        this.exceptionInfo.setErrorMsg(errorMsg);
    }

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }

}
