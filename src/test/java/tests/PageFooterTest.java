package tests;

import driver.DriverFactory;
import models.components.LoginFormComponent;
import models.pages.HerokuLoginPage;
import models.pages.LoginPageMode03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class PageFooterTest implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the  ...
            driver.get(HEROKU_BASE_URL.concat(LOGIN_FORM_SLUG));

            //input login
            HerokuLoginPage loginPage = new HerokuLoginPage(driver);
     //       System.out.println(loginPage.footerComp().getLinkText());
            LoginFormComponent loginFormComp = (LoginFormComponent) loginPage.loginFormComp();
            loginFormComp.usernameElem().sendKeys("teo");
            //Debug
            Thread.sleep(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
