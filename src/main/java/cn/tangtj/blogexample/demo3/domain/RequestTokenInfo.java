package cn.tangtj.blogexample.demo3.domain;

import javax.validation.constraints.NotNull;

public class RequestTokenInfo {

    private String requestIp;

    @NotNull(groups = Auth.class)
    private String token;

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public interface Auth{}

}
