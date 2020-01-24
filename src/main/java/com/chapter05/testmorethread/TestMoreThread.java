package com.chapter05.testmorethread;

/**
 * 线程测试
 */
public class TestMoreThread {

    //商品生产总量
    public long productProviderCount;

    //通知生产
    public boolean isProvider = false;

    /**
     * 线程测试主函数
     * @param args
     */
    public static void main(String[] args) {
        TestMoreThread testMoreThread = new TestMoreThread ();
        testMoreThread.test ();
    }

    /**
     * 测试方法
     */
    public void test() {
        //1、生产产品========================
        ProductProvider productProvider = new ProductProvider ();
        productProvider.setProviderNum (50);
        //3台设备生产产品
        for (int i = 0; i < 3; i++) {
            new Thread (productProvider, "设备-" + i).start ();
        }

        //1、销售产品========================
        ProductSale productSale = new ProductSale ();
        //创建5线程-销售
        new Thread (productSale, "销售员-A" ).start ();
        new Thread (productSale, "销售员-B" ).start ();
        new Thread (productSale, "销售员-C" ).start ();
        new Thread (productSale, "销售员-D" ).start ();
        new Thread (productSale, "销售员-E" ).start ();

    }

    /**
     * 销售商品
     */
    class ProductSale implements Runnable {

        //一直在销售，永远不停止
        int[] nums = {23, 50, 35, 28, 52, 85};
        int saleNum;

        @Override
        public void run() {
            this.sale ();
        }

        public void sale() {

            int n = (int) Math.round (Math.random () * 5);
            saleNum = this.nums[n];
            try {
                if (productProviderCount > 0 && saleNum < productProviderCount) {

                    productProviderCount = productProviderCount - saleNum;
                    System.out.println ("本次销售：" + Thread.currentThread ().getName ()
                            + "====>" + saleNum + ";库存还有=" + productProviderCount);
                    isProvider = true;
                    Thread.sleep (1000);
                    sale ();

                } else {

                    System.out.println ("没有货了，请加快生产");
                    isProvider = false;
                    Thread.sleep (2000);
                    sale ();
                }
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }

    /**
     * 生产商品
     */
    class ProductProvider implements Runnable {

        int providerNum;

        @Override
        public void run() {
            this.provider ();
        }

        public void provider() {
            //3秒钟出产
            productProviderCount = productProviderCount + providerNum;
            System.out.println ("目前产量是：" + Thread.currentThread ().getName () + "=>>" + productProviderCount);
            try {
                Thread.sleep (3000);
                provider ();
            } catch (Exception e) {
                e.printStackTrace ();
            }

        }

        public void setProviderNum(int providerNum) {
            this.providerNum = providerNum;
        }
    }

}
