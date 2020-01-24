package com.chapter07.model.absfactory;

/**
 * 具体产品2：实现抽象产品中的抽象方法
 */
class ProductB2 implements ProductB
{
    public void display()
    {
        System.out.println("具体产品--->ProductB2显示...");
    }
}
