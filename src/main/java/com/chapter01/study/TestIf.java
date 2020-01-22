package com.chapter01.study;

/**
 * if语句
 */
public class TestIf {

    public static void main(String[] args) {
        test01();

        test02();
    }

    /**
     * if
     */
    public static void test01() {
        int a = 5;
        //判断如果a大于5，就做if内部的程序块
        if (a > 5) {
            System.out
                    .println("a大于5，执行到这里！");
        }
        System.out.println("程序结束。");
        //程序输出结果是没有走if内的，可以通过改变
        //a的值来跟踪程序的走向
    }

    /**
     * if else
     */
    public static void test02() {
        int a = 3;
        int b = 6;
        //条件判断
        if (a * b > 15) {
            System.out.println("程序代码块A");
        } else {
            System.out.println("程序代码块B");
        }
        System.out.println("程序结束");
    }


}
