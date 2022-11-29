package tests;

import driver.DriverFactory;
import models.pages.LoginPageMode01;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMode01Test implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the  ...
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            //input login
            LoginPageMode01 loginPage  = new LoginPageMode01(driver);
            loginPage.usernameElem().sendKeys("Ly");
            loginPage.passwordElem().sendKeys("12345678");
            loginPage.loginBtnElem().click();
//Debug
            Thread.sleep(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
