package SingletonPattern;

public class BrowserClone {

    public static void main(String[] args){
        Browser isntance1 = Browser.getInstance();
        try {
            Browser instance2 = (Browser) isntance1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
