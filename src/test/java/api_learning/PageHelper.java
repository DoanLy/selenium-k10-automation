package api_learning;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;

public class PageHelper {
    private final static String SCROLL_TO_BOTTOM  = "window.scrollTo(0, document.body.scrollHeight)";
    private final static String SCROLL_TO_TOP  = "window.scrollTo(0, document.body.scrollHeight)";

    private JavascriptExecutor javascriptExecutor;

    public PageHelper(JavascriptExecutor javascriptExecutor){
          this.javascriptExecutor = javascriptExecutor;
    }
    public void scrollToBottom(){
        javascriptExecutor.executeScript(SCROLL_TO_BOTTOM);

    }

    public void scrollToTop(){
        javascriptExecutor.executeScript(SCROLL_TO_TOP);

    }

    public void removeElement( WebElement toBeRemoveElem){
        javascriptExecutor.executeScript("arguments[0].remove()", toBeRemoveElem);


    }

    public void changeElemStyleToFocusMode(WebElement  toBeChangeElem){
        javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 4px  solid red;' )", toBeChangeElem);

    }

    public void changeElemStyleToFocusMode(WebElement  toBeChangeElem, String customStyle){
       //to do:
    }

}
