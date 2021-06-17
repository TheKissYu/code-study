package com.code.yhz.blocking_queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author yhz
 * @Date 2020/9/16 23:14
 */
public class SynchronousQueueDemo {
    public static void main( String[] args ) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread ( ()->{
            try {
                System.out.println ("1");
                blockingQueue.put ( "1" );
                System.out.println ("2");
                blockingQueue.put ( "2" );
                System.out.println ("3");
                blockingQueue.put ( "3" );
            }catch (Exception e){
                e.printStackTrace ();
            }
        } ).start ();
        new Thread ( ()->{
            try {
                Thread.sleep ( 5 );
                System.out.println ("take"+blockingQueue.take ());
                Thread.sleep ( 5 );
                System.out.println ("take"+blockingQueue.take ());
                Thread.sleep ( 5 );
                System.out.println ("take"+blockingQueue.take ());
            } catch (Exception e) {
                e.printStackTrace ();
            }
        } ).start ();
    }
}
