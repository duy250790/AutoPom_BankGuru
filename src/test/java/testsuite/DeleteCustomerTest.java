package testsuite;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.DeleteCustomerPage;
import page.EditCustomerPage;
import page.HomePage;
import page.LoginPage;
import setups.BaseTests;

public class DeleteCustomerTest extends BaseTests {
    LoginPage loginPage;
    HomePage homePage;
    DeleteCustomerPage deleteCustomerPage;

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
                {" 25573","First character can not have space"},
                {"","Customer ID is required"},
                {"25573",""},
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
        deleteCustomerPage = new DeleteCustomerPage(driver);
    }

    @Test(dataProvider = "dataCustomerIdTest")
    void TC01_VerifyCustomerId(String customerId, String message) {
        deleteCustomerPage.setCustomerId(customerId);
        Assert.assertEquals(deleteCustomerPage.getMessageCustomerId(),message);
    }


    //34850,22492, 25573
}
