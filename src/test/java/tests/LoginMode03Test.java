package tests;

import driver.DriverFactory;
import models.pages.LoginPageMode02;
import models.pages.LoginPageMode03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMode03Test implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the  ...
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            //input login
            LoginPageMode03 loginPage  = new LoginPageMode03(driver);
            loginPage.inputUsername("Ly").inputPassword("12345678").clickOnBtn();

            //Debug
            Thread.sleep(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
