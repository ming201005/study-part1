package com.chapter04.testnumber;
/**
 * Number类
 */
public class TestNumbers {
    public static void main (String[] args)
    {
        Byte    aByte       = 50;
        Short   aShort      = 5445;
        Integer integer     = 999999999;
        //L结尾
        Long    aLong       = 998990L;
        //D结尾
        Double  aDouble     = 9999999D;
        //F结尾
        Float   aFloat      = 2355F;
        //数组
        Float[]   floats    = new Float[]{12F, 34F, 1F, 50F, 16F};
        //组装
        String rs = "TestNumbers{" +
                "aByte=" + aByte +
                ", integer=" + integer +
                ", aDouble=" + aDouble +
                ", aFloat=" + aFloat +
                ", aShort=" + aShort +
                ", aLong=" + aLong +
                ", floats="+ floats[0]+","+floats[1]+
                '}';
        p(rs);
        p("90 度的正弦值：" + Math.sin(Math.PI/2));
        p("0度的余弦值：" + Math.cos(0));
        p("60度的正切值：" + Math.tan(Math.PI/3));
        p("1的反正切值： " + Math.atan(1));
        p("π/2的角度值：" + Math.toDegrees(Math.PI/2));
        p(Math.PI);
    }

    /**
     * 打印
     * @param msg
     */
    public static void p(Object msg) {
        System.out.println(msg);
    }
}
