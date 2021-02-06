package dome3;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class WaitAndNotifyDome {
    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        WaitAndNotifyDome waitAndNotify = new WaitAndNotifyDome();
        Thread thread = new Thread(waitAndNotify ::sum);
        thread.start();
        waitAndNotify.print();
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private synchronized void print() throws InterruptedException {
        wait();
        System.out.println("异步计算结果为："+result);
    }

    private synchronized void sum() {
        result = fibo(36);
        notifyAll();
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
