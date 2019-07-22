package cn.vencenter.ourlife.thread;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-21 20:06
 * @version:
 **/
public class MyThread implements Callable<String> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        return "sdddd";
    }
}
