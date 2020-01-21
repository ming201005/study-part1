package com.study;

/**
 * 关键字
 */
public class TestKeys {

    public static  void main(String[] args) {
        test01();

        test02();
    }

    /**
     *Test 关键字break；
     *
     */
    public static void test01(){

        System.out.println ("=======关键字break=======");
        for(int i = 0 ;i<10 ; i++) {
            System.out.print ("i="+i);
            if(i>3) {
                System.out.println ("  遇到i="+i);
                break;
            }
            System.out.println ("   break后还执行么！");
        }
    }

    /**
     *Test 关键字continue；
     *
     */
    public static void test02(){

        System.out.println ("=======continue=======");
        for(int i = 0 ;i<10 ; i++) {
            System.out.print ("i="+i+"，");
            if(i>3) {
                System.out.println ("  continue之后已经不执行了！");
                continue;
            }
            System.out.println ("  continue后还执行！");
        }
    }


}
