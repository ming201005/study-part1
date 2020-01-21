package com.model.prototype;

/**
 * 双胞胎
 */
public class Twins implements Cloneable {

    private String name;

    public Twins() {
    }

    public Twins(String name) {
        this.name = name;
    }

    /**
     * 克隆父类方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone ();
    }

    public void display() {
        System.out.println ("我是双胞胎:" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * test
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args)
            throws CloneNotSupportedException {
        Twins twins1 = new Twins ("小红");
        Twins twins2 = (Twins) twins1.clone ();
        twins2.setName ("小兰");

        twins1.display ();
        twins2.display ();
    }
}
