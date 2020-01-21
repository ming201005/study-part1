package com.model.singleton;

/**
 * 妻子（演示一夫一妻制）
 */
public class Wife {

    private String name = "小兰";

    //保证了不同线程对这个变量进行操作时的可见性
    // 即一个线程修改了某个变量的值，这新值
    // 对其他线程来说是立即可见的。
    private static volatile Wife myWife = null;

    //禁止外部访问
    private Wife() {

    }

    /**
     * 单例模式入口
     * @return
     */
    public static synchronized Wife getMyWife() {
        if(myWife == null) {
            myWife = new Wife ();
            System.out.println ("你取了一个老婆，她叫："+myWife.getName ());
        }else{
            System.out.println ("法律规定，你已经有老婆，不能再取！");
        }
        return myWife;
    }

    public String getName() {
        return name;
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        //只能创建一个实例
        Wife wife01 =   Wife.getMyWife ();
        //后续不能创建新的实例
        Wife wife02 =   Wife.getMyWife ();

        System.out.println ("你老婆是："+wife01.getName ()
                +"，你第二任老婆有吗？她是："+wife02.getName ());

        System.out.println( wife01==wife02
                ?"失望，没有第二个老婆":"取到了第二个老婆！");
    }
}
