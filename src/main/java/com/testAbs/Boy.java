package com.testAbs;

/**
 * 男孩子
 */
public class Boy extends PersonEntity {

    private String sex = "男孩";

    //构造方法
    public Boy(String idCard, String name, String eye, String face, String nose) {
        super (idCard, name, eye, face, nose);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return " 男孩 ：{" +
                "idCard='" + super.getIdCard () + '\'' +
                ", name='" + super.getName () + '\'' +
                ", sex ='" + this.getSex () + '\'' +
                ", eye='" + super.getEye () + '\'' +
                ", face='" + super.getFace () + '\'' +
                ", nose='" + super.getNose () + '\'' +
                '}';
    }
}
