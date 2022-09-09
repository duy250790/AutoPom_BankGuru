package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.JavaUntils;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@name='uid']")
    WebElement userIdTxt;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTxt;

    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@name='btnReset']")
    WebElement resetBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void setUserId(String userId){
        userIdTxt.clear();
        userIdTxt.sendKeys(userId);
    }

    public void setPassword(String password){
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }
}
