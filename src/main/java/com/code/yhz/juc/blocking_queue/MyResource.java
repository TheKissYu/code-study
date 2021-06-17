package com.code.yhz.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author yhz
 * @Date 2020/9/17 23:18
 */
public class MyResource {
    private volatile Boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger (  );
    BlockingQueue<String> blockingQueue = null;

    public MyResource( BlockingQueue<String> blockingQueue ) {
        this.blockingQueue = blockingQueue;
    }
    public void myPro() throws InterruptedException {
        String value = "";
        boolean l;
        while (FLAG){
            value = atomicInteger.incrementAndGet ()+"";
            l= blockingQueue.offer (  value,2L, TimeUnit.SECONDS);
            if ( l ){
                System.out.println ( "生产成功 ：" + value);
            }
        }
        System.out.println ("停止生产");
    }
    public  void  myCur() throws InterruptedException {
        String get;
        while (FLAG){
            get = blockingQueue.poll ( 2L, TimeUnit.SECONDS );
            if (get == null ){
                FLAG = false;
                System.out.println ("获取不到 等待生产");
            }
            System.out.println ("消费成功 ："+ get);
        }
        System.out.println ("停止生产 停止消费");
    }
    public void stop(){
        FLAG = false;
    }

    public static void main( String[] args ) throws InterruptedException {
        MyResource myResource = new MyResource ( new ArrayBlockingQueue<> (  10) );
        new Thread ( new Runnable () {
            @Override
            public void run() {
                System.out.println ("消费");
                try {
                    myResource.myPro ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        } ).start ();

        new Thread ( new Runnable () {
            @Override
            public void run() {
                System.out.println ("生产者");
                try {
                    myResource.myCur ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        } ).start ();
        Thread.sleep ( 5 );
        myResource.stop ();
    }
}
