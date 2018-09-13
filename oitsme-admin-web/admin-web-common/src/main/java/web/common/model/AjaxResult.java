package web.common.model;

import com.oitsme.admin.fad.common.dto.Response;
import web.common.exceptions.BusinessException;

public class AjaxResult {

    // 返回状态码   (默认 1000:成功,9999:失败)
    private String code = "1000";

    // 返回的中文消息
    private String message;

    // 成功时携带的数据
    private Object data;

    public AjaxResult(Object data) {
        this.data = data;
        this.code = "1000";
        this.message = "success";
    }

    public AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public AjaxResult(boolean code, String message) {
        this.code = code?"1000":"9999";
        this.message = message;
        this.data = null;
    }
    public AjaxResult(boolean code, Object data) {
        this.code = code?"1000":"9999";
        this.message = null;
        this.data = data;
    }

    public AjaxResult() {
        this.code = "1000";
        this.message = "success";
        this.data = null;
    }
    public AjaxResult(Response response) {
        this.message = response.getReturnMessage();
        this.code = response.getReturnCode();
        this.data = response;
    }

    public String getCode() {
        return code;
    }

    public AjaxResult setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AjaxResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public AjaxResult setData(Object data) {
        this.data = data;
        return this;
    }

    public AjaxResult addSuccess(String message) {
        this.message = message;
        this.code = "1000";
        this.data = null;
        return this;
    }

    public AjaxResult addError(String message) {
        this.message = message;
        this.code = "9999";
        this.data = null;
        return this;
    }
    public AjaxResult addError(String code,Object data) {
        this.message = "调用失败";
        this.code = code;
        this.data = data;
        return this;
    }

    public AjaxResult addError(String code, String message) {
        this.message = message;
        this.code = code;
        this.data = null;
        return this;
    }


    public AjaxResult success(Object data) {
        this.message = "success";
        this.data = data;
        this.code = "1000";
        return this;
    }

    public AjaxResult addError(Response response) {
        this.message = response.getReturnMessage();
        this.code = response.getReturnCode();
        this.data = null;
        return this;
    }

    public AjaxResult addError(BusinessException businessException) {
        this.message = businessException.getErrorMessage();
        this.code = businessException.getErrorCode();
        this.data = null;
        return this;
    }
}
