package com.testinterface;

/**
 * 人
 */
public class PersonEntity {

    //身份号码
    private String idCard = "";
    //姓名
    private String name   = "";
    //眼睛
    private String eye    = "";
    //脸蛋
    private String face   = "";
    //鼻子
    private String nose   = "";

    /**
     * 无参构造
     */
    public PersonEntity() {

    }

    /**
     * 全参构造
     * @param idCard
     * @param name
     * @param eye
     * @param face
     * @param nose
     */
    public PersonEntity(String idCard, String name, String eye, String face, String nose) {
        this.idCard = idCard;
        this.name = name;
        this.eye = eye;
        this.face = face;
        this.nose = nose;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "人：{" +
                "idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", eye='" + eye + '\'' +
                ", face='" + face + '\'' +
                ", nose='" + nose + '\'' +
                '}';
    }
}
