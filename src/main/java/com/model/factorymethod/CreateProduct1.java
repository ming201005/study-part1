package com.model.factorymethod;

/**
 * 具体产品1：实现抽象产品中的抽象方法
 */
class CreateProduct1 implements Product
{
    public void display()
    {
        System.out.println("具体产品1显示...");
    }
}