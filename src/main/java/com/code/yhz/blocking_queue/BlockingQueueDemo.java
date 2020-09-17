package com.code.yhz.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author yhz
 * @Date 2020/9/16 23:01
 */
public class BlockingQueueDemo {
    public static void main( String[] args ) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue ( 10 );
        //插入 add 有则插入 否则报错
        //     offer有空则插入 返回true 无则返回false
        //     put 有插入 无则持续等待
        //     offer(e,time,unit)
        //移除 remove
        // poll
        // take
        // poll(time,unit)
        //检查 element peek

    }
}

