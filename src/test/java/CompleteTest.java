import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Configurations;

public class CompleteTest {
    Configurations conf=new Configurations();
    WebDriver driver;

    @BeforeMethod
    public void Clicked(){
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
        new InformationPage(driver)
                .navigateOverview("Chameesha","Rashani","22222");
        new OverviewPage(driver)
                .clickFinishButton();
    }
    @Test
    public void successNavigateToFinish(){

        new CompletePage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
