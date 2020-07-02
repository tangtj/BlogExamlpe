package cn.tangtj.blogexample.demo3.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ValidInput {

    @NotNull
    @Min(value = 1,message = "最小不能小于1")
    private Integer value;
}
