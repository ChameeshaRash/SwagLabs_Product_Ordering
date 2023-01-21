import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Configurations;

public class InformationTest {

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
        new ProductPage(driver)
                .navigateToCart();
        new CartPage(driver)
                .clickCheckout();
    }

    @Test
    public void enterInformation(){
        new InformationPage(driver).navigateOverview("Chameesha","Rashani","20991");
        new OverviewPage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
