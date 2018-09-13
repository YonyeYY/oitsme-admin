package web.common.exceptions;

import com.oitsme.admin.fad.common.dto.Response;

public class BusinessException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
    /**
     * 错误时返回的url
     */
    private String backUrl;

    private boolean redirect = false;

    private static final long serialVersionUID = 1L;

    public BusinessException(Response response) {
        super(response.getReturnMessage());
        this.errorMessage = response.getReturnMessage();
        this.errorCode = response.getReturnCode();
    }

    public BusinessException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = "9999";
        this.redirect = false;
    }

    public BusinessException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.redirect = false;
    }

    /**
     * 抛异常后返回地址需要客户自己手动点击后才能进行返回
     *
     * @param errorCode
     * @param errorMessage
     * @param backUrl
     */
    public BusinessException(String errorCode, String errorMessage, String backUrl) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.backUrl = backUrl;
        this.redirect = false;
    }

    /**
     * 抛异常后返回地址直接后台重定向
     *
     * @param errorCode
     * @param errorMessage
     * @param backUrl
     */
    public BusinessException(String errorCode, String errorMessage, String backUrl, boolean redirect) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.backUrl = backUrl;
        this.redirect = redirect;
    }

    public BusinessException(String errorCode, String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", backUrl='" + backUrl + '\'' +
                ", redirect=" + redirect +
                '}';
    }

    public boolean isRedirect() {
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }
}

