package com.testTrycatch;

/**
 * 描述：本类有什么功能？
 * 1、TODO
 * 2、TODO
 * 3、TODO
 *
 * @author ming
 * @version 1.0
 * @date 2019-11-21 21:31
 * @see
 */
public class testTryCatch {

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {

        testTryCatch01(5,0);

        testTryCatch02(null,0);

        testThrow(5,0);

        //调用时需要铺获，否则提示错误。
        try {
            testThrows(null,0);
        }catch (Exception e) {
            e.printStackTrace ();
        }

        try {
            testFinally(-2,0);
        }catch (Exception e) {
            e.printStackTrace ();
        }
    }

    /**
     * try catch一个
     * @param a
     * @param b
     */
    public static void testTryCatch01(int a,int b){
        try{
            int c = a/b;
            System.out.println ("a/b="+c);
        }catch (Exception e) {
            System.out.println("错误信息："+e.getMessage ());
        }
    }

    /**
     * try catch多个
     * @param a
     * @param b
     */
    public static void testTryCatch02(Integer a,int b){
        try{
            String rs = a.toString ();
            int c = a/b;
            System.out.println ("a/b="+c);
        }catch (NullPointerException e) {
            System.out.println("空指针错误："+e.getMessage ());
        }catch (Exception e) {
            System.out.println("错误信息："+e.getMessage ());
        }
    }

    /**
     * Throw
     * @param a
     * @param b
     */
    public static void testThrow(Integer a,int b) {
        try{
            if (a == null) throw new Exception ("a不能为空！");
            if (b == 0) throw new Exception ("b不能等于0 ！");

            String rs = a.toString ();
            int c = a/b;
            System.out.println ("a/b="+c);
        }catch (Exception e) {
            System.out.println("错误信息："+e.getMessage ());
        }
    }

    /**
     * Throws
     * @param a
     * @param b
     */
    public static void testThrows(Integer a,int b)
            throws Exception {

        if (a == null) throw new Exception ("a不能为空！");
        if (b == 0) throw new Exception ("b不能等于0 ！");
        //如果上面没有抛出异常才能执行到这里
        int c = a/b;
        System.out.println ("a/b="+c);
    }

    /**
     * Finally,throws
     * @param a
     * @param b
     */
    public static void testFinally(Integer a,int b)
            throws Exception {
        try {
            if (a<0) throw new Exception ("a必须大于0");
            if (b == 0) throw new Exception ("b不能等于0 ！");
            //TODO
            int c = a / b;
            System.out.println ("a除以b=" + c);
        }
        finally {
            System.out.println ("执行 finally块代码。");
        }
    }
}
