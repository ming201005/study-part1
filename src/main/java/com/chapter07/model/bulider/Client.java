package com.chapter07.model.bulider;

public class Client {
    public static void main(String[] args)
    {
        Builder builder   = new ConcreteBuilder();

        Director director = new Director(builder);
        Product product   = director.construct();
        //显示产品信息
        product.display ();
    }
}
