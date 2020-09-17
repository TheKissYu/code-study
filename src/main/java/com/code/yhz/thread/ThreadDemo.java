package com.code.yhz.thread;

import java.util.concurrent.*;

/**
 *
 * @Author yhz
 * @Date 2020/9/16 10:57
 */
public class ThreadDemo {

    public static void main( String[] args ) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<> ( 10 );

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor (5,10,0, TimeUnit.MILLISECONDS, blockingQueue );
        threadPoolExecutor.execute ( new Runnable () {
            @Override
            public void run() {
                System.out.println ("dddd");
            }
        } );

    }
}
