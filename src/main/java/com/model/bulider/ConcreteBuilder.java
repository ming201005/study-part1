package com.model.bulider;

/**
 * 具体建筑者
 */
public class ConcreteBuilder extends Builder {

    public void buildPartA()
    {
        product.setPartA(new PartA ("01", "产品名称A"));
    }
    public void buildPartB()
    {
        product.setPartB (new PartB ("第二部分"));
    }
    public void buildPartC()
    {
        product.setPartC (new PartC ("第三部分"));
    }
}
