package com.chapter04.testTrycatch;

public class TestMyException {

    public static void main(String[] args) {
        TestMyException test = new TestMyException();
        try {
            test.testErr();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws MyException
     */
    public  void testErr() throws MyException {
        int id = 0;
        String name = null;
        if (id<1) {
            throw  new MyException("用户的ID必须大于0");
        }
        if (null==name || "".equals(name)) {
            throw  new MyException("用户名不能为空！");
        }
        //todo
    }
}
