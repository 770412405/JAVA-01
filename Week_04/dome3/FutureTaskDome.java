package dome3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class FutureTaskDome {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<>(NumClassDome::sum);
        new Thread(futureTask).start();
        System.out.println("异步计算结果为："+futureTask.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

    }
}
