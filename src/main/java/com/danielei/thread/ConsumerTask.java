package com.danielei.thread;

import com.danielei.holder.ConsumerTaskHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述: 消费者线程
 * date: 2020/6/22 0022
 **/
@Slf4j
public class ConsumerTask implements Runnable {

    public void run() {
        doConsumer();
    }

    private void doConsumer() {
        ConsumerTaskHolder.lock.lock();
        try{
            while (true){

                while (ConsumerTaskHolder.queue.size() == 0){
                    log.info("队列中无数据等待数据中......");
                    ConsumerTaskHolder.notEmpty.await();
                }

                //消费邮箱
                String email = ConsumerTaskHolder.queue.poll();
                log.info("收到邮箱:{},发送邮件......",email);
                // 处理逻辑 发送邮件..... some action
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ConsumerTaskHolder.lock.unlock();
        }
    }
}
