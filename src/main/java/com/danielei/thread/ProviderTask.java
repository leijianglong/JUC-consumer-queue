package com.danielei.thread;

import com.danielei.holder.ConsumerTaskHolder;

/**
 * 描述: 提供者主要用于给队列推送数据
 * date: 2020/6/22 0022
 **/
public class ProviderTask {

    /**
     * 给队列推送数据
     * @param email
     */
    public static void pushQueue(String email){
        ConsumerTaskHolder.lock.lock();
        try {
            ConsumerTaskHolder.queue.add(email);
            //唤醒消费者线程处理任务啦
            ConsumerTaskHolder.notEmpty.signalAll();
        }finally {
            ConsumerTaskHolder.lock.unlock();
        }
    }
}
