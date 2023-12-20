package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoPage;
import pages.AutoSignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class humeyra {
    AutoSignUpPage autoSignUpPage = new AutoSignUpPage();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testcase12() {
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        //4. Click 'Products' button
        AutoPage autoPage = new AutoPage();
        autoPage.productsLinki.click();

        //5. Hover over first product and click 'Add to cart'
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", autoPage.urunResmi);
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
        String expectedPrice = autoPage.price1.getText();
        String actualTotalPrice = autoPage.totalprice1.getText();
        Assert.assertEquals(actualTotalPrice, expectedPrice);

        String expectedquantity = "1";
        String actualquantity = autoPage.quantity1.getText();
        Assert.assertEquals(actualquantity, expectedquantity);

        Driver.quitDriver();
    }

    @Test
    public void testcase15() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));
        //3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // 4. Click 'Signup / Login' button
        AutoPage autoPage=new AutoPage();
        autoPage.signupLoginButton.click();
        // 5. Fill all details in Signup and create account
        autoSignUpPage.nametextbox.sendKeys(faker.name().fullName());
        autoSignUpPage.emailtextbox.sendKeys(faker.internet().emailAddress());
        autoSignUpPage.signupbutton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(autoSignUpPage.titlecheckboxmr)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("20")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1994")
                .sendKeys(Keys.TAB)
                .perform();
        autoSignUpPage.newslettercheckbox.click();
            actions .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
               .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().secondaryAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        // 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(autoSignUpPage.acccreatedtext.isDisplayed());
        autoSignUpPage.countinuebutton.click();
        // 7. Verify ' Logged in as username' at top
        Assert.assertTrue(autoPage.loggedtext.isDisplayed());
        // 8. Add products to cart
        autoPage.productsLinki.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", autoPage.urunResmi);
        autoPage.addToCart.click();
        autoPage.continueShopping.click();
        autoPage.addToCart2.click();
        autoPage.continueShopping.click();

        // 9. Click 'Cart' button
       autoPage.cartButton.click();
        // 10. Verify that cart page is displayed
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(autoPage.shoppingCart.isDisplayed()," cart page is not displayed");
        // 11. Click Proceed To Checkout
        autoPage.proceedToCheckoutButton.click();
        // 12. Verify Address Details and Review Your Order
        softAssert.assertTrue(autoPage.Yourdeliveryaddress.isDisplayed(),"delivery address is not same address");
        // 13. Enter description in comment text area and click 'Place Order'
        autoPage.commentTextArea.sendKeys("alısveris yapildi");
         autoPage.placeOrder.click();
        // 14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        // 15. Click 'Pay and Confirm Order' button
        // 16. Verify success message 'Your order has been placed successfully!'
        //17. Click 'Delete Account' button
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
       // Driver.closeDriver();

    }
}




