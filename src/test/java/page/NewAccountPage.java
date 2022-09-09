package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {

    WebDriver driver;
    @FindBy(xpath = "//input[@name='cusid']")
    WebElement customerIDTxt;

    @FindBy(xpath = "//select[@name='selaccount']")
    WebElement accountTypeSec;

    @FindBy(xpath = "//input[@name='inideposit']")
    WebElement initialDepositTxt;

    @FindBy(xpath = "//input[@name='button2']")
    WebElement submitBtn;

    @FindBy(className = "heading3")
    WebElement messageCreateAccountSuccess;

    @FindBy(xpath = "//td[text()='Account ID']//following-sibling::td")
    WebElement accountIdText;

    public NewAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setCustomerId(String value){
        customerIDTxt.clear();
        customerIDTxt.sendKeys(value);
    }

    public void selectAccountType(String value){
        Select select = new Select(accountTypeSec);
        select.selectByVisibleText(value);
    }

    public void setInitialDeposit(String value){
        initialDepositTxt.clear();
        initialDepositTxt.sendKeys(value);
    }

    public void submit(){
        submitBtn.click();
    }

    public String getMessageCreateSuccess(){
        return messageCreateAccountSuccess.getText();
    }

    public String getAccountId(){
        return accountIdText.getText();
    }

}
