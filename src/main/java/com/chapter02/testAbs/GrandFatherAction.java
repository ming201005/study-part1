package com.chapter02.testAbs;
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
        super.p("4.第四步：我跑啊，眼睛往两侧扫描，发现有人快超我了");
        super.p ("5.第五步：我咬紧牙关拼命跑，终于第一个跑到终点。");
        super.p("6.第六步：最终成绩：11.8秒/100米！破纪录了！NO.1! ");
    }
    /**
     * 脾气
     */
    @Override
    public void batTamper() {
        System.out.println ("脾气很好。");
    }
}