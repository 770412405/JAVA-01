package dome3;

import java.util.concurrent.Semaphore;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class SemaphoreDome {
    private static volatile int result;
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Semaphore semaphore = new Semaphore(0);
        Thread thread = new Thread(() -> {
            result = NumClassDome.sum();
            semaphore.release();
        });
        thread.start();
        semaphore.acquire();
        System.out.println("异步计算结果为："+result);
        semaphore.release();
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
