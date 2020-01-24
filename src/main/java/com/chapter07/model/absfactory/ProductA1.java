package com.chapter07.model.absfactory;

/**
 * 具体产品1：实现抽象产品中的抽象方法
 */
class ProductA1 implements ProductA
{
    public void display()
    {
        System.out.println("具体产品--->ProductA1显示...");
    }
}