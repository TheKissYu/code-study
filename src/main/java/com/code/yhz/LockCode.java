package com.code.yhz;



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有关锁的一些代码
 * @Author yhz
 * @Date 2020/9/8 11:11
 */
public class LockCode {


}

/**
 * 写锁
 */
class WriteLock{
    private volatile Map<String,Object> map = new HashMap<>();
    ReentrantLock reentrantLock = new ReentrantLock (  );
//    AtomicInteger
}

/**
 * 读锁
 */
class ReadLock{

}