package cn.htl.moon20240308;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @implNote 线程并发并行简单测试Demo
 * @since 2024-03-08
 * @author hushujing
 */
public class ThreadCompareTest {

    public static void main(String[] args) {
        // 并发执行
        concurrentExecution();

        // 并行执行
        parallelExecution();

        // 单一执行
        singleExecution();
    }

    public static void concurrentExecution() {
        ExecutorService executor = Executors.newFixedThreadPool(3); // 创建一个固定大小的线程池
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println("Concurrent execution: " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }

    public static void parallelExecution() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("Parallel execution: " + Thread.currentThread().getName());
            });
            thread.start();
        }
    }

    public static void singleExecution() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Single execution: " + i);
        }
    }

}
