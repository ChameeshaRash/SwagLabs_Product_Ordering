package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {


    WebDriver driver;

    By userText =By.id("user-name");
    By passwordText = By.id("password");

    By loginButton = By.id("login-button");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



    public LoginPage enterUserName(String username){
            driver.findElement(userText).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
            driver.findElement(passwordText).sendKeys(password);
        return this;

    }

    public LoginPage clickLoginButton(){
            driver.findElement(loginButton).click();
        return this;
    }

    public ProductPage successfulLogin(String userName, String password){
            enterUserName(userName);
            enterPassword(password);
            clickLoginButton();
        return new ProductPage(driver);
    }
    public LoginPage unSuccessfulLogin(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
        return this;
    }



}
