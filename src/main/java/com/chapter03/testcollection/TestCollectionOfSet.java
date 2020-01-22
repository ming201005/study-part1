package com.chapter03.testcollection;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 测试集合——Set
 */
public class TestCollectionOfSet {
    //main函数
    public static void  main(String[] args) {
        Set set =  new HashSet ();
        //1.给set添加数据
        //  不能重复，重复自动覆盖
        set.add (2);
        set.add (2);
        set.add ("数学");
        set.add ("语文");

        //2.打印输出======================
        print (set);

        //3.数组转换成List，再装进去,
        // set不能和List一样可以插入到具体的位置
        // 插入数据有重复自动覆盖之前的数据
        set.addAll (Arrays.asList ("生物","数学"));
        //4.打印输出======================
        print (set);

        //5.查找是否存在，只返回真假
        boolean find = set.contains ("生物");
        print ("找到？"+find);

        print ("forEach 打印输出结果=========");
        //6.用forEach遍历set对象
        set.forEach (item->{
            print (item);
        });

        //7.remove删除数据
        // 不能传索引删除，因为索引随时有变化
        set.remove ("地理");
        print (set);

        //8.removeAll删除数据
        //   不能传索引删除，因为索引随时有变化
        set.removeAll (Arrays.asList ("化学","英语","生物"));
        print (set);

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
