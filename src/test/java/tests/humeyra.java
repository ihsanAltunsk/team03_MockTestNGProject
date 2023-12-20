package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class humeyra {

    @Test
    public void testcase12(){
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully
        String expectedUrl="https://automationexercise.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        //4. Click 'Products' button
        AutoPage autoPage=new AutoPage();
        autoPage.productsLinki.click();

        //5. Hover over first product and click 'Add to cart'
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",autoPage.urunResmi);
        autoPage.addToCart.click();

        //       6. Click 'Continue Shopping' button
        autoPage.continueShopping.click();

        //7. Hover over second product and click 'Add to cart'

         //Actions actions=new Actions(Driver.getDriver());
         //actions.moveToElement(autoPage.urunResmi2);

        autoPage.addToCart2.click();

        //      8. Click 'View Cart' button
        autoPage.viewCart.click();

        //9. Verify both products are added to Cart
        Assert.assertTrue(autoPage.BlueTopInCart.isDisplayed());
        Assert.assertTrue(autoPage.MenTshirtInCart.isDisplayed());

        //10. Verify their prices, quantity and total price
        String expectedPrice=autoPage.price1.getText();
        String actualTotalPrice=autoPage.totalprice1.getText();
        Assert.assertEquals(actualTotalPrice,expectedPrice);

        String expectedquantity="1";
        String actualquantity=autoPage.quantity1.getText();
        Assert.assertEquals(actualquantity,expectedquantity);

        Driver.quitDriver();
    }
}



