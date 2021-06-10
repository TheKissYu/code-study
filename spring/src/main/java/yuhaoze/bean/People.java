package yuhaoze.bean;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class People {
    public void sayHello(){
        int MAXIMUM_CAPACITY = Integer.MAX_VALUE;
        System.out.println("hello!");

        Map<String,Object> map1  = new HashMap<>();
        Set<Map.Entry<String, Object>> entries = map1.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();

        List<Map<String,Object>> list = new ArrayList<>();


        int m = 1 << 18;
        System.out.println(m);
        int n= 131073;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        n =  n + 1;
        System.out.println(n);
    }


}
