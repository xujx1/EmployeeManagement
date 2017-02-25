package com.architecture.em.utils.exception;

/**
 * Created by xujinxin on 2017/2/25.
 */
public class ServiceException extends BaseRuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8836950183434051756L;

    public ServiceException() {
        super();
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(Integer errorCode) {
        super(errorCode);
    }

    public ServiceException(Integer errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public ServiceException(Integer errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ServiceException(Integer errorCode, String errorMessage, Throwable cause) {
        super(errorCode, errorMessage, cause);
    }
}
