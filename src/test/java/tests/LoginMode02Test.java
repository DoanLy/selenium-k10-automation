package tests;

import driver.DriverFactory;
import models.pages.LoginPageMode01;
import models.pages.LoginPageMode02;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMode02Test implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the  ...
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            //input login
            LoginPageMode02 loginPage  = new LoginPageMode02(driver);
            loginPage.inputUsername("Ly");
            loginPage.inputPassword("12345678");
            loginPage.clickOnBtn();
//Debug
            Thread.sleep(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
