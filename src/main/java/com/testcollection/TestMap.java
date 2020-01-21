package com.testcollection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 测试Map
 */
public class TestMap {

    //main函数
    public static void  main(String[] args) {

        Map<String,Object> map = new HashMap<> ();
        map.put ("001", "语文");
        map.put ("002", "数学");
        map.put ("003", "英语");
        //打印数据
        print ("1.put（）方法 》添加数据",map);

        // 具备新增、修改功能。如果key存在则修改。
        // 不存在则新增一条新纪录
        map.compute ("004",(k,v)->"英语");
        print ("2.compute（）方法 》新增数据",map);

        map.compute ("001",(k,v)->"文言文");
        print ("3.compute（）方法 》修改数据",map);

        //大小
        int size = map.size ();
        print ("4.size（）方法==》size="+size);

        //找key
        boolean findKey = map.containsKey ("003");
        print ("5.containsKey（）方法 》找到findKey？"+findKey);
        //找value
        boolean findVal = map.containsValue ("英语");
        print ("6.containsValue（）方法 》找到findVal？"+findVal);

        //通过key取value
        Object getvalByKey = map.get ("003");
        print ("7.get（）方法 》getvalByKey = "+getvalByKey);

        //取得所有的key
        Set<String> keySets = map.keySet ();
        print("8.keySet（）方法 》 keySets= "+keySets.toString ());

        //取得所有的value
        Collection collection = map.values ();
        print("9.values（）方法 》collection = "+collection.toString ());

        //替换value，更新的意思，和compute有区别
        map.replace ("004", "历史");
        print ("10.replace()方法==》",map);

    }


    /**
     * 打印map
     * @param map
     */
    public static <accept> void print(String msg,Map map) {
        print (msg+"map==>输出结果：");

        //打印方式1:老式========================
        //取到key集合
        /*
        Set<String> set = map.keySet ();
        //对集合set遍历，取得map的 key、value
        set.forEach (index->{
            System.out.println ("key="+index+",value="+map.get (index));
        });
        */
        //print("打印方式2========================");
        //打印方式2：新方式========================
        map.forEach ((key,value)->{
            System.out.println ("key="+key+",value="+value);
        });
    }

    /**
     * 打印对象方法
     * @param object 注意类型是对象Object
     */
    public static void print(Object object) {
        System.out.println (object);
    }
}
