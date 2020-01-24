package com.chapter07.model.absfactory;

/**
 * 具体工厂1：实现了厂品的生成方法
 */
class CreateFactory1 implements AbstractFactory
{
    public ProductA newProductA()
    {
        System.out.println("具体工厂1生成-->具体产品A1...");
        return new ProductA1 ();
    }

    @Override
    public ProductB newProductB() {
        System.out.println("具体工厂1生成-->具体产品B1...");
        return new ProductB1 ();
    }
}
