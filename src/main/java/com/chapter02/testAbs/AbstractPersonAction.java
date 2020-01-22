package com.chapter02.testAbs;
/**
 * 人的行为抽象
 */
public abstract class AbstractPersonAction implements  PersonInterface {
    private PersonEntity personEntity;
    //可以把一些基本的行为写好
    @Override
    public void run() {
        p("MyListImpl->run:百米跑步：");
        //跑步行为：
        p ("1.第一步：俯下身子，两手撑地，不能越过开始线。");
        p ("2.第二步：一只腿放在蹬腿机上，准备听从枪声。");
        p ("3.第三步：枪声一向，蹬腿就跑！");

        p (".....冲刺过程，结果如何？不知道，留给子类实现。");
    }

    //输出
    public  void p(Object msg) {
        System.out.println (msg);
    }

    //如果还不太清楚具体行为，也可以再留空白
    @Override
    public abstract void batTamper();

    @Override
    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    //创建人的行为，交给这个抽象类完成
    @Override
    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
}
