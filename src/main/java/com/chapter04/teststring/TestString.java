package com.chapter04.teststring;

/**
 * 字符串类测试 StringBuffer
 */
public class TestString {

    public static void main(String[] args)
    {
        testStringBuffer();
    }

    /**
     * StringBuffer
     */
    public static void testStringBuffer() {
        StringBuffer str = new StringBuffer ();
        str.append ("我");
        str.append ("是中国人");
        str.append (",我爱我中华！");
        print("------------------append:");
        print (str);

        int start = str.indexOf (",");
        print ("找','位置，start="+start);
        str.insert (start+1, "我心中的祖国很伟大。");
        print("------------------insert:");
        print (str);
    }

    /**
     * StringBuilder
     */
    public static void testStringBuilder() {
        StringBuilder sql = new StringBuilder ();
        //todo
    }


    public static void print(Object o) {
        System.out.println (o);
    }
}
