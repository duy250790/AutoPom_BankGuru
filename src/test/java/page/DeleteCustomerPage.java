package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='cusid']")
    WebElement customerIdTxt;

    @FindBy(xpath = "//input[@name='cusid']//following-sibling::label")
    WebElement messageCustomerIdLbl;

    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submitBtn;

    @FindBy(xpath = "//input[@name='res']")
    WebElement resetBtn;



    public DeleteCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void setCustomerId(String id){
        customerIdTxt.clear();
        customerIdTxt.sendKeys(id);
    }

    public String getMessageCustomerId(){
        return messageCustomerIdLbl.getText();
    }

    public void submit(){
        submitBtn.click();
    }

    public void acceptAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public String getTextAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

}
