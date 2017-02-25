package com.architecture.em.utils.errorcode;


public enum CommonExceptionCode {

    UNKNOWN_EXCEPTION(1021999999, "未知错误"),

    DATABASE_EXCEPTION(1021999998, "数据库错误"),

    REFLECTION_EXCEPTION(1021999997, "反射异常"),

    PARAM_INVALID_EXCEPTION(1021999996, "参数无效"),

    DATE_IS_NULL(1021999993, "日期不能为空"),

    FORMAT_DATE_ERROR(1021999992, "格式化日期时间错误"),

    HTTP_GET_NOT_ALLOWED(1021999990, "不支持GET调用方式"),

    HTTP_POST_NOT_ALLOWED(1021999989, "不支持POST调用方式"),

    MQ_SEND_JMS_MESSAGE_EXCEPTION(1021989001, "JMS消息发送失败"),

    SUCCESS(0000000000, "success")
    ;

    private Integer errorCode;

    private String errorMsg;

    private CommonExceptionCode(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {

        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {

        this.errorMsg = errorMsg;
    }

    public static String getErrorMsg(Integer errorCode) {
        CommonExceptionCode[] codes = CommonExceptionCode.values();
        for (CommonExceptionCode code : codes) {
            if (code.getErrorCode().intValue() == errorCode.intValue()) {
                return code.getErrorMsg();
            }
        }
        return UNKNOWN_EXCEPTION.getErrorMsg();
    }
}
