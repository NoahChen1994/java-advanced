package com.cxy.advanced.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Copyright (c) 2021, 北京卡拉卡尔科技股份有限公司
 * All rights reserved.
 *
 * @author xinyi.chen@karakal.com.cn
 * @version 5.8.8
 * @date 2022/6/30 0030
 * @description 模拟多线程
 * @since JDK1.8
 */
public class ThreadTask implements Runnable{

    private ThreadPoolExecutor executor;

    private ArrayBlockingQueue<String> queue;

    public static volatile boolean flag = true;

    public ThreadTask(ThreadPoolExecutor executor, ArrayBlockingQueue<String> queue) {
        this.executor = executor;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (flag){
            try {
                String take = queue.take();
                executor.submit(()->doSomething(take));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        while (!queue.isEmpty()){
            try {
                String take = queue.take();
                executor.submit(()->doSomething(take));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void doSomething(String id){
        try {
            System.out.println(id);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        flag = false;
        Thread.currentThread().interrupt();
    }
}