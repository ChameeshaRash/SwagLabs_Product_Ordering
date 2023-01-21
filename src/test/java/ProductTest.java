import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;
import utils.Configurations;

public class ProductTest {
    Configurations conf=new Configurations();
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        conf.openBrowser();
        conf.navigateURL("https://www.saucedemo.com/");
        driver=conf.getDriver();
        new LoginPage(driver)
                .successfulLogin("standard_user","secret_sauce")
                .getHeaderLabel();
    }

    @Test
    public void addToCart(){

        new ProductPage(driver).navigateToCart();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
