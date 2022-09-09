package setups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Drivers {
    private static final Integer TIMEOUT = 5;
    public static WebDriverWait wait;

    public static WebDriver initiateDriver(String name){
        WebDriver driver;
        if (name.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }else if (name.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }else if (name.equalsIgnoreCase("safari")){
            driver= new SafariDriver();
        }else {
            throw new IllegalArgumentException("The browser "+name +" does not support");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return driver;
    }
}
