package com.testAbs;

/**
 * 爷爷
 */
public class GrandFatherAction extends AbstractPersonAction {

    /**
     * 跑步
     */
    @Override
    public void run() {
        super.run ();
        //继续行为
        System.out.println ("4.第四步：我跑啊，跑啊，跑啊，眼睛往两侧扫描，发现有人快超我了。");
        System.out.println ("5.第五步：我咬紧牙关拼命跑，终于第一个跑到终点。");
        System.out.println ("6.第六步：最终我的成绩是：11.8秒/100米！破纪录了！NO.1，🏆 ");
    }

    /**
     * 脾气
     */
    @Override
    public void batTamper() {
        System.out.println ("脾气很好。");
    }

}

