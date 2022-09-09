package testsuite;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;
import setups.BaseTests;

import java.util.Random;

public class FlowCustomer extends BaseTests {
    LoginPage loginPage;
    HomePage homePage;
    NewCustomerPage newCustomerPage;
    EditCustomerPage editCustomerPage;
    DeleteCustomerPage deleteCustomerPage;
    String customerId = "";

    @DataProvider(name = "dataLogin")
    Object[][] dataUser(){
        return new Object[][]{
                {"mngr437483","ynezupy"},
        };
    }

    @DataProvider(name = "dataNewCustomer")
    Object[][] dateNewCustomer(){
        return new Object[][]{
                {"anolyAK","M","01/01/2000","5 VO Van Ngan","HCM","TD","500000","1234098765","123456"},
        };
    }

    @DataProvider(name = "dataEditCustomer")
    Object[][] dataAddress(){
        return new Object[][]{
                {"10 VO Van Ngan"},
        };
    }

    @Test(dataProvider = "dataLogin")
    void TC00_LoginAndClickNewCustomerMenu(String userId, String password) throws InterruptedException {
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

    @Test(dataProvider = "dataNewCustomer")
    void TC01_CreateNewCustomer(String name, String gender, String bir, String address, String city, String state, String pin, String mobile, String pw){
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
    }

    @Test(dataProvider = "dataEditCustomer")
    public void TC02_EditAddressCustomer(String address){
        homePage.clickEditCustomerPage();
        editCustomerPage = new EditCustomerPage(driver);
        editCustomerPage.setCustomerId(customerId);
        editCustomerPage.submit();
        editCustomerPage.setAddressTxt(address);
        editCustomerPage.submitEdit();

        Assert.assertEquals(editCustomerPage.getTextAlert(driver),"No Changes made to Customer records");
        editCustomerPage.acceptAlert(driver);

        editCustomerPage.setCustomerId(customerId);
        editCustomerPage.submit();
        Assert.assertEquals(editCustomerPage.getAddressText(),address);

    }

    @Test
    public void TC03_DeleteCustomer(){
        homePage.clickDeleteCustomerPage();
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.setCustomerId(customerId);
        deleteCustomerPage.submit();

        Assert.assertEquals(deleteCustomerPage.getTextAlert(driver),"Do you really want to delete this Customer?");
        deleteCustomerPage.acceptAlert(driver);

        Assert.assertEquals(deleteCustomerPage.getTextAlert(driver),"Customer does not Exist!!!");
        deleteCustomerPage.acceptAlert(driver);
    }

    int random(){
        Random random = new Random();
        int ra = random.nextInt(9999);
        return ra;
    }
}
