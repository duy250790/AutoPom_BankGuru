package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='cusid']")
    WebElement customerIdTxt;

    @FindBy(xpath = "//input[@name='cusid']//following-sibling::label")
    WebElement messageCustomerIdLbl;

    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submitBtn;

    @FindBy(xpath = "//input[@name='sub']")
    WebElement submitEditBtn;

    @FindBy(className = "heading3")
    WebElement editCustomerLabel;

    @FindBy(xpath = "//input[@name='res']")
    WebElement resetBtn;

    @FindBy(xpath = "//textarea[@name='addr']")
    WebElement addressTxt;

    @FindBy(xpath = "//textarea[@name='addr']//following-sibling::label")
    WebElement messageAddressLabel;

    @FindBy(xpath = "//input[@name='city']")
    WebElement cityTxt;

    @FindBy(xpath = "//input[@name='city']//following-sibling::label")
    WebElement messageCityLabel;

    @FindBy(xpath = "//input[@name='state']")
    WebElement stateTxt;

    @FindBy(xpath = "//input[@name='state']//following-sibling::label")
    WebElement messageStateLabel;

    @FindBy(xpath = "//input[@name='pinno']")
    WebElement pinTxt;

    @FindBy(xpath = "//input[@name='pinno']//following-sibling::label")
    WebElement messagePinLabel;

    @FindBy(xpath = "//input[@name='telephoneno']")
    WebElement phoneTxt;

    @FindBy(xpath = "//input[@name='telephoneno']//following-sibling::label")
    WebElement messagePhoneLabel;

    @FindBy(xpath = "//input[@name='emailid']")
    WebElement emailTxt;

    @FindBy(xpath = "//input[@name='emailid']//following-sibling::label")
    WebElement messageEmailLabel;

    public EditCustomerPage(WebDriver driver) {
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

    public void submitEdit(){
        submitEditBtn.click();
    }

    public boolean isDisplayEditCustomerLabel(){
        return editCustomerLabel.isDisplayed();
    }

    public void setAddressTxt(String name){
        addressTxt.clear();
        addressTxt.sendKeys(name);
    }

    public String getMessageAddress(){
        return messageAddressLabel.getText();
    }

    public void setCityTxt(String city){
        cityTxt.clear();
        cityTxt.sendKeys(city);
    }

    public String getMessageCity(){
        return messageCityLabel.getText();
    }

    public void setStateTxt(String state){
        stateTxt.clear();
        stateTxt.sendKeys(state);
    }

    public String getMessageState(){
        return messageStateLabel.getText();
    }

    public void setPinTxt(String pin){
        pinTxt.clear();
        pinTxt.sendKeys(pin);
    }

    public String getMessagePin(){
        return messagePinLabel.getText();
    }

    public void setPhoneTxt(String phone){
        phoneTxt.clear();
        phoneTxt.sendKeys(phone);
    }

    public String getMessagePhone(){
        return messagePhoneLabel.getText();
    }

    public void setEmailTxt(String email){
        emailTxt.clear();
        emailTxt.sendKeys(email);
    }

    public String getMessageEmail(){
        return messageEmailLabel.getText();
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

    public String getAddressText(){
        return addressTxt.getText();
    }
}
