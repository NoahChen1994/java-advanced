package com.cxy.advanced.thread;

import java.util.concurrent.*;

/**
 * Copyright (c) 2021, 北京卡拉卡尔科技股份有限公司
 * All rights reserved.
 *
 * @author xinyi.chen@karakal.com.cn
 * @version 5.8.8
 * @date 2022/6/30 0030
 * @description
 * @since JDK1.8
 */
public class ThreadTaskTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1000);
        for (int i = 0; i < 1000; i++) {
            queue.add(Integer.toString(i));
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,Runtime.getRuntime().availableProcessors(),
                30, TimeUnit.SECONDS
                ,new ArrayBlockingQueue<>(100),
                r->new Thread("ThreadTaskTest"),new ThreadPoolExecutor.CallerRunsPolicy());
        new Thread(new ThreadTask(executor,queue)).start();
        ThreadTask.flag=false;
    }
}