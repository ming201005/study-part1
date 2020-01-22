package com.chapter02.testclass;

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
        Child child = new Child ("晓东",12);
        //由于爸爸取了外国人，孩子眼睛是蓝色的（爷爷眼睛是深邃的）
        child.setEye ("蓝眼睛");
        //看看孩子名字、长相，其他方面都没变，基因强悍，继承父辈。
        System.out.println (child.toString ());
        //孩子完全继承了爷爷跑得快的行为。
        child.run ();
    }
}
