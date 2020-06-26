package cn.tangtj.blogexample.demo1.domain;

import cn.tangtj.blogexample.demo1.convert.WeekDayDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

/**
 * @author TANG
 */
@Data
public class WeekDayReq {

    private WeekDay weekDay;
}
