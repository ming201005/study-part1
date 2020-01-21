package com.study;

/**
 * While
 */
public class TestWhile {

    public static  void main(String[] args) {
        test01();
        test02();
    }

    /**
     * while(条件)
     */
    public static void test01(){
        int max = 10;
        int i = 0;
        System.out.println ("while（条件）输出结果=》》");
        while(i<max){
            System.out.println ("i="+i);
            i++;
        }
    }

    /**
     * do while（条件）
     */
    public static void test02(){

        int max = 10;
        int i = 0;
        System.out.println ("do while（条件）输出结果=》》");
        do{
            System.out.println ("i="+i);
            i++;
        }while(i<max);
    }
}
