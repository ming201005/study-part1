package com.model.bulider;

/**
 * 抽象建筑者
 * * 参考的类、包、方法用@see，方便javadoc中支持链接跳转
 * @version
 */
public abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    //创建第一部分
    public abstract void buildPartA();
    //创建第二部分
    public abstract void buildPartB();
    //创建第三部分
    public abstract void buildPartC();

    //返回产品对象
    public Product getResult()
    {
        return product;
    }
}
