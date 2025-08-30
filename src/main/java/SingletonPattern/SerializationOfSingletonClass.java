package SingletonPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationOfSingletonClass {
    public static void main(String[] args){
        try {
            Browser instance1 = Browser.getInstance();

            // Serialize the browser instance
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("browser.json"));
            out.writeObject(instance1);
            out.close();

            // de-serialize the browser instance
            ObjectInputStream ini = new ObjectInputStream(new FileInputStream("browser.json"));
            Browser instance2 = (Browser) ini.readObject();
            ini.close();

            System.out.println("Instance1 hashcode "+instance1.hashCode());
            System.out.println("Instance2 hashcode "+instance2.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
