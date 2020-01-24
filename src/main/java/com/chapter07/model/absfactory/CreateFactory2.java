package com.chapter07.model.absfactory;

/**
 * 具体工厂2：实现了厂品的生成方法
 */
class CreateFactory2 implements AbstractFactory
{
    public ProductA newProductA()
    {
        System.out.println("具体工厂2生成-->具体产品A2...");
        return new ProductA2 ();
    }

    @Override
    public ProductB newProductB() {
        System.out.println("具体工厂1生成-->具体产品B1...");
        return new ProductB2 ();
    }


}
