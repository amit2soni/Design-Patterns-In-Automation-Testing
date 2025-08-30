package WebDriverWithSingletonPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverManager {

    private static volatile WebDriverManager instance;
    // each thread will get a copy of original web driver so that parallel execution can be done
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private WebDriverManager(){}

    private void initDriver(String browser){
        switch (browser){
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "edge":
                tlDriver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser "+browser);
        }
    }

    public static WebDriverManager getInstance(String browser){
        if(instance==null){
            synchronized (WebDriverManager.class){
                if(instance==null){
                    instance = new WebDriverManager();
                }
            }
        }

        if(tlDriver.get()==null){
            instance.initDriver(browser);
        }
      return instance;
    }

    public WebDriver getDriver(){
        return tlDriver.get();
    }

    public static void quitDriver(){
        tlDriver.get().quit();
    }
}
