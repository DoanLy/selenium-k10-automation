package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

import static url.Urls.BASE_URL;
import static url.Urls.JS_ALERTS_SLUG;

public class JsAlerts implements Urls {

    private final static By jsAlertSel = By.cssSelector("button[onclick=\"jsAlert()\"]");
    private final static By jsConfirmSel = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    private final static By jsPromptSel = By.cssSelector("button[onclick=\"jsPrompt()\"]");
    private final static By resultTextSel = By.cssSelector("#result");


    public static void main(String[] args) {


        WebDriver driver  = DriverFactory.getChromeDriver();
        try{
            //Navigate
            driver.get(BASE_URL.concat(JS_ALERTS_SLUG));
            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5L));
            boolean isAcceptedAlert  = true;

            //JS alert |  ok
            WebElement triggerAJslertJsBtnElem = driver.findElement(jsAlertSel);
            handleAlert(wait, triggerAJslertJsBtnElem,isAcceptedAlert);
//            triggerAJslertJsBtnElem.click();
//
//            Alert  jsAlert = wait.until(ExpectedConditions.alertIsPresent());
//            jsAlert.accept();
            System.out.println("Result: "+driver.findElement(resultTextSel).getText());

            //JS confirm|cancel
            WebElement triggerJsConfirmElem = driver.findElement(jsConfirmSel);
            isAcceptedAlert = false;
            handleAlert(wait, triggerAJslertJsBtnElem,isAcceptedAlert);

//            triggerJsConfirmElem.click();
//
//            Alert jsConfirm  = wait.until(ExpectedConditions.alertIsPresent());
//           jsConfirm.dismiss();
            System.out.println("Result: "+driver.findElement(resultTextSel).getText());

            //JS prompt
            WebElement triggerJsPromptElem = driver.findElement(jsPromptSel);
            handleAlert(wait, triggerJsPromptElem, "My name is Teo" );
//            triggerJsPromptElem.click();
//
//            Alert jsPrompt  = wait.until(ExpectedConditions.alertIsPresent());
//            jsPrompt.sendKeys("My name  is Ly");
//            jsPrompt.accept();
            System.out.println("Result: "+driver.findElement(resultTextSel).getText());

        }catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
    private static void handleAlert(WebDriverWait wait,  WebElement alertElem, boolean isAccepted){
        alertElem.click();
Alert alert = wait.until(ExpectedConditions.alertIsPresent());
if(isAccepted) alert.accept();
else alert.dismiss();
    }

    private static void handleAlert(WebDriverWait wait,WebElement alertElem, String inputStr){
        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
alert.sendKeys(inputStr);
alert.accept();
    }
}
