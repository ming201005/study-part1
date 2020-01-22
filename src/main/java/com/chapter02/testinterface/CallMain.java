package com.chapter02.testinterface;
/**
 * 调用方法
 */
public class CallMain {
    /**
     * 调用
     * @param agrs
     */
    public static void main(String[] args) {
        //创建孩子类对象
        Child child =  new Child (23);
        child.setIdCard ("500234519981205112988");
        child.setName ("刘小翔");
        child.setEye ("眼睛度数5.2");
        child.setFace ("国字脸");
        child.setNose ("高鼻子");
        //基本信息
        System.out.println ("刘小翔基本信息==>>"+child.toString ());
        //孩子跑的行为
        child.run ();
    }
}
