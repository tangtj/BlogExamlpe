package cn.tangtj.blogexample.demo1.domain;

/**
 * @author TANG
 */

public enum WeekDay implements BaseEnum {

    Mon(1),

    Tue(2),

    Wed(3),

    Thu(4),

    Fri(5),

    Sat(6),

    Sun(7);

    private final int code;

    WeekDay(int code){
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
