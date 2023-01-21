package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {
    WebDriver driver;

    By firstNameText=By.id("first-name");
    By lastNameText=By.id("last-name");
    By postalCodeText=By.id("postal-code");

    By continueButton=By.id("continue");

    public InformationPage(WebDriver driver) {
        this.driver = driver;
    }


    public InformationPage enterFirstNameText(String firstName){
        driver.findElement(firstNameText).sendKeys(firstName);
        return this;
    }

    public InformationPage enterLastNameText(String lastName){
        driver.findElement(lastNameText).sendKeys(lastName);
        return this;

    }

    public InformationPage enterPostalCodeText(String postalCode){
        driver.findElement(postalCodeText).sendKeys(postalCode);
        return this;
    }


    public InformationPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new InformationPage(driver);
    }

    public OverviewPage navigateOverview(String firstName,String lastName,String postalCode){
        enterFirstNameText(firstName);
        enterLastNameText(lastName);
        enterPostalCodeText(postalCode);
        clickContinueButton();
        return new OverviewPage(driver);
    }
}

