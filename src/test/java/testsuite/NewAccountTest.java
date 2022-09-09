package testsuite;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;
import setups.BaseTests;

import java.util.Random;

public class NewAccountTest extends BaseTests {
    LoginPage loginPage;
    HomePage homePage;
    NewCustomerPage newCustomerPage;
    NewAccountPage newAccountPage;
    EditAccountPage editAccountPage;
    String customerId = "";
    String accountId = "";

    @DataProvider(name = "dataLogin")
    Object[][] dataUser(){
        return new Object[][]{
                {"mngr437483","ynezupy"},
        };
    }

    @DataProvider(name = "dataNewCustomer")
    Object[][] dateNewCustomer(){
        return new Object[][]{
                {"anolyAKM","M","01/01/2000","5 VO Van Ngan","HCM","TD","500000","1234098765","123456"},
        };
    }

    @Test(dataProvider = "dataLogin")
    void TC00_Login(String userId, String password) throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.setUserId(userId);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");

        //Click New customer
        homePage = new HomePage(driver);
        homePage.clickNewCustomerPage();
        newCustomerPage = new NewCustomerPage(driver);
    }

    @Test(dataProvider = "dataNewCustomer")
    void TC01_CreateCustomer(String name, String gender, String bir, String address, String city, String state, String pin, String mobile, String pw){
        newCustomerPage.setNameTxt(name);
        newCustomerPage.selectGender(gender);
        newCustomerPage.setBirthday(bir);
        newCustomerPage.setAddressTxt(address);
        newCustomerPage.setCityTxt(city);
        newCustomerPage.setStateTxt(state);
        newCustomerPage.setPinTxt(pin);
        newCustomerPage.setPhoneTxt(mobile);
        newCustomerPage.setEmailTxt(name+random()+"@gmail.com");
        newCustomerPage.setPW(pw);

        newCustomerPage.submit();

        Assert.assertEquals(newCustomerPage.getMessageRegisterSuccess(),"Customer Registered Successfully!!!");
        customerId = newCustomerPage.getCustomerId();
        System.out.println(customerId);
    }


    @Test
    void TC02_CreateAccount(){
        homePage.clickNewAccountPage();
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.setCustomerId(customerId);
        newAccountPage.selectAccountType("Savings");
        newAccountPage.setInitialDeposit("50000");
        newAccountPage.submit();

        Assert.assertEquals(newAccountPage.getMessageCreateSuccess(),"Account Generated Successfully!!!");
        accountId = newAccountPage.getAccountId();
        System.out.println(accountId);
    }

    @Test
    void TC03_EditAccount(){
        homePage.clickEditAccountPage();
        editAccountPage = new EditAccountPage(driver);
        editAccountPage.setAccountNo(accountId);
        editAccountPage.clickSubmit();

    }

    int random(){
        Random random = new Random();
        int ra = random.nextInt(9999);
        return ra;
    }
}
