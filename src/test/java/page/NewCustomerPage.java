package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewCustomerPage {

    WebDriver driver;
    WebDriverWait wait;

    //a[text()='New Customer'

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameTxt;

    @FindBy(xpath = "//input[@name='name']//following-sibling::label")
    WebElement messageNameLabel;

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

    @FindBy(xpath = "//input[@value='m']")
    WebElement maleRadioBtn;

    @FindBy(xpath = "//input[@value='f']")
    WebElement femaleRadioBtn;

    @FindBy(xpath = "//input[@name='dob']")
    WebElement birthdayTxt;

    @FindBy(xpath = "//input[@name='password']")
    WebElement pwTxt;

    @FindBy(xpath = "//input[@name='sub']")
    WebElement submitBtn;

    @FindBy(className = "heading3")
    WebElement messageRegisterSuccessLbl;

    @FindBy(xpath = "//td[text()='Customer ID']//following-sibling::td")
    WebElement customerIdLbl;

    public NewCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }



    public boolean checkMessageNameDisplay(){
        return messageNameLabel.isDisplayed();
    }

    public void setNameTxt(String name){
        nameTxt.clear();
        nameTxt.sendKeys(name);
    }

    public String getMessageCusName(){
        return messageNameLabel.getText();
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

    public void selectGender(String gender){
        if(gender.contains("f")){
            femaleRadioBtn.click();
        }else if (gender.contains("m")){
            maleRadioBtn.click();
        }
    }

    public void setBirthday(String birthday){
        birthdayTxt.clear();
        birthdayTxt.sendKeys(birthday);
    }

    public void setPW(String pw){
        pwTxt.clear();
        pwTxt.sendKeys(pw);
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

    public String getMessageRegisterSuccess(){
        return messageRegisterSuccessLbl.getText();
    }

    public String getCustomerId(){
        return customerIdLbl.getText();
    }
}
