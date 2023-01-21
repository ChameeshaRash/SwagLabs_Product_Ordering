package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By getTitleLabel=By.xpath("/html/body/div/div/div/div[1]/div[2]/span");

    By getItemCard=By.xpath("//*[@id=\"item_4_title_link\"]/div");

    By getCheckoutButton=By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]");

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    public String getGetTitleLabel() {

        return driver.findElement(getTitleLabel).getText();
    }
    public String getItemCard(){

        return driver.findElement(getItemCard).getText();
    }

    public InformationPage clickCheckout(){
        getGetTitleLabel();
        getItemCard();
        driver.findElement(getCheckoutButton).click();
        return new InformationPage(driver);
    }



}
