package com.testAbs;

/**
 * 人的接口，只关注行为
 */
public interface PersonInterface {

    //创建一个人
    void setPersonEntity(PersonEntity personEntity);

    //得到一个人
    PersonEntity getPersonEntity();

    //运动天赋行为——跑步
     void run();

    //个性气质行为——脾气
     void batTamper();

    //其他。。。
}
