package testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.NewCustomerPage;
import setups.BaseTests;

import java.util.Random;

public class NewCustomerTest extends BaseTests {
    LoginPage loginPage;
    HomePage homePage;
    NewCustomerPage newCustomerPage;

    @DataProvider(name = "dataLogin")
    Object[][] dataUser(){
        return new Object[][]{
                {"mngr432580","ytenUze"},
        };
    }

    @DataProvider(name = "dataCustomerNameTest")
    Object[][] dataNew(){
        return new Object[][]{
                {"123","Numbers are not allowed"},
                {"name123","Numbers are not allowed"},
                {"@!","Special characters are not allowed"},
                {"name!@","Special characters are not allowed"},
                {" name","First character can not have space"},
                {"","Customer name must not be blank"},
        };
    }

    @DataProvider(name = "dataAddressTest")
    Object[][] dataAddress(){
        return new Object[][]{
                {" address","First character can not have space"},
                {"","Address Field must not be blank"},
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

    @DataProvider(name = "dataFillCustomer")
    Object[][] dataFill(){
        return new Object[][]{
                {"","F","01/01/2000","5 VO Van Ngan","HCM","TD","500000","1234098765","123456"},
                {"anoly","F","","5 VO Van Ngan","HCM","TD","500000","1234098765","123456"},
                {"anoly","F","01/01/2000","","HCM","TD","500000","1234098765","123456"},
                {"anoly","F","01/01/2000","5 VO Van Ngan","","TD","500000","1234098765","123456"},
                {"anoly","F","01/01/2000","5 VO Van Ngan","HCM","","500000","1234098765","123456"},
                {"anoly","F","01/01/2000","5 VO Van Ngan","HCM","TD","","1234098765","123456"},
                {"anoly","F","01/01/2000","5 VO Van Ngan","HCM","TD","500000","","123456"},
                {"anoly","F","01/01/2000","5 VO Van Ngan","HCM","TD","500000","1234098765",""},
        };
    }

    @DataProvider(name = "dataValidCustomer")
    Object[][] dataValidCustomer(){
        return new Object[][]{
                {"anoly","M","01/01/2000","5 VO Van Ngan","HCM","TD","500000","1234098765","123456"},
        };
    }

    @Test(dataProvider = "dataLogin")
    void TC00_LoginAndSelectNewCustomerMenu(String userId, String password) throws InterruptedException {
        //login page
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

    @Test(dataProvider = "dataCustomerNameTest")
    void TC01_VerifyNameField(String input, String message) {
        newCustomerPage.setNameTxt(input);
        Assert.assertEquals(newCustomerPage.getMessageCusName(),message);
    }

    @Test(dataProvider = "dataAddressTest")
    void TC02_VerifyAddressField(String input, String message){
        newCustomerPage.setAddressTxt(input);
        Assert.assertEquals(newCustomerPage.getMessageAddress(),message);
    }

    @Test(dataProvider = "dataCityTest")
    void TC03_VerifyCityField(String input, String message){
        newCustomerPage.setCityTxt(input);
        Assert.assertEquals(newCustomerPage.getMessageCity(),message);
    }

    @Test(dataProvider = "dataStateTest")
    void TC04_VerifyStateField(String input, String message){
        newCustomerPage.setStateTxt(input);
        Assert.assertEquals(newCustomerPage.getMessageState(),message);
    }

    @Test(dataProvider = "dataPinTest")
    void TC05_VerifyPinField(String input, String message){
        newCustomerPage.setPinTxt(input);
        Assert.assertEquals(newCustomerPage.getMessagePin(),message);
    }

    @Test(dataProvider = "dataPhoneTest")
    void TC06_VerifyPhoneField(String input, String message){
        newCustomerPage.setPhoneTxt(input);
        Assert.assertEquals(newCustomerPage.getMessagePhone(),message);
    }

    @Test(dataProvider = "dataEmailTest")
    void TC07_VerifyEmailField(String input, String message){
        newCustomerPage.setEmailTxt(input);
        Assert.assertEquals(newCustomerPage.getMessageEmail(),message);
    }

    @Test(dataProvider = "dataFillCustomer")
    void TC08_VerifyShowRequireField(String name, String gender, String bir, String address, String city, String state, String pin, String mobile, String pw){
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
        Assert.assertEquals(newCustomerPage.getTextAlert(driver),"please fill all fields");
        newCustomerPage.acceptAlert(driver);
    }

    @Test(dataProvider = "dataValidCustomer")
    void TC09_VerifyCreateNewCustomerValid(String name, String gender, String bir, String address, String city, String state, String pin, String mobile, String pw){
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
        System.out.println(newCustomerPage.getCustomerId());
    }

    int random(){
        Random random = new Random();
        int ra = random.nextInt(9999);
        return ra;
    }
    //34850,22492, 25573
}
