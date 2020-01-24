package com.chapter07.model.bulider;

/**
 * 产品：有3个部件
 */
public class Product {

    PartA partA;

    PartB partB;

    PartC partC;

    public PartA getPartA() {
        return partA;
    }

    public void setPartA(PartA partA) {
        this.partA = partA;
    }

    public PartB getPartB() {
        return partB;
    }

    public void setPartB(PartB partB) {
        this.partB = partB;
    }

    public PartC getPartC() {
        return partC;
    }

    public void setPartC(PartC partC) {
        this.partC = partC;
    }

    /**
     * 显示产品数据
     */
    public void display() {
        String str = "产品信息==》{"
                 +"A部分-id="+this.partA.getId ()+","
                 +"A部分-name="+this.partA.getName ()+","
                 +"B部分-face="+this.partB.getFace ()+","
                 +"C部分-foot="+this.partC.getFoot ()
                 +"}";
        System.out.println (str);
    }
}
