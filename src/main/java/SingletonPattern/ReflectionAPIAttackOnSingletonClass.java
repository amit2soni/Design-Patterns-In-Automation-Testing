package SingletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionAPIAttackOnSingletonClass {

    public static void main(String[] args){
        Browser instance1 = Browser.getInstance();
        Browser instance2 = null;

        try {
            Constructor<Browser> constructor = Browser.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
            System.out.println(instance1.hashCode());
            System.out.println(instance2.hashCode());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
