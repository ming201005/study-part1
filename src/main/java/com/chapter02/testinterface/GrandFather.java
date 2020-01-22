package com.chapter02.testinterface;
/**
 * 爷爷
 */
public class GrandFather extends PersonEntity
        implements PersonInterface {
    /**
     * 跑步
     */
    @Override
    public void run() {
        System.out.println ("跑步速度：11.8秒/100米！");
    }
    /**
     * 脾气
     */
    @Override
    public void batTamper() {
        System.out.println ("脾气很好。");
    }
}

