package com.code.yhz.desgin_model.iterator;

import com.code.yhz.desgin_model.iterator.*;



public class Test {
    public static void main(String[] args) {
        Shelf<Book> shelf = new Shelf<>(2);
        shelf.add(new Book("1"));
        shelf.add(new Book("2"));
        Iterator<Book> iterator = shelf.iterator();
        while (iterator.hasNext()){
            Book next = iterator.next();
            System.out.println(next.getName());
        }
    }
}
