package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

    WebDriver driver;



    By overviewHeaderLabel=By.xpath("/html/body/div/div/div/div[1]/div[2]/span");

    By itemTotalText=By.className("summary_subtotal_label");

    By taxText=By.className("summary_tax_label");

    By totalText=By.className("summary_total_label");
    By finishButton=By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]/button[2]");


    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOverviewHeaderLabel() {

        return driver.findElement(overviewHeaderLabel).getText();
    }


    public String getItemTotalText() {
        return driver.findElement(itemTotalText).getText();
    }

    public String getTaxText() {

        return driver.findElement(taxText).getText();
    }

    public String getTotalText() {

        return driver.findElement(totalText).getText();
    }


    public CompletePage clickFinishButton(){

        driver.findElement(finishButton).click();
        return new CompletePage(driver);


    }


}
