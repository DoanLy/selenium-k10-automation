package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnable;
import url.Urls;

import java.time.Duration;

public class DynamicControl {
    public static void main(String[] args) {
        WebDriver  driver = DriverFactory.getChromeDriver();
        try{
driver.get(Urls.HEROKU_BASE_URL.concat(Urls.DYNAMIC_CONTROL_SLUG));

By checkboxFormSel = By.id("checkbox-example");
By inputFormSel = By.cssSelector("#input-example");

            WebElement checkboxFormElem  = driver.findElement(checkboxFormSel);
            WebElement  checkboxElem = checkboxFormElem.findElement(By.tagName("input"));

            if(!checkboxElem.isSelected()){
                checkboxElem.click();
            }

            //debug
            Thread.sleep(1000);

            WebElement inputFormElem =  driver.findElement(inputFormSel);
            WebElement inputFieldElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputFormBtnElem = inputFormElem.findElement(By.tagName("button"));

            if (!inputFieldElem.isEnabled()){
                inputFormBtnElem.click();
                //wait
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
                wait.until(new WaitForElementEnable(By.cssSelector("#input-example input")));
            }

            inputFieldElem.sendKeys("This is the new text");

            //debug
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
