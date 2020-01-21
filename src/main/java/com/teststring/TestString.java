package com.teststring;

public class TestString {

    public static void main(String[] args)
    {
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

    public static void print(Object o) {
        System.out.println (o);
    }
}
