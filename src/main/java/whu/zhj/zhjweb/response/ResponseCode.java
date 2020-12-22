package whu.zhj.zhjweb.response;

/**
 * @author zhj
 * ResponseCode
 */

public enum ResponseCode {

    /**
     * 200-399为正常操作
     */
    SUCCESS(200, "操作成功"),
    NODATA(201, "操作成功，但无记录"),
    DATA_EXISTED(202, "操作成功，但记录已存在"),
    REDIRECT(300, "重定向"),

    /**
     * 400-599 判定为前端可以自定义异常处理的普通异常
     */
    FAILED(400, "操作失败"),
    ACCOUNT_ERROR(401, "用户名或密码错误"),
    PARAMS_ERROR(402, "请求参数为空格或格式错误"),
    API_NOT_EXISTS(404, "请求的接口不存在"),
    URL_ERROR(405, "无效的URL链接"),
    UNKNOWN_IP(406, "非法IP请求"),
    SYSTEM_ERROR(500, "系统异常"),

    /**
     * 900以上，判定为前端统一处理的异常
     */
    API_NOT_PER(999, "没有该接口的访问权限");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
