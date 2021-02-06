package dome3;

/**
 * @author: 肖震
 * @date: 2021/2/6
 * @since:
 */
public class NumClassDome {
    public static int sum() {
        return fibo(36);
    }

    public static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
