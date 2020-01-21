package com.testclass;

/**
 * 孩子
 */
public class Child extends Father {

    //姓名
    private String name;

    //年龄
    private int age;

    //构造方法
    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ChildAction{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "eye='" + this.getEye () + '\'' +
                ", face='" + this.getFace () + '\'' +
                ", nose='" + super.getNose () + '\'' +
                ", money=" + super.getMoney () +
                '}';
    }
}
