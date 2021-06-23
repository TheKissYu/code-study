package com.code.yhz.lock;



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
    ReentrantLock reentrantLock = new ReentrantLock ();
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock ();
}

/**
 * 读锁
 */
class ReadLock{
}