package cn.tangtj.blogexample.demo3.service;

import cn.tangtj.blogexample.demo2.domain.RequestInfo;
import cn.tangtj.blogexample.demo3.domain.RequestTokenInfo;
import lombok.SneakyThrows;
import org.springframework.core.Conventions;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author TANG
 */
@Component
public class RequestTokenWithValidArgResolver extends AbstractMessageConverterMethodProcessor implements HandlerMethodArgumentResolver {

    public RequestTokenWithValidArgResolver(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return RequestTokenInfo.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest req = webRequest.getNativeRequest(HttpServletRequest.class);
        if (req == null) {
            return null;
        }
        String addr = req.getRemoteAddr();
        RequestTokenInfo info = new RequestTokenInfo();
        info.setRequestIp(addr);
        String token = req.getHeader("token");
        info.setToken(token);

        String name = Conventions.getVariableNameForParameter(parameter);
        if (binderFactory != null) {
            WebDataBinder binder = binderFactory.createBinder(webRequest, info, name);
            validateIfApplicable(binder, parameter);
            if (binder.getBindingResult().hasErrors() && isBindExceptionRequired(binder, parameter)) {
                throw new MethodArgumentNotValidException(parameter, binder.getBindingResult());
            }
        }
        return info;
    }

    /**
     * 不需要支持的方法
     *
     * @param returnType
     * @return
     */
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return false;
    }

    /**
     * 不需要支持的方法
     *
     * @param returnType
     * @return
     */
    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
    }
}
