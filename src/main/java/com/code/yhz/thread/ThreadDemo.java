package com.code.yhz.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 * @Author yhz
 * @Date 2020/9/16 10:57
 */
public class ThreadDemo {

    public static void main( String[] args ) throws Exception {
//        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<> ( 10 );
//
//        ThreadPoolExecutor threadPoolExecutor =
//                new ThreadPoolExecutor (5,10,0, TimeUnit.MILLISECONDS, blockingQueue );
//        threadPoolExecutor.execute ( new Runnable () {
//            @Override
//            public void run() {
//                System.out.println ("dddd");
//            }
//        } );
        for ( int i = 0 ; i < 100  ; i++ ) {
            final int k = i;
            new Thread ( new Runnable () {
                @Override
                public void run() {
                    if ( k % 2 == 0 ){
//                        throw new Exception ( "错误" );
                    }
                }
            } , i+"").start ();
        }
//        List<String> list = new ArrayList<> (  );
//        list.add ( null );
//        list.add ( "1" );
//        list.add ( null );
//        list.add ( "2" );
//        System.out.println (list);
    }
}
