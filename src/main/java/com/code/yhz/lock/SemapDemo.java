package com.code.yhz;

import java.util.concurrent.Semaphore;

/**
 * @Author yhz
 * @Date 2020/9/10 11:35
 */
public class SemapDemo {

    public static void main( String[] args ) {
        Semaphore semaphore = new Semaphore ( 3 );
        for ( int  i=0;i<10;i++ ){
            new Thread ( new Runnable () {
                @Override
                public void run() {

                }
            } ,"车"+i).start ();
        }
    }
}
