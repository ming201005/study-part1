package com.chapter03.testcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 测试集合的类（用类的方式来封装）
 */
public class MyCollection {

    //1.创建List对象
    public List list;

    /**
     * 主方法
     * @param agrs
     */
    public static void  main(String[] args) {
        MyCollection myCollection = new MyCollection();

        //1.给list添加数据一个一个的加
        myCollection.add ("语文");
        myCollection.add ("数学");
        myCollection.add ("英语");

        //2.打印输出======================
        print (myCollection.getList ());

        //3.用数组的方式添加数据
        myCollection.add (new String[]{"物理","化学"});

        //4.打印输出======================
        print (myCollection.getList ());

        //5.创建一个新的List数据
        List myList = new ArrayList ();
        myList.add ("生物");
        myList.add ("地理");
        myList.add ("历史");

        //6.直接将整个集合放进去
        myCollection.add (myList);

        //7.打印输出======================
        print (myCollection.getList ());
    }

    /**
     * 构造函数
     */
    MyCollection(){
        //类被创建时（实例化），创建list对象
        this.list =  new ArrayList();
    }

    /**
     * 添加数据-添加对象
     * @param object
     */
    public void add(Object object) {
        //调用list自有方法add
        this.list.add (object);
    }

    /**
     * 添加数据——添加数组
     * @param object
     */
    public void add(Object[] object) {
        //将数组转成List
        List subList = Arrays.asList (object);
        //调用本类的add方法(这回参数是Collection)
        this.add (subList);
    }

    /**
     * 添加数据——添加集合
     * @param collection
     */
    public void add(Collection collection) {
        this.list.addAll (collection);
    }


    public List getList() {
        return list;
    }

    /**
     * 打印集合方法
     * @param collection 注意类型是集合Collection
     */
    public static void print(Collection collection) {
        print ("printList==>输出结果：");
        for (Object  course: collection) {
            System.out.println (course);
        }
    }

    /**
     * 打印对象方法
     * @param object 注意类型是对象Object
     */
    public static void print(Object object) {
        System.out.println (object);
    }


}
