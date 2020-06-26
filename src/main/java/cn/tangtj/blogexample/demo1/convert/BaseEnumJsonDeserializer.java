package cn.tangtj.blogexample.demo1.convert;

import cn.tangtj.blogexample.demo1.domain.BaseEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

/**
 * @author TANG
 */
public class BaseEnumJsonDeserializer<T extends Enum<T> & BaseEnum> extends JsonDeserializer<T> {

    private final Class<T> clz;

    private final T[] clzEnums;

    public BaseEnumJsonDeserializer(Class<T> t){
        this.clz = t;
        this.clzEnums = t.getEnumConstants();
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        int value = p.getValueAsInt();
        for (T clzEnum : clzEnums) {
            if (value == clzEnum.getCode()) {
                return clzEnum;
            }
        }
        return null;
    }
}
