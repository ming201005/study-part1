package com.chapter01.study;

/**
 * for循环
 */
public class TestFor {

    public static  void main(String[] args) {
        test01();
        test02();
    }

    /**
     * for(; ; ; )
     */
    public static void test01(){
        int max = 100;
        for(int i = 0; i<max; i++){
            System.out.println ("i="+i);
        }
    }

    /**
     * for( : )
     */
    public static void test02(){

        int[] arr = {1,2,4,6,7};

        for(int item :arr){
            System.out.println ("item="+item);
        }
    }
}
