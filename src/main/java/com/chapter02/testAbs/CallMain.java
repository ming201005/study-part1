package com.chapter02.testAbs;
/**
 * 调用方法
 */
public class CallMain {
    /**
     * 调用
     * @param args
     */
    public static void main(String[] args) {
    /**
     * 为了更加明确的分工：
     * 1、由 MyListInterface 提供接口方法
     * 2、由 Person 提供管理属性类
     * 3、由 MyListImpl 实现公共的方法，不能实现的往下放
     * 4、子类如：GrandFatherAction、FatherAction、Child只关注
     *    自己内部具体的行为
     * 5、子类可以都直接继承PersonAction，也可以继承PersonAction子类
     *    的子类，如：Father直接继承PersonAction，而Child继承GrandFather
     * 6、调用时候，可以声明为抽象类，PersonAction类型，如果切换具体的实现类
     *    只把new之后改动即可。从而达到了提高代码的复用率，修改和重构时改动小。
     * 总之，大原则是：分离出属性、行为。
     */
        //用PersonInterface接口定义 对象类型。
        PersonInterface person = new ChildAction ();

        //把创建人的工作交给抽象类完成
        person.setPersonEntity (new Boy(
                "500234519981205112988",
                "刘军军",
                "眼睛度数5.8",
                "方正脸",
                "鹰钩鼻"));
        //基本信息
        System.out.println (person.getPersonEntity ().getName ()
                +"的基本信息==>>"+person.getPersonEntity ().toString ());
        //跑的行为
        person.run ();

        System.out.println ("----------我只是一个分隔符---------");

        //创建一个爸爸对象。注意：下方调用一个都不用改动！
        person = new FatherAction ();
        //把创建人的工作交给抽象类完成
        person.setPersonEntity (new PersonEntity (
                "50023451969120511666",
                "刘大能",
                "高度近视",
                "国字脸",
                "大鼻子"));
        //基本信息
        System.out.println (person.getPersonEntity ()
                .getName ()+"的基本信息==>>"
                +person.getPersonEntity ().toString ());
        //跑的行为
        person.run ();
    }
}
