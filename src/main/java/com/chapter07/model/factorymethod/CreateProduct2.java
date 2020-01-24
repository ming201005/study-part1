package com.chapter07.model.factorymethod;

/**
 * 具体产品2：实现抽象产品中的抽象方法
 */
class CreateProduct2 implements Product
{
    public void display()
    {
        System.out.println("具体产品2显示...");
    }
}
