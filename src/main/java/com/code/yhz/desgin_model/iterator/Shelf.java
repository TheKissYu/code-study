package com.code.yhz.desgin_model.iterator;

public  class Shelf<T> implements Aggregate<T> {
    private int size;
    private int curr=0;
    private Object[] elementData;
    public Shelf(int size){
        this.size = size;
        elementData = new Object[size];
    }
    public Iterator iterator() {
        return new ShelfIterator<>();
    }

    @Override
    public int add(T t) {
        if (this.curr+1 > size){
            throw new RuntimeException("超出长度");
        }
        elementData[curr++] = t;
        return curr;
    }

    private class ShelfIterator<T> implements Iterator<T>{
        int currFlag =0  ;
        @Override
        public T next() {
            T t = (T) elementData[currFlag];
            ++currFlag;
            return t;
        }
        @Override
        public boolean hasNext() {
            if (currFlag < size){
                return true;
            }
            return false;
        }
    }
}
