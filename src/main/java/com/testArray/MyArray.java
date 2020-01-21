package com.testArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 数组
 */
public class MyArray {

    public static void  main(String[] args) {
        print ("---------分割线----------一维数组");
        test01 ();
        print ("---------分割线----------二维数组");
        test02();
        print ("---------分割线----------查找数组数据");
        testArrayBinarySearch();
        print ("---------分割线----------Compare比较两个数组");
        testArrayCompare();
        print ("---------分割线----------Equals比较两个数组");
        testArrayEquals();
        print ("---------分割线----------升序排序(默认)");
        testArrayEqualSortASC();
        print ("---------分割线----------自定义升序(实现接口)");
        testArrayEqualSortDESC();
    }

    /**
     *  一维数组
     */
    public static void test01(){
        //一维数组
        int[] numbers = {1,2,4,5,7,9,10,15};
        //1、循环数组
        for(int i=0; i<numbers.length; i++ ) {
            print (numbers[i]);
        }
    }

    /**
     *  二维数组
     */
    public static void test02(){
        //二维数组
        String[][] persons = {
                {"1","张三","男","18岁"},
                {"2","小兰","女","23岁"},
                {"3","李四","男","25岁"}
        };
        //循环数组
        for(int i=0; i<persons.length; i++ ) {;
            int j = 0;
            do{
                System.out.print (persons[i][j++]+" ");
            }while ( j < persons[i].length);
            print ("");
        }
    }

    /**
     * binarySearch
     */
    public static void testArrayBinarySearch() {
        int[] numbers = {18,20,46,5,7,9,10,15};
        //查找数组有没有9，如果找到返回下标位置，找不到返回小于0的数
        //该方法是排序号后查找，如果数组还没排序号，此方法不起作用。
        //先排序，默认是小到大排序
        Arrays.sort (numbers);
        //再查找
        int index =  Arrays.binarySearch (numbers, 9);
        print ("查找情况="+index+(index>0?
                "，找到："+ numbers[index]:"，数组中没有。"));
    }

    /**
     * compare
     */
    public static void testArrayCompare() {
        String[] a = {"A","B","c"};
        String[] b = {"G","b","c","张三","李兰"};
        //比较数组，相等时返回0，不相等返回小于0的数
        int rs =  Arrays.compare (a, b);
        print (rs);
    }

    /**
     * equals
     */
    public static void testArrayEquals() {
        String[] a = {"A","B","c"};
        String[] b = {"G","b","c","张三","李兰"};
        //比较数组，相等时返回0，不相等返回小于0的数
        boolean rs =  Arrays.equals (a, b);
        print (rs);
    }

    /**
     * Sort ASC 升序
     */
    public static void testArrayEqualSortASC() {
        String[] arr = {"G","B","U","C","A"};
        print("排序---------------------》前");
        for(int i=0; i<arr.length; i++ ) {
            print (arr[i]);
        }
        print("排序---------------------》后");
        //排序
        Arrays.sort (arr);
        for(int i=0; i<arr.length; i++ ) {
            print (arr[i]);
        }
    }

    /**
     * Sort DESC 倒序（或自定义排序）
     */
    public static void testArrayEqualSortDESC() {
        String[] arr = {"李小兰","B","Ag","刘先生","张飞"};
        print("自定义排序(降序)-----------------》前");

        for(int i=0; i<arr.length; i++ ) {
            print (arr[i]);
        }
        //排序------写法1
        Arrays.sort (arr, new Comparator<String> () {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase (o1);
            }
        });

        //排序------写法2
        Arrays.sort (arr, (o1,o2) ->{
            return o2.compareToIgnoreCase (o1);
        });

        print("自定义排序---------------------》后");
        for(int i=0; i<arr.length; i++ ) {
            print (arr[i]);
        }
    }

    /**
     * 打印方法
     * @param o
     */
    public static void print(Object o) {
        System.out.println (o);
    }
}
