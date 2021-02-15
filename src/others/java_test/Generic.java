package others.java_test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Class<? extends List> c = list.getClass();
        Method method = c.getDeclaredMethod("add", Object.class);
        method.invoke(list,true);
        System.out.println(list);

    }
}
