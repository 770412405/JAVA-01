package demo.jvm0104;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: 肖震
 * @date: 2021/1/6
 * @since:
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> clazz =new HelloClassLoader().findClass("Hello");
            Method declaredMethod = clazz.getDeclaredMethod("hello");
            declaredMethod.invoke(clazz.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected Class<?> findClass(String name)  {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream( name.replace(".", File.pathSeparator) + ".xlass");
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        int nextValue = 0;
        while (true) {
            try {
                if (!((nextValue = inputStream.read()) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            bout.write(nextValue);
        }

        byte[] aa=bout.toByteArray();
        for (int i = 0; i < aa.length; i++) {
            aa[i]=(byte) (255-aa[i]);
        }
        return defineClass(name, aa, 0,aa.length);
    }

}
