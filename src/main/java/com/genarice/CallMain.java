package com.genarice;
/**
 * 测试类
 */
public class CallMain {
    /**
     * main函数
     */
    public static void main(String[] args) {
        System.out.println ("1.入对象Person======================");
        //入对象Person
        MyListInterface<Person> pList = new MyListImpl<> ();
        initPersonData(pList);
        pList.getList ().forEach (System.out::println);
        System.out.println ("2.入对象String======================");
        //入对象String
        MyListInterface<String> strList = new MyListImpl<> ();
        initCourseData(strList);
        strList.getList ().forEach (System.out::println);
    }
    /**
     * 初始化数据人
     */
    public static void initPersonData(MyListInterface personAction) {
        Person[] persons = new Person[10];
        for (int i=0;i<10;i++) {
            persons[i] = new Person (i, "张三("+i+")");
        }
        //统一新增数据
        personAction.add(persons);
    }
    /**
     * 初始化科目
     */
    public static void initCourseData(MyListInterface personAction) {
        String[] course = {"语文","数学","英语","化学","物理"};
        //统一新增数据
        personAction.add(course);
    }

}
