package tests.testng;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Verifier;
public class TestNgOrder {
    @Test(dependsOnMethods = {"test B"})
    public void testA(){
        System.out.println("Test A");
    }
    @Test
    public void testB(){
        System.out.println("Test B");

        //throw new RuntimeException("Err ...");
//        Assert.assertEquals(1,3, "[err] ....");
//        Assert.assertTrue(true);
//        Assert.assertFalse(true);

//        if(list.isEmpty())
//            Assert.fail("There is no .....");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1,3, "[err] ....");
        System.out.println("Hello");
    }
}
