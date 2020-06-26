package cn.tangtj.blogexample.demo1.web;


import cn.tangtj.blogexample.demo1.domain.WeekDay;
import cn.tangtj.blogexample.demo1.domain.WeekDayReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TANG
 */
@RestController
@RequestMapping("/demo1")
public class WeekDayController {

    @PostMapping("/put")
    public Object req(@RequestBody WeekDayReq req){
        WeekDay day = req.getWeekDay();
        System.out.println("收到WeekDay参数:" + day);
        System.out.println("收到WeekDay参数Code值:" + day.getCode());
        return day;
    }
}
