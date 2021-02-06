package dome3;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class IsAliveDome {
    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            result = NumClassDome.sum();
        });
        thread.start();
        while (thread.isAlive()) {
        }
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
