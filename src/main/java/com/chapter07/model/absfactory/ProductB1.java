package com.chapter07.model.absfactory;

/**
 * 具体产品1：实现抽象产品中的抽象方法
 */
class ProductB1 implements ProductB
{
    public void display()
    {
        System.out.println("具体产品--->ProductB1显示...");
    }
}