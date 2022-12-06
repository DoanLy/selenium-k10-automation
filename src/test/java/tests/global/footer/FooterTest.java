package tests.global.footer;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_flows.global.footer.FooterTestFlow;
import tests.BaseTest;
import url.Urls;

public class FooterTest extends BaseTest {
    @Test
    public void testHomePageFooter() {

        driver.get(Urls.BASE_URL);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();

    }

    @Test
    public void testCategoryPageFooter() {
            driver.get(Urls.BASE_URL);
            Assert.fail("Demo taking screenshot!");
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent();
    }

//    @Test
//    public void testLoginPageFooter() {
//        WebDriver driver = DriverFactory.getChromeDriver();
//        try {
//            driver.get(Urls.BASE_URL);
//            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
//            footerTestFlow.verifyFooterComponent();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.quit();
//        }
  //  }
}
