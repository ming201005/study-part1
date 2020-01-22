package com.chapter02.testinterface;
/**
 * 爸爸,继承爷爷类，同时有自己的具体实现行为
 */
public class Father extends GrandFather
        implements PersonInterface {
    @Override
    public void run() {
        System.out.println ("我跑步没我爷爷快：13.9秒/100米！");
    }
    @Override
    public void batTamper() {
        System.out.println ("我的脾气不太好！");
    }
}
