package support;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaUntils {
    private static final Integer TIMEOUT = 3;
    public static WebDriverWait wait;

    public static void click(WebDriver driver,WebElement e){
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(e));
        e.click();
    }

    public static void fill(WebElement e,String withText){
        e.clear();
        e.sendKeys(withText);
    }

    public static void fillAndEnter(WebElement e,String withText){
        e.clear();
        e.sendKeys(withText+ Keys.ENTER);
    }

    public static void pressTab(WebElement e){
        e.clear();
        e.sendKeys(Keys.TAB);
    }

//    public static boolean isDisplay(WebElement e){
//        return e.isDisplayed();
//    }

//    public static WebElement waitForElementPresent(WebDriver driver, WebElement e){
//        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        return wait.until(ExpectedConditions.visibilityOf(e));
//    }

    public static boolean isDisplay(WebDriver driver,By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }
        catch (Exception ex2){
            System.out.println("Element is not in DOM");
            return false;
        }
    }
}
