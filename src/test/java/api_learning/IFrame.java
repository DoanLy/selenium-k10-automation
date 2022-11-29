package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class IFrame {
    public static void main(String[] args) {
        //iframe [id^="mce]

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
driver.get(Urls.HEROKU_BASE_URL.concat(Urls.IFRAME_SLUG));
            //Locate
            WebElement iFrameElem = driver.findElement(By.cssSelector("iframe[id^='mce']"));
            //Switch
driver.switchTo().frame(iFrameElem);

            //Input text  into  the  input  text area
            WebElement  editorInpuElem =driver.findElement(By.cssSelector("#tinymce"));
            editorInpuElem.click();
            editorInpuElem.clear();
            editorInpuElem.sendKeys("This is the new value ......\nAnd  this  is the new line");

            //Switch
            driver.switchTo().defaultContent();
            System.out.println(driver.findElement(By.partialLinkText("Selenium")).getAttribute("href"));

//debug
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
