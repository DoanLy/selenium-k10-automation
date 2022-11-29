package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.*;
//import sun.awt.windows.ThemeReader;
import url.Urls;

public class JsExecutor implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            //Navigate to the tarhet  page
            driver.get(BASE_URL.concat(FLOATING_MENUS_SLUG));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

            //scroll to bottom
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");


            //debug
            Thread.sleep(2000);

            //Scroll to top
            jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

            //debug
            Thread.sleep(2000);
            // Go to dynamic  control  page
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_SLUG));
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input_example");
            WebElement checkboxFormElem  = driver.findElement(checkboxFormSel);
            WebElement inputFormElem  = driver.findElement(inputFormSel);
            jsExecutor.executeScript("arguments[0].remove()",inputFormElem);

            jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 4px  solid red;' )", checkboxFormElem);

            //debug
            Thread.sleep(2000);


        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
