package dome3;


import java.util.concurrent.*;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class CompletionServiceDome {
        public static void main(String[] args) throws InterruptedException, ExecutionException {
            long start = System.currentTimeMillis();
            ExecutorService executorService = Executors.newCachedThreadPool();
            CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
            completionService.submit(NumClassDome::sum);
            System.out.println("异步计算结果为：" + completionService.take().get());
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
            executorService.shutdown();
        }
    }
