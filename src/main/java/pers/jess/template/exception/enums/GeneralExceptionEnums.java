package pers.jess.template.exception.enums;

public enum GeneralExceptionEnums implements ExceptionEnums {

    EMPTY_PARAM  (10001, "参数为空"),

    ERROR_PARAM  (10002, "参数错误"),

    ERROR_UNKNOWN(10009, "未知错误"),

    EMPTY_FILE   (11001, "文件为空"),

    ERROR_UPLOAD_FILE (11002, "上传失败");



    private Integer errorCode;

    private String message;

    private GeneralExceptionEnums(Integer errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public int getCode() {
        return errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
