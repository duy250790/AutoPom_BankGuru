package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.JavaUntils;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='New Customer']")
    WebElement newCustomerMenu;

    @FindBy(xpath = "//a[text()='Edit Customer']")
    WebElement editCustomerMenu;

    @FindBy(xpath = "//a[text()='Delete Customer']")
    WebElement deleteCustomerMenu;

    @FindBy(xpath = "//a[text()='New Account']")
    WebElement newAccountMenu;

    @FindBy(xpath = "//a[text()='Edit Account']")
    WebElement editAccountMenu;

    By addon = By.id("card");

    By closeBtnOfPopUp = By.xpath("//span[text()='Close']");

    By quitAds = By.id("dismiss-button");


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public void clickNewCustomerPage() throws InterruptedException {
        newCustomerMenu.click();
        if(driver.getTitle().contains("Guru99 Bank Manager HomePage")){
            closeAds();
        }
    }

    public void clickEditCustomerPage(){
        editCustomerMenu.click();
        if(driver.getTitle().contains("Guru99 Bank Manager HomePage")) {
            closeAds();
        }
    }

    public void clickEditAccountPage(){
        editAccountMenu.click();
        if(driver.getTitle().contains("Guru99 Bank Manager HomePage")) {
            closeAds();
        }
    }

    public void clickDeleteCustomerPage(){
        deleteCustomerMenu.click();
        if(driver.getTitle().contains("Guru99 Bank Manager HomePage")) {
            closeAds();
        }
    }

    public void clickNewAccountPage(){
        newAccountMenu.click();
        if(driver.getTitle().contains("Guru99 Bank Manager HomePage")) {
            closeAds();
        }
    }

    public void closeAds(){
        WebDriver iframeGG;
        WebDriver childIframe;
        iframeGG = driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
        System.out.println("show quang cao: " + iframeGG.findElement(addon).isDisplayed());
        childIframe = driver.switchTo().frame("ad_iframe");
        if (JavaUntils.isDisplay(childIframe, closeBtnOfPopUp)) {
            childIframe.findElement(closeBtnOfPopUp).click();
            System.out.println("show close");
            driver.switchTo().defaultContent();
        } else {
            iframeGG = childIframe.switchTo().parentFrame();
            iframeGG.findElement(quitAds).click();
            System.out.println("show quit");
            driver.switchTo().defaultContent();
        }
    }
}
