package cn.tangtj.blogexample.demo2.config;

import cn.tangtj.blogexample.demo2.domain.RequestInfo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class RequestIpArgResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return RequestInfo.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest  req = webRequest.getNativeRequest(HttpServletRequest.class);
        if(req == null){
            return null;
        }
        String addr = req.getRemoteAddr();
        RequestInfo info = new RequestInfo();
        info.setRequestIp(addr);
        return info;
    }
}
