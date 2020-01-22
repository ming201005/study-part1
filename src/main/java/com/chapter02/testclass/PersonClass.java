package com.chapter02.testclass;
/**
 * 定义 "PersonClass" (以下用英文来描述)
 */
public class PersonClass {

    //一些属性
    private String idCard;
    private String name;
    private char sex = '男';
    private short age = 0;
    private String nativePlace;

    /**
     * eat
     */
    public void eat() {
        if('男'== sex){
            System.out.println (this.name +"是"+this.sex +"的，要吃两碗以上！");
        }else {
            System.out.println (this.name +"是"+this.sex +"的，只吃半碗饭，减肥中...");
        }
    }

    /**
     * sleep
     * @param startSleepTime
     * @param getUpTime
     * @return 睡眠情况
     */
    public String sleep(int startSleepTime, int getUpTime) {
        int totalSleepTime = getUpTime-startSleepTime;
        String sleepState = "";
        if(totalSleepTime>8) {
            sleepState = "睡够了，睡了("+totalSleepTime+")个小时";
        }else {
            sleepState = "还没睡够，只睡了("+totalSleepTime+")个小时";
        }
        return sleepState;
    }

    //其他行为
    //TODO

    public static void main(String[] args) {
        PersonClass personClass = new PersonClass ();
        //给"第1个人"这个实例填充属性值
        personClass.setIdCard ("50024543543567");
        personClass.setName ("张三");
        personClass.setSex ('男');
        personClass.setAge ((short) 19);
        personClass.setNativePlace ("广东广州市");

        //第1个人的吃饭行为
        personClass.eat ();

        //第1个人的睡觉行为
        String rs01 = personClass.sleep (9, 15);
        System.out.println (personClass.getName ()+rs01);

        System.out.println("============再造一个人出来============");

        PersonClass personClass02 = new PersonClass ();
        //给"第2个人"这个实例填充属性值
        personClass02.setIdCard ("50024519891209245677");
        personClass02.setName ("小兰");
        personClass02.setSex ('女');
        personClass02.setAge ((short) 25);
        personClass02.setNativePlace ("重庆江北区");

        //第2个人的吃饭行为
        personClass02.eat ();

        //第2个人的睡觉行为
        String rs02 = personClass02.sleep (9, 18);
        System.out.println (personClass02.getName ()+rs02);

    }


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
}
