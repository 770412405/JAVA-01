package dome3;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class CountDownLatchDome {
    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(() -> {
            result = NumClassDome.sum();
            countDownLatch.countDown();
        });
        thread.start();
        countDownLatch.await();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
