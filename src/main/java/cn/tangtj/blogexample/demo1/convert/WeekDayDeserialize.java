package cn.tangtj.blogexample.demo1.convert;

import cn.tangtj.blogexample.demo1.domain.WeekDay;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class WeekDayDeserialize extends JsonDeserializer<WeekDay> {

    public WeekDayDeserialize(){
        System.out.println(1);
    }

    @Override
    public WeekDay deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        int value = p.getValueAsInt();

        for (WeekDay d:WeekDay.values()){
          if (value == d.getCode()){
              return d;
          }
        }
        return null;
    }
}
