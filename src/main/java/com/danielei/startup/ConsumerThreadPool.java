package com.danielei.startup;

import com.danielei.holder.ConsumerTaskHolder;
import com.danielei.thread.ConsumerTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述: 线程池启动加载
 * date: 2020/6/22 0022
 **/
@Slf4j
@Component
@Order(0)
public class ConsumerThreadPool implements ApplicationRunner {
    /**
     * 线程池
     */
    public static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void run(ApplicationArguments args) {
        log.info("加载线程池中.........");
        try {
            ConsumerTask consumerTask = new ConsumerTask();
            executorService.submit(consumerTask);
            log.info("线程池启动完成......");
        } catch (Exception e) {
            log.error("线程池启动报错了.......");
            e.printStackTrace();
        }
    }


    /**
     * 项目销毁前执行
     */
    @PreDestroy
    public void destroy() {
        try {
            executorService.shutdown();//优雅的关闭
            log.info("关闭线程池....");
//          List<Runnable> runnables = executorService.shutdownNow();//直接关闭
//          log.debug("未执行完的任务,"+runnables);
        } catch (Exception e) {
            log.error("线程池关闭失败...", e);
            e.printStackTrace();
        }

    }


}
