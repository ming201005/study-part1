package com.chapter02.genarice;
import java.util.List;

/**
 * 泛型接口
 */
public interface MyListInterface<T> {
    //新增
    void add(T... t);
    //返回集合
    List<T> getList();
}
