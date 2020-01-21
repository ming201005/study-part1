package com.testclass;

/**
 * 爷爷
 */
public class GrandFather {

    private String eye = "深邃的眼睛";

    private String face = "国字脸";

    private String nose = "大鼻子";

    private double money = 888888888D;

    //无参数构造器
    public GrandFather() {
    }

    //全参数构造器
    public GrandFather(String eye, String face, String nose, double money) {
        this.eye = eye;
        this.face = face;
        this.nose = nose;
        this.money = money;
    }

    /**
     * 跑步
     */
    public void run() {
        System.out.println ("跑步速度：11.8秒/100米！");
    }


    /**
     * 脾气
     */
    public void batTamper() {
        System.out.println ("脾气很好。");
    }


    //get/set方法====================

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return " {" +
                "eye='" + eye + '\'' +
                ", face='" + face + '\'' +
                ", nose='" + nose + '\'' +
                ", money=" + money +
                '}';
    }
}

