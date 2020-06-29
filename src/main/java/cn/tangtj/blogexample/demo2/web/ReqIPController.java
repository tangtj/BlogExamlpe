package cn.tangtj.blogexample.demo2.web;

import cn.tangtj.blogexample.demo2.domain.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ip")
public class ReqIPController {

    @GetMapping
    public Object req(RequestInfo requestInfo){
        return requestInfo;
    }
}
