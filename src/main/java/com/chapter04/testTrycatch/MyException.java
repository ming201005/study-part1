package com.chapter04.testTrycatch;

/**
 * 自定义异常类
 */
public class MyException extends  Exception {
    public  MyException(){
    }

    public MyException(String errMsg) {
        super(errMsg);
    }
}
