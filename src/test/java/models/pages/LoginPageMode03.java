package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageMode03 {
    private final WebDriver driver;
    private final static By usernameSel = By.id("#username");
    private final static By passwordSel = By.cssSelector("#password");
    private final static  By loginBtnSel = By.cssSelector("button[type='submit']");


    public LoginPageMode03(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPageMode03 inputUsername(String username){
        driver.findElement(usernameSel).sendKeys(username);
        return this;
    }
    public LoginPageMode03 inputPassword(String password){
        driver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public  LoginPageMode03 clickOnBtn(){
        driver.findElement(loginBtnSel).click();
        return this;
    }



}
