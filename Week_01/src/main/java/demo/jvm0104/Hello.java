package demo.jvm0104;

/**
 * @author: 肖震
 * @date: 2021/1/12
 * @since:
 */
public class Hello {

    public static void main(String[] args) {
        int c = 1;
        int b = 3;
        for (int i = 0; i < 10; i++) {
            if (i == 1) {
                System.out.println(i + b);
            }
            if (i == 2) {
                System.out.println( b - i);
            }
            if (i == 3) {
                System.out.println("你好呀"+i);
            }
            if (i == 4) {
                System.out.println(i/c);
            }
            if (i == 5) {
                System.out.println(i*c);
            }
            if (i == 6) {
                System.out.println(0.3f+i);
            }
            if (i == 7) {
                System.out.println(1L+i);
            }
            if (i == 8) {
                double cc=0.333;
                System.out.println(cc+i);
            }
        }

    }


}
