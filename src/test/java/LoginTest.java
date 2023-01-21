import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;
import utils.Configurations;

public class LoginTest {

    Configurations conf=new Configurations();
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        conf.openBrowser();
        conf.navigateURL("https://www.saucedemo.com/");
        driver=conf.getDriver();
    }
    @Test
    public void successfulLogin(){
        String label=new LoginPage(driver)
                .successfulLogin("standard_user","secret_sauce")
                .getHeaderLabel();

        Assert.assertEquals(label,"PRODUCTS","Error:Logged in product page is incorrect");
    }



    @Test
    public void unSuccessfulLogin(){
        new LoginPage(driver).unSuccessfulLogin("standard_user","secret_sauce123");
        String label=new ProductPage(driver).getErrorLabel();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(label,"Epic sadface: Username and password do not match any user in this service","Error:message text is incorrect");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
