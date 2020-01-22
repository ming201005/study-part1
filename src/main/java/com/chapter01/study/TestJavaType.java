package com.chapter01.study;
import java.math.BigDecimal;
/**
 * java类型
 */
public class TestJavaType {
    //数字超出范围自动报错
    static  byte aByte    = -10;
    static short aShort   = 30000;
    static int anInt      = 2000000000;
    //数字后面加"L"，也可以加"l"，但是建议要大写L
    static long aLong     = 999999999999999999L;
    //数字后面加"F"，不加报错
    static float aFloat   = 20.34888888888888888F;
    //数字后面加"D"
    static double aDouble = 256500990000006544000005.56543D;
    static boolean aBool  = true;
    //用单引号，不能用双引号，切单引号里面只能一个字（储存任何字符）。
    static char aChar     = '好';
    static char bChar     = 'A';
    static char cChar     = '1';

    static String str01         = "我是张三";

    static String strPrice      = "45533434.6449999999999900099988999999888";

    static BigDecimal bDecimal1 = new BigDecimal(45533434.6449999999999900099988999999888D);

    static BigDecimal bDecimal2 = new BigDecimal(Double.valueOf(strPrice) );

    static double bDouble = Double.valueOf(strPrice);

    //测试打印
    public static void main(String[] args) {
        pring("aByte="+aByte);
        pring("aShort="+aShort);
        pring("anInt="+anInt);
        pring("aLong="+aLong);
        pring("aFloat="+aFloat);
        pring("aDouble="+aDouble);
        pring("aBool="+aBool);
        pring("aChar="+aChar);
        pring("bChar="+bChar);
        pring("cChar="+cChar);

        //计算 Byte+Short后自动换成大类型【注意和字符串连要先加括号（）】
        pring("aByte+aShort="+(aByte+aShort));

        //段类型可以赋值给大类型。
        aShort = aByte;
        pring("aByte赋值给aShort后="+aShort);

        //aFloat强制转换成int
        int temp = (int) aFloat;
        pring("aFloat强制转换成int后，temp="+temp);

        pring("str01="+str01);
        pring("strPrice="+strPrice);
        pring("bDecimal1="+bDecimal1);
        pring("bDecimal2="+bDecimal2);
        pring("bDouble="+bDouble);

        System.out.println ("类型判断："+str01 instanceof String);

    }

    //打印方法
    public static void  pring(Object o) {
        System.out.println (o);
    }
}
