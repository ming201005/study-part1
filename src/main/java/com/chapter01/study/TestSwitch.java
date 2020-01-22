package com.chapter01.study;
/**
 * Switch
 */
public class TestSwitch {

    public static  void main(String[] args) {
        test01();
    }

    /**
     *Test Switch
     */
    public static void test01(){
        int a = 1;
        String rs;
        switch (a){
            case 0:
              rs = "执行到case 0处，a等于"+a;
              break;
            case 1:
                rs = "执行到case 1处，a等于"+a;
                break;
            default:
                rs = "执行到其它处，a等于"+a;
                break;
        }
        System.out.println ("结果==》"+rs);
    }


    /**
     *Test strArr
     */
    public static void test02(){
        String[] strArr = {"张三","李四","王五","王芳","李兰"};
        String rs = "";

        System.out.println ("结果==》"+rs);
    }
}
