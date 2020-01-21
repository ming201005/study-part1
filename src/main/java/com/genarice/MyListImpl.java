package com.genarice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @param <T>
 */
public  class MyListImpl<T> implements MyListInterface<T> {

    List<T> list;

    MyListImpl() {
        list = new ArrayList<> ();
    }
    @Override
    public void add(T ...t) {
        this.list.addAll (Arrays.asList (t));
    }
    //可以把一些基本的行为写好
    @Override
    public List<T> getList() {
        return  list;
    }
}
