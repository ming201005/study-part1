package com.chapter02.testinterface;
/**
 * 孩子
 */
public class Child extends Father implements PersonInterface {
    //年龄
    private int age;
    //构造方法
    public Child(int age) {
        this.age = age;
    }
    @Override
    public void run() {
        System.out.println ("ChildAction==》run：我隔代一次：11.5秒/100米！");
        //调用父类方法
        System.out.println ("下面是我爸爸跑的速度==》");
        super.run ();
    }
    @Override
    public void batTamper() {
        System.out.println ("我跟我爸不易,我脾气随我妈 ！");
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return  super.toString ()+
                ",孩子={" +
                "age=" + age +
                '}';
    }
}
