package com.architecture.em.utils.exception;

/**
 * Created by xujinxin on 2017/2/22.
 */
public class BaseException extends Exception {
    private static final long serialVersionUID = -1431060147519939620L;


    private Throwable nestedThrowable;

    private ExceptionInfo exceptionInfo = new ExceptionInfo();

    public BaseException() {
    }

    public BaseException(Throwable cause) {
        super(cause);
        this.nestedThrowable = cause;
    }

    public BaseException(Integer errorCode) {
        super();
        this.exceptionInfo.setErrorCode(errorCode);
    }

    public BaseException(Integer errorCode, Throwable cause) {
        super(cause);
        this.nestedThrowable = cause;
        this.exceptionInfo.setErrorCode(errorCode);
    }

    public BaseException(Integer errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.nestedThrowable = cause;
        this.exceptionInfo.setErrorCode(errorCode);
        this.exceptionInfo.setErrorMsg(errorMessage);
    }

    public BaseException(Integer errorCode, String errorMessage) {
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
