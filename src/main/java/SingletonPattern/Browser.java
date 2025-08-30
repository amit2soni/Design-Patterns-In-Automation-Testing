package SingletonPattern;

import java.io.Serializable;

public class Browser implements Serializable , Cloneable {
    //In Java, the volatile keyword is a modifier that can be applied to a variable to ensure that its value is always read directly from main memory and not cached in a thread’s local memory (CPU cache/registers).
    //This is mainly used in multithreaded programming to guarantee visibility of changes to variables across threads.
    private volatile static Browser browser;

    private Browser(){
        // prevent reflection api attack
        if(browser!=null){
            throw new IllegalArgumentException("Object already exists");
        }
    }

    //In Java, the synchronized keyword is used to achieve thread safety by ensuring that only one thread at a time can execute a block of code or a method that is marked as synchronized.
    //It provides mutual exclusion and also guarantees visibility of changes to variables across threads.

    public static Browser getInstance(){
        if(browser==null){
            synchronized (Browser.class){
                if(browser==null){
                    browser = new Browser();
                }
            }
        }
        return browser;
    }

    // it will be called during de-serialization process to prevent object re-creation
    protected Object readResolve(){
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("singleton instance can not be cloned");
    }

    public void getInfo(){
        System.out.println("Hashcode - "+browser.hashCode());
    }
}
