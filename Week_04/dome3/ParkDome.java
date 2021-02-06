package dome3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class ParkDome {
    private static int result;

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Thread main = Thread.currentThread();
        Thread thread = new Thread(() -> {
            result = NumClassDome.sum();
            LockSupport.unpark(main);
        });
        thread.start();
        LockSupport.park(main);
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
