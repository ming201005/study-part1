package com.model.absfactory;

/**
 * 抽象工厂：提供了厂品的生成方法
 */
interface AbstractFactory
{
    ProductA newProductA();
    ProductB newProductB();
}
