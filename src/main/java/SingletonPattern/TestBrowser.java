package SingletonPattern;

public class TestBrowser {

    public static void main(String[] args){
        //Browser.getInstance().getInfo();

        Runnable task = () -> {
            Browser.getInstance().getInfo();
        };

        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);
        Thread th3 = new Thread(task);
        Thread th4 = new Thread(task);
        Thread th5 = new Thread(task);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();

        try{
            th1.join();
            th2.join();
            th3.join();
            th4.join();
            th5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
