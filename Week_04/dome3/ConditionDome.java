package dome3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class ConditionDome {
    private static volatile int result;
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition waitForSum = reentrantLock.newCondition();
        Thread thread = new Thread(()->{
            reentrantLock.lock();
            result = NumClassDome.sum();
            waitForSum.signal();
            reentrantLock.unlock();
        });
        thread.start();
        reentrantLock.lock();
        waitForSum.await();
        System.out.println("异步计算结果为："+result);
        reentrantLock.unlock();
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
