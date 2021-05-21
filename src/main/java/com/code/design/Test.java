package com.code.design;

import com.code.design.iterator.Book;
import com.code.design.iterator.Iterator;
import com.code.design.iterator.Shelf;

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
