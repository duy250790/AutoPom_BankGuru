package setups;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTests {

    protected  WebDriver driver;
    protected String URL = "https://demo.guru99.com/v4/";

    @Parameters("browser")
    @BeforeTest
    public void setup(String browser){
        driver = Drivers.initiateDriver(browser);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        /**
         * Capture screenshot when test failed only
         */
        String testName = result.getMethod().getMethodName();

        if (!result.isSuccess()) {
            System.out.printf("Test : %s is FAIL\n", testName);
            testName = testName + "-" + System.currentTimeMillis();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(String.format("./target/screen-shots/%s.png", testName)));
        } else {
            System.out.printf("Test : %s is PASS\n", testName);
        }
    }

    @AfterTest
    public void clearUp(){
        //driver.quit();
    }
}
