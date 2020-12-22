package whu.zhj.zhjweb.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhj
 * ResponseWrapper
 */
public class ResponseWrapper {
    /**
     * 返回的结果码
     */
    private int code;

    /**
     * 返回的结果信息
     */
    private String message;

    /**
     * 返回的结果的额外信息
     */
    private Map<String, Object> extra;

    /**
     * 私有的构造函数，外界不能直接new
     */
    private ResponseWrapper(){

    }

    /**
     * 自定义返回结果
     * @param code 结果码
     * @param message 结果信息
     * @return 返回自定义的结果
     */
    public static ResponseWrapper markDefault(int code, String message){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(code);
        responseWrapper.setMessage(message);
        return responseWrapper;
    }

    /**
     * 成功返回结果
     * @return 返回成功结果
     */
    public static ResponseWrapper markSuccess(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(ResponseCode.SUCCESS.getCode());
        responseWrapper.setMessage(ResponseCode.SUCCESS.getMessage());
        return  responseWrapper;
    }

    /**
     * 成功但没数据返回结果
     * @return 返回成功但没数据结果
     */
    public static ResponseWrapper markNoData(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(ResponseCode.NODATA.getCode());
        responseWrapper.setMessage(ResponseCode.NODATA.getMessage());
        return  responseWrapper;
    }

    /**
     * 成功但数据已存在返回结果
     * @return 返回成功但数据已存在结果
     */
    public static ResponseWrapper markDataExisted(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(ResponseCode.DATA_EXISTED.getCode());
        responseWrapper.setMessage(ResponseCode.DATA_EXISTED.getMessage());
        return  responseWrapper;
    }

    /**
     * 参数为空或者参数格式错误返回结果
     * @return 返回参数为空或者参数格式错误结果
     */
    public static ResponseWrapper markParamError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(ResponseCode.PARAMS_ERROR.getCode());
        responseWrapper.setMessage(ResponseCode.PARAMS_ERROR.getMessage());
        return  responseWrapper;
    }

    /**
     * 失败返回结果
     * @return 返回失败结果
     */
    public static ResponseWrapper markError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(ResponseCode.FAILED.getCode());
        responseWrapper.setMessage(ResponseCode.FAILED.getMessage());
        return  responseWrapper;
    }

    /**
     * 无效URL链接返回结果
     * @return 返回无效URL链接结果
     */
    public static ResponseWrapper markUrlError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(ResponseCode.URL_ERROR.getCode());
        responseWrapper.setMessage(ResponseCode.URL_ERROR.getMessage());
        return  responseWrapper;
    }

    /**
     * 系统异常返回结果
     * @return 返回系统异常结果
     */
    public static ResponseWrapper markSystemError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(ResponseCode.SYSTEM_ERROR.getCode());
        responseWrapper.setMessage(ResponseCode.SYSTEM_ERROR.getMessage());
        return  responseWrapper;
    }

    /**
     * 没有该API访问权限返回结果
     * @return 返回没有该API访问权限结果
     */
    public static ResponseWrapper markApiNotPermission(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(ResponseCode.API_NOT_PER.getCode());
        responseWrapper.setMessage(ResponseCode.API_NOT_PER.getMessage());
        return  responseWrapper;
    }

    /**
     * 根据JSON获取返回结果
     * @param tag 名称
     * @param jsonArray 额外信息内容
     * @return
     */
    public static ResponseWrapper getResponseWrapperFromJSONArray(String tag, JSONArray jsonArray){
        ResponseWrapper responseWrapper;
        if(jsonArray != null && jsonArray.size() > 0){
            responseWrapper = ResponseWrapper.markSuccess();
            responseWrapper.setExtra(tag, jsonArray);
        }else if(jsonArray != null){
            responseWrapper = ResponseWrapper.markNoData();
        }else{
            responseWrapper = ResponseWrapper.markError();
        }
        return responseWrapper;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public void setExtra(String key, Object value){
        if(this.extra == null){
            //HashMap使用如下构造方法进行初始化，如果暂时无法确定集合大小，那么指定默认值（16）即可
            extra = new HashMap<>(16);
        }
        this.extra.put(key, value);
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
