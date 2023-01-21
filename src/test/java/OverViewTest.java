import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Configurations;

public class OverViewTest {
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
        new InformationPage(driver)
                .navigateOverview("Chameesha","Rashani","22222");

    }

    @Test
    public void successOverView(){
        String label5=new OverviewPage(driver).getOverviewHeaderLabel();
        Assert.assertEquals(label5,"CHECKOUT: OVERVIEW","Error:Information Page is Incorrect");

    }

    @Test
    public void successTotal(){
//        new OverviewPage(driver).successTotal();
        String label6=new OverviewPage(driver).getItemTotalText();
        Assert.assertEquals(label6.contains("Item total1: $"),true,"Not having a item cost");

        String label7=new OverviewPage(driver).getTaxText();
        Assert.assertEquals(label7.contains("Tax: $"),true,"Not having a tax cost");

        String label8=new OverviewPage(driver).getTotalText();
        Assert.assertEquals(label8.contains("Total: $"),true,"Not having a Total cost");

    }

//    @Test
//    public void unSuccessTotal(){
//        new OverviewPage(driver).unSuccessTotal();
//        String label6=new OverviewPage(driver).getItemTotalText();
//        String label7=new OverviewPage(driver).getTaxText();
//        String label8=new OverviewPage(driver).getTotalText();
//
//        SoftAssert softAssert2=new SoftAssert();
//        softAssert2.assertEquals(label6.contains("Item total1: $"),true,"Error:Overview page is incorrect");
//        softAssert2.assertEquals(label7.contains("Tax: $"),true,"Not having a tax cost");
//        softAssert2.assertEquals(label8.contains("Total: $"),true,"Not having a Total cost");
//
//    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

