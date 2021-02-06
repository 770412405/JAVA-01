package dome3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class CompletableFutureDome {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(NumClassDome::sum);
        System.out.println("异步计算结果为：" + completableFuture.get());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

}
