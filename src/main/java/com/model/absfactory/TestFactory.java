package com.model.absfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试工厂方法
 */
public class TestFactory {

    public static Map<String,String> FACTORY = new HashMap<> ();
    static {
        //先将创建工程类注册到map中
        FACTORY.put ("工厂1","com.model.absfactory.CreateFactory1");
        FACTORY.put ("工厂2","com.model.absfactory.CreateFactory2");
    }

    /**
     * 动态创建工厂
     * @param factoryName
     * @return
     */
    public static AbstractFactory createFactory(String factoryName) {
        try
        {
            //动态创建类
            Class<?> c = Class.forName(FACTORY.get (factoryName));
            AbstractFactory obj = (AbstractFactory) c.newInstance();
            return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 测试主方法
     * @param args
     */
    public static void main(String[] args) {

        //同等于 new CreateFactory2();
        AbstractFactory factory = createFactory("工厂1");
        //创建新产品A
        ProductA productA = factory.newProductA ();
        //产品方法display
        productA.display ();

        //创建新产品A
        ProductB productB = factory.newProductB ();
        //产品方法display
        productB.display ();
    }



}
