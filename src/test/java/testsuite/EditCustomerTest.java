package testsuite;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.EditCustomerPage;
import page.HomePage;
import page.LoginPage;
import page.NewCustomerPage;
import setups.BaseTests;

import java.util.Random;

public class EditCustomerTest extends BaseTests {
    LoginPage loginPage;
    HomePage homePage;
    EditCustomerPage editCustomerPage;

    @DataProvider(name = "dataLogin")
    Object[][] dataUser(){
        return new Object[][]{
                {"mngr432580","ytenUze"},
        };
    }

    @DataProvider(name = "dataCustomerIdTest")
    Object[][] dataCustomerId(){
        return new Object[][]{
                {"acb123","Characters are not allowed"},
                {"123acv","Characters are not allowed"},
                {"@!","Special characters are not allowed"},
                {"1214343!@","Special characters are not allowed"},
                {" name","First character can not have space"},
                {"","Customer ID is required"},
                {"25573",""},
        };
    }

    @DataProvider(name = "dataCityTest")
    Object[][] dataCity(){
        return new Object[][]{
                {"@!","Special characters are not allowed"},
                {"city!@","Special characters are not allowed"},
                {" city","First character can not have space"},
                {"","City Field must not be blank"},
        };
    }

    @DataProvider(name = "dataStateTest")
    Object[][] dataState(){
        return new Object[][]{
                {"@!","Special characters are not allowed"},
                {"state!@","Special characters are not allowed"},
                {" state","First character can not have space"},
                {"","State must not be blank"},
        };
    }

    @DataProvider(name = "dataPinTest")
    Object[][] dataPin(){
        return new Object[][]{
                {"PIN","Characters are not allowed"},
                {"123PIN","Characters are not allowed"},
                {"@!","Special characters are not allowed"},
                {"PIN!@","Special characters are not allowed"},
                {"123","PIN Code must have 6 Digits"},
                {"12345","PIN Code must have 6 Digits"},
                {" PIN","First character can not have space"},
                {"","PIN Code must not be blank"},
        };
    }

    @DataProvider(name = "dataPhoneTest")
    Object[][] dataPhone(){
        return new Object[][]{
                {"123 123","Characters are not allowed"},
                {"123Phone","Characters are not allowed"},
                {"868686@!","Special characters are not allowed"},
                {"868686@!12","Special characters are not allowed"},
                {"@186868612","Special characters are not allowed"},
                {" Phone","First character can not have space"},
                {"","Mobile no must not be blank"},
        };
    }

    @DataProvider(name = "dataEmailTest")
    Object[][] dataEmail(){
        return new Object[][]{
                {"anoly@gmail","Email-ID is not valid"},
                {"anoly@gmail.","Email-ID is not valid"},
                {"anolygmail.com","Email-ID is not valid"},
                {"anoly@","Email-ID is not valid"},
                {"anoly","Email-ID is not valid"},
                {" anoly@gmail.com","First character can not have space"},
                {"","Email-ID must not be blank"},
        };
    }

    @DataProvider(name = "dataAddressTest")
    Object[][] dataAddress(){
        return new Object[][]{
                {" address","First character can not have space"},
                {"","Address Field must not be blank"},
        };
    }

    @Test(dataProvider = "dataLogin")
    void TC00_LoginAndSelectEditCustomerMenu(String userId, String password) throws InterruptedException {
        //login page
        loginPage = new LoginPage(driver);
        loginPage.setUserId(userId);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");

        //Click Edit customer
        homePage = new HomePage(driver);
        homePage.clickEditCustomerPage();
        editCustomerPage = new EditCustomerPage(driver);
    }

    @Test(dataProvider = "dataCustomerIdTest")
    void TC01_VerifyCustomerId(String customerId, String message) {
        editCustomerPage.setCustomerId(customerId);
        Assert.assertEquals(editCustomerPage.getMessageCustomerId(),message);
        if(editCustomerPage.getMessageCustomerId().isBlank()){
            editCustomerPage.submit();
            Assert.assertTrue(editCustomerPage.isDisplayEditCustomerLabel());
        }
    }

    @Test(dataProvider = "dataAddressTest")
    void TC02_VerifyAddressField(String input, String message) {
        editCustomerPage.setAddressTxt(input);
        Assert.assertEquals(editCustomerPage.getMessageAddress(),message);
    }

    @Test(dataProvider = "dataCityTest")
    void TC03_VerifyCityField(String input, String message){
        editCustomerPage.setCityTxt(input);
        Assert.assertEquals(editCustomerPage.getMessageCity(),message);
    }

    @Test(dataProvider = "dataStateTest")
    void TC04_VerifyStateField(String input, String message){
        editCustomerPage.setStateTxt(input);
        Assert.assertEquals(editCustomerPage.getMessageState(),message);
    }

    @Test(dataProvider = "dataPinTest")
    void TC05_VerifyPinField(String input, String message){
        editCustomerPage.setPinTxt(input);
        Assert.assertEquals(editCustomerPage.getMessagePin(),message);
    }

    @Test(dataProvider = "dataPhoneTest")
    void TC06_VerifyPhoneField(String input, String message){
        editCustomerPage.setPhoneTxt(input);
        Assert.assertEquals(editCustomerPage.getMessagePhone(),message);
    }

    @Test(dataProvider = "dataEmailTest")
    void TC07_VerifyEmailField(String input, String message) {
        editCustomerPage.setEmailTxt(input);
        Assert.assertEquals(editCustomerPage.getMessageEmail(), message);

    }
        //34850,22492, 25573
}
