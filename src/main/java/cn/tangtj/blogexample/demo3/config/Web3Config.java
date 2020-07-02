package cn.tangtj.blogexample.demo3.config;

import cn.tangtj.blogexample.demo3.service.RequestTokenWithValidArgResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class Web3Config implements WebMvcConfigurer {

    public final RequestTokenWithValidArgResolver requestTokenWithValidArgResolver;

    public Web3Config(RequestTokenWithValidArgResolver requestTokenWithValidArgResolver) {
        this.requestTokenWithValidArgResolver = requestTokenWithValidArgResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(requestTokenWithValidArgResolver);
    }
}
