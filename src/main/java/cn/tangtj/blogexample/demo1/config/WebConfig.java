package cn.tangtj.blogexample.demo1.config;

import cn.tangtj.blogexample.demo1.convert.EnumModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter){
                ObjectMapper o = ((MappingJackson2HttpMessageConverter) converter).getObjectMapper();
                o.registerModule(new EnumModule());
            }
        }
    }
}
