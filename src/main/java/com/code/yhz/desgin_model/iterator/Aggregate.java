package com.code.design.iterator;

public interface Aggregate<T> {
    Iterator<T> iterator();
    int add(T t);
}
