package cn.tangtj.blogexample.demo3.web;

import cn.tangtj.blogexample.demo3.domain.RequestTokenInfo;
import cn.tangtj.blogexample.demo3.domain.ValidInput;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valid")
public class ValidController {

    @PostMapping("/valid")
    public Object valid(@Validated @RequestBody ValidInput input){
        return input;
    }

    @GetMapping("/auth")
    public Object auth(@Validated(RequestTokenInfo.Auth.class) RequestTokenInfo info){
        System.out.println("need auth request"+info);
        return info;
    }


    @GetMapping("/open")
    public Object open(RequestTokenInfo info){
        System.out.println("need auth request"+info);
        return info;
    }
}
