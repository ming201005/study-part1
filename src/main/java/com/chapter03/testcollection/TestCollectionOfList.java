package com.chapter03.testcollection;

import java.util.*;

/**
 * 测试集合——List
 */
public class TestCollectionOfList {
    //main函数
    public static void  main(String[] args) {
        List list =  new ArrayList ();
        //1.给list添加数据一个一个的加
        list.add ("语文");
        list.add ("数学");
        list.add ("英语");

        //2.打印输出======================
        print (list);

        //3.数组转换成List，再装进去
        list.addAll (Arrays.asList ("物理","化学"));

        //4.打印输出======================
        print (list);

        //5.创建一个新的List数据，再装进去
        List myList = new ArrayList ();
        myList.add ("生物");
        myList.add ("地理");
        myList.add ("历史");

        //6.直接将整个集合放进去,并从第三个开始插入
        list.addAll (2,myList);

        //7.打印输出======================
        print (list);

        //8.查找是否存在，只返回真假
        boolean find = list.contains ("中文");
        print ("找到？"+find);

        print ("forEach方式打印输出结果=========");
        //9.用forEach遍历List对象
        list.forEach (item->{
            //这里可以加很多逻辑
            //TODO
            print (item);
        });

        //10.从list取数据，通过索引取值（开始：0）
        Object object = list.get (5);
        print ("取在第6个位置的数据："+object);

        //11.查找并返回索引
        int indexOf = list.indexOf ("地理");
        print ("indexOf 结果==》"+indexOf);

        //12.remove删除数据（有两个重载方法，一个传数据，一个传索引值）
        list.remove ("地理");
        print (list);

        //13.removeAll删除数据（有两个重载方法，一个传数据，一个传索引值）
        list.removeAll (Arrays.asList ("化学","英语","生物"));
        print (list);

        //14.更新第三个数据
        list.set (2, "中国历史");
        print (list);

        //15.sort排序（通过Comparator接口方法灵活实现）
        //事实上对中文排序是没有意义的，一般也只是对英文排序
        //更多的场景是List内装对象或Map之类，再对对象排序比较。
        list.sort (new Comparator<String> () {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo (o2);
            }
        });
        print (list);
    }

    /**
     * 打印集合方法
     * @param collection 注意类型是集合Collection
     */
    public static void print(Collection collection) {
        print ("printList==>输出结果：");
        //可以用forEach简化打印
        collection.forEach (System.out::println);
    }

    /**
     * 打印对象方法
     * @param object 注意类型是对象Object
     */
    public static void print(Object object) {
        System.out.println (object);
    }
}
