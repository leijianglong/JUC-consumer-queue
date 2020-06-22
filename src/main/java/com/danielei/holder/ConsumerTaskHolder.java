package com.danielei.holder;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述: 消费者相关资源
 * date: 2020/6/22 0022
 **/
public class ConsumerTaskHolder {
    public static Lock lock = new ReentrantLock();
    public static Condition notEmpty = lock.newCondition();
    /**
     * 存放数据的队列
     */
    public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();



}
