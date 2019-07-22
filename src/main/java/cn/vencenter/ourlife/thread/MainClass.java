package cn.vencenter.ourlife.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-21 20:27
 * @version:
 **/
public class MainClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
}
