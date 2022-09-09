package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='accountno']")
    WebElement accountNoTxt;


    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submitAccountBtn;



    public EditAccountPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void setAccountNo(String accountNo){
        accountNoTxt.clear();
        accountNoTxt.sendKeys(accountNo);
    }

    public void clickSubmit(){
        submitAccountBtn.click();
    }




}
