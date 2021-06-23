package com.code.yhz.desgin_model.iterator;

public interface Aggregate<T> {
    Iterator<T> iterator();
    int add(T t);
}
