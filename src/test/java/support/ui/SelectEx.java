package support.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectEx  extends Select {
    private static final String OPTION_1 = "Option 1";
    public SelectEx(WebDriver dropdownElem){
        super((WebElement) dropdownElem);
    }

    public void selectOption01(){
        selectByVisibleText(OPTION_1);
    }
}
