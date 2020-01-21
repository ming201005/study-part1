package com.testclass;
/**
* 定义 "人" (以下用中文来描述)
*/
public class 人 {

    //一些属性
    private String 身份证号;
    private String 姓名;
    private char   性别 = '男';
    private short  年龄 = 0;
    private String 籍贯;

    /**
     * 吃饭
     */
    public void 吃饭() {
        if('男'==性别){
            System.out.println (this.姓名+"是"+this.性别
                    +"的，要吃两碗以上！");
        }else {
            System.out.println (this.姓名+"是"+this.性别
                    +"的，只吃半碗饭，减肥中...");
        }
    }

    /**
     * 睡觉
     * @param 睡觉时间
     * @param 起床时间
     * @return 睡眠情况
     */
    public String 睡觉(int 睡觉时间, int 起床时间) {
        int 睡眠时间 = 起床时间-睡觉时间;
        String 睡眠情况 = "";
        if(睡眠时间>8) {
            睡眠情况 = "睡够了，睡了("+睡眠时间+")个小时";
        }else {
            睡眠情况 = "还没睡够，只睡了("+睡眠时间+")个小时";
        }
        return 睡眠情况;
    }

    //其他行为
    //TODO

    public static void main(String[] args) {
        人 第1个人 = new 人 ();
        //给"第一个人"这个实例填充属性值
        第1个人.set身份证号 ("50024543543567");
        第1个人.set姓名 ("张三");
        第1个人.set性别 ('男');
        第1个人.set年龄 ((short) 19);
        第1个人.set籍贯 ("广东广州市");

        //第一个人的吃饭行为
        第1个人.吃饭 ();

        //第一个人的睡觉行为
        String 睡觉结果 = 第1个人.睡觉 (9, 15);
        System.out.println (第1个人.get姓名 ()+睡觉结果);

        System.out.println("============再造一个人出来============");

        人 第2个人 = new 人 ();
        //给"第一个人"这个实例填充属性值
        第2个人.set身份证号 ("50024519891209245677");
        第2个人.set姓名 ("小兰");
        第2个人.set性别 ('女');
        第2个人.set年龄 ((short) 25);
        第2个人.set籍贯 ("重庆江北区");

        //第一个人的吃饭行为
        第2个人.吃饭 ();

        //第一个人的睡觉行为
        String 结果 = 第2个人.睡觉 (9, 18);
        System.out.println (第2个人.get姓名 ()+结果);

    }


    public String get身份证号() {
        return 身份证号;
    }

    public void set身份证号(String 身份证号) {
        this.身份证号 = 身份证号;
    }

    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    public char get性别() {
        return 性别;
    }

    public void set性别(char 性别) {
        this.性别 = 性别;
    }

    public short get年龄() {
        return 年龄;
    }

    public void set年龄(short 年龄) {
        this.年龄 = 年龄;
    }

    public String get籍贯() {
        return 籍贯;
    }

    public void set籍贯(String 籍贯) {
        this.籍贯 = 籍贯;
    }
}