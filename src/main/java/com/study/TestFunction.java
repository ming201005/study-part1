package com.study;

/**
 * java方法
 */
public class TestFunction {

    //不传任何参数，也叫无参构造器
    public TestFunction(){
        //TODO
    }
    //有参数，也叫有参构造器
    public TestFunction(String p1,int p2){
          //TODO
    }

    public static  void main(String[] args) {

        //=================================
        //1、调用没参数,没返回值方法
        fun01();

        //=================================
        //2、没参数，有返回值
        String str = fun02();
        //把结果打印出来
        System.out.println (str);

        //=================================
        //3、有参数和有返回值
        //也可以事先定义要传入的参数，如p1是第一个参数
        byte p1 = 2;
        int rs = fun03(p1, 5, 'B');
        //输出结果
        System.out.println ("fun03返回结果====>"+rs);

        //=================================
        //4、调用可变参数
        //不传参数
        fun04();
        //传多个参数，用逗号分开，如下：
        fun04(3,9,10,20);

        //=================================
        //5、
        //要有对象被创建
        new  TestFunction();
        //需要手动清理垃圾，finalize方法才起作用
        System.gc();
    }


    /**
     * 没参数,没返回值
     */
    public static void fun01(){
        System.out.println ("fun01====>我没参数也没返回值！");
    }


    /**
     * 没参数，有返回值
     */
    public static String fun02(){
        return "fun02====>我返回字符串！";
    }

    /**
     * 有参数，有返回值
     */
    public static int fun03(byte param1, int param2, char type) {
        //定义一个int参数接收 param1 + param2的结果
        int result = param1 + param2;
        //判断一下，回顾一下之前讲的if控制语句
        if('A'==type){
            result = result * 10;
        }else if('B'==type){
            result = result * 100;
        }else{
            result = result * 1000;
        }
        //返回
        return result;
    }

    /**
     * 可变参数，一个方法只能有一个可变参数，且必须放在最后一个
     */
    public static void fun04(int ... param) {
        System.out.println ("fun04===>参数个数："+param.length );
        for(int item : param ) {
            System.out.println ("可变参数是：" + item);
        }
    }

    /**
     * java中一般是不需要手写这个方法的。
     */
    protected void  finalize(){

        System.out.println ("finalize===》我被调用了！");
    }

}
