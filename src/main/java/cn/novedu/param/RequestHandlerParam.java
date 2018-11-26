package cn.novedu.param;

public class RequestHandlerParam {
    /**
     * 请求的id
     */
    private String requestId;
    /**
     * 是否接受
     */
    private boolean accecpt;

    public RequestHandlerParam(String requestId, boolean accecpt) {
        this.requestId = requestId;
        this.accecpt = accecpt;
    }

    public RequestHandlerParam() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isAccecpt() {
        return accecpt;
    }

    public void setAccecpt(boolean accecpt) {
        this.accecpt = accecpt;
    }
}
