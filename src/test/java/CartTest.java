import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.Configurations;

public class CartTest {

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
    }
    @Test
    public void successNavigateCart(){
        String label2=new CartPage(driver)
                .getGetTitleLabel();
        Assert.assertEquals(label2,"YOUR CART","Error:Logged in cart page  is incorrect");
    }
    @AfterMethod
    public void ItemOk(){
        String label3=new CartPage(driver)
                .getItemCard();
        Assert.assertEquals(label3,"Sauce Labs Backpack","Error:Selected Item is incorrect");
    }

    @AfterClass
    public void ClickCheckout(){
        new CartPage(driver).clickCheckout();


    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }







}
