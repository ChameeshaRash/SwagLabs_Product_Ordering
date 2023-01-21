package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    By headerLabel=By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    By errorLabel=By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]");

    By addToCartProductButton=By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button");

    By cartImg=By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a");


    public ProductPage(WebDriver driver) {
        this.driver = driver;

    }
    public String getHeaderLabel() {

        return driver.findElement(headerLabel).getText();
    }
    public String getErrorLabel() {
        return driver.findElement(errorLabel).getText();
    }


    public ProductPage clickAddToCartButton(){
        driver.findElement(addToCartProductButton).click();
        return this;
    }
    public CartPage clickCartButton(){
//        clickAddToCartButton();
        driver.findElement(cartImg).click();
        return new CartPage(driver);
    }


    public CartPage navigateToCart(){
        clickAddToCartButton();
        clickCartButton();
        return new CartPage(driver);
    }











}
