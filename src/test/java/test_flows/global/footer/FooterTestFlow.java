package test_flows.global.footer;

import models.components.global.footer.*;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private WebDriver driver;


    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(){
        Assert.fail();
        BasePage basePage = new BasePage(driver);
        InformationColumn informationColumn = basePage.footerComp().informationColumn();
        CustomerServiceColumn customerServiceColumn = basePage.footerComp().customerServiceColumn();
        MyAccountColumn myAccountColumn = basePage.footerComp().myAccountColumn();
        FollowUsColumn followUsColumn = basePage.footerComp().followUsColumn();

        verifyInformationColumn(informationColumn);
        verifyCustomerServiceColumn(customerServiceColumn);
        verifyAccountColumn(myAccountColumn);
        verifyFollowUsColumn(followUsColumn);

    }

    private void verifyFollowUsColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList
                ( "Sitemap",
                        "Shipping & Returns",
                        "Privacy Notice",
                        "Conditions of Use",
                        "About us",
                        "Contact us"
                );
        List<String> expectedHrefs = Arrays.asList(
                "https://demowebshop.tricentis.com/sitemap",
                "https://demowebshop.tricentis.com/shipping-returns",
                "https://demowebshop.tricentis.com/privacy-policy",
                "https://demowebshop.tricentis.com/conditions-of-use",
                "https://demowebshop.tricentis.com/about-us",
                "https://demowebshop.tricentis.com/contactus"
        );
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);

      //  verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyAccountColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("");
        List<String> expectedHrefs = Arrays.asList("");
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);

        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("");
        List<String> expectedHrefs = Arrays.asList("");
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);

        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyInformationColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("");
        List<String> expectedHrefs = Arrays.asList("");
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);

        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
        Assert.fail();
    }

    private void verifyFooterColumn(
FooterColumnComponent footerColumnComponent, List<String> expectedLinkTests, List<String> expectedHrefs){
List<String> actualLinkTexts = new ArrayList<>();
List<String> actualHrefs = new ArrayList<>();

if(footerColumnComponent.linksElem().isEmpty()) Assert.fail("The column has no item to test");
        for (WebElement link : footerColumnComponent.linksElem()) {
            actualLinkTexts.add(link.getText().trim());
            actualHrefs.add(link.getAttribute("href"));

        }

        if (actualHrefs.isEmpty() || actualLinkTexts.isEmpty()) Assert.fail("Error .......");
// verify link text
Assert.assertEquals(actualLinkTexts, expectedLinkTests, "[Error] Link text list is mismatched");
Assert.assertEquals(actualHrefs, expectedHrefs, "[Error] Hyperlink list is mismatched");
    }
}
