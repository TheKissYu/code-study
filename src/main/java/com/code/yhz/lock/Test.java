package com.code.yhz;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yhz
 * @Date 2020/9/8 15:31
 */
public class Test {
    Lock lock = new ReentrantLock (  );
    Condition c1 = lock.newCondition ();
    Condition c2 = lock.newCondition ();
    Condition c3 = lock.newCondition ();
    String  name = "AA";
    public void printA(int i){
        lock.lock ();
        try{
            while ( !name.equals ( "AA" ) ){
                c1.await ();
            }
            System.out.println ("======AA"+i+"======");
            for ( int k = 0;k<5;k++ ){
                System.out.println ("线程"+Thread.currentThread ().getName () + ":第"+i+"次打印" + k);
            }
            c2.signal ();
            name = "BB";
        }catch (Exception e){

        }finally {
            lock.unlock ();
        }
    }
    public void printB(int i){
         lock.lock ();
        try{
            while ( !name.equals ( "BB" ) ){
                c2.await ();
            }
            System.out.println ("=======BB"+i+"======");
            for ( int k = 0;k<5;k++ ){
                System.out.println ("线程"+Thread.currentThread ().getName () + ":第"+i+"次打印" + k);
            }
            c3.signal ();
            name = "CC";
        }catch (Exception e){

        }finally {
            lock.unlock ();
        }
    }
    public void printC(int i){
        lock.lock ();
        try{
            while ( !name.equals ( "CC" ) ){
                c3.await ();
            }
            System.out.println ("=======CC"+i+"======");
            for ( int k = 0;k<5;k++ ){
                System.out.println ("线程"+Thread.currentThread ().getName () + ":第"+i+"次打印" + k);
            }
                c1.signal ();
            name = "AA";
        }catch (Exception e){

        }finally {
            lock.unlock ();
        }
    }

        public static void main( String[] args ) throws Exception{
            Test test = new Test ();

        new Thread ( ()->{
            for ( int i=0;i<100;i++ ){
                test.printA (i);
            }
        } ,"AA").start ();
        new Thread ( ()->{
            for ( int i=0;i<100;i++ ){
                test.printB (i);
            }
        } ,"BB").start ();
        new Thread ( ()->{
            for ( int i=0;i<100;i++ ){
                test.printC (i);
            }
        } ,"CC").start ();

    }



}
