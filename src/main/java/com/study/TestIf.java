package com.study;

/**
 * if语句
 */
public class TestIf {

    public static  void main(String[] args) {
        test01();
    }

    /**
     *
     */
    public static void test01(){
        int  a = 3;
        int  b = 6;
        //条件判断
        if(a*b>15) {
            System.out.println ("程序代码块A");
        }else{
            System.out.println ("程序代码块B");
        }
        System.out.println ("程序结束");
    }
}
