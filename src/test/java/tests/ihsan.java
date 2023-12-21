package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoPage;
import pages.AutoSignUpPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ihsan {

    @Test
    public void testCase3(){
        // 1- Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        // 2- Verify that home page is visible successfully
        SoftAssert softAssert = new SoftAssert();
        AutoPage autoPage = new AutoPage();

        softAssert.assertTrue(autoPage.homePageSlider.isDisplayed(),
                "You are NOT on the home page!");

        // 3- Click on 'Signup / Login' button
        autoPage.signupLoginButton.click();

        // 4- Verify 'Login to your account' is visible
        softAssert.assertTrue(autoPage.loginToYourAccount.isDisplayed(),
                "'Login to your account' is NOT visible!");

        // 5- Enter incorrect email address and password
        autoPage.emailBox.sendKeys(ConfigReader.getProperty("wrongEmail"));
        autoPage.passwordBox.sendKeys(ConfigReader.getProperty("wrongPassword"));

        // 6- Click 'login' button
        autoPage.loginButton.click();

        // 7- Verify error 'Your email or password is incorrect!' is visible
        softAssert.assertTrue(autoPage.loginErrorMessage.isDisplayed(),
                "'Your email or password is incorrect!' is NOT visible!");

        Driver.quitDriver();
    }
    @Test
    public void testCase14(){
        // 1- Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        // 2- Verify that home page is visible successfully
        SoftAssert softAssert = new SoftAssert();
        AutoPage autoPage = new AutoPage();

        softAssert.assertTrue(autoPage.homePageSlider.isDisplayed(),
                "You are NOT on the home page!");

        // 3- Add products to cart
        autoPage.addToCart.click();
        autoPage.continueShopping.click();

        // 4- Click 'Cart' button
        autoPage.cartButton.click();

        // 5- Verify that cart page is displayed
        softAssert.assertTrue(autoPage.cartVerify.isDisplayed(),
                "You are NOT on the cart page!");

        // 6- Click Proceed To Checkout
        autoPage.proceedToCheckoutButton.click();

        // 7- Click 'Register / Login' button
        autoPage.registerLoginButton.click();

        // 8- Fill all details in Signup and create account
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        AutoSignUpPage autoSignUpPage = new AutoSignUpPage();

        autoSignUpPage.nametextbox.sendKeys(faker.name().firstName());
        autoSignUpPage.emailtextbox.sendKeys(faker.internet().emailAddress());
        autoSignUpPage.signupbutton.click();

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
        actions.click(autoSignUpPage.partnerscheckbox)
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

        // 9- Verify 'ACCOUNT CREATED!' and click 'Continue' button
        softAssert.assertTrue(autoSignUpPage.acccreatedtext.isDisplayed(),
                "'ACCOUNT CREATED!' is NOT visible!");
        autoSignUpPage.countinuebutton.click();

        // 10- Verify 'Logged in as username' at top
        softAssert.assertTrue(autoPage.loggedtext.isDisplayed(),
                "'Logged in as username' is NOT visible!");

        // 11- Click 'Cart' button
        autoPage.cartButton.click();

        // 12- Click 'Proceed To Checkout' button
        autoPage.proceedToCheckoutButton.click();

        // 13- Verify Address Details and Review Your Order
        softAssert.assertTrue(autoPage.adressDetailsVerify.isDisplayed(),
                "'Address Details' is NOT visible!");
        softAssert.assertTrue(autoPage.reviewYourOrderVerify.isDisplayed(),
                "'Review Your Order' is NOT visible!");

        // 14- Enter description in comment text area and click 'Place Order'
        autoPage.textArea.sendKeys(faker.resolve("lorem.words"));
        autoPage.placeOrderButton.click();

        // 15- Enter payment details: Name on Card, Card Number, CVC, Expiration date
        autoPage.nameOnCardBox.sendKeys(faker.name().fullName());
        autoPage.cardNumberBox.sendKeys(ConfigReader.getProperty("creditCardNumber"));
        autoPage.cvcBox.sendKeys(ConfigReader.getProperty("cvc"));
        autoPage.expiryMonthBox.sendKeys(ConfigReader.getProperty("expiryMonth"));
        autoPage.expiryYearBox.sendKeys(ConfigReader.getProperty("expiryYear"));

        // 16- Click 'Pay and Confirm Order' button
        autoPage.payAndConfirmButton.click();

        // 17- Verify success message 'Your order has been placed successfully!'
        softAssert.assertTrue(autoPage.orderPlacedSuccesVerify.isDisplayed(),
                "'Your order has been placed successfully!' is NOT visible!");

        // 18- Click 'Delete Account' button
        autoPage.deleteaccount.click();

        // 19- Verify 'ACCOUNT DELETED!' and click 'Continue' button
        softAssert.assertTrue(autoPage.accdeleted.isDisplayed(),
                "'ACCOUNT DELETED!' is NOT visible!");
        autoSignUpPage.countinuebutton.click();

        Driver.quitDriver();
    }
    @Test
    public void testCase19(){
        // 1- Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        // 2- Click on 'Products' button
        AutoPage autoPage = new AutoPage();
        autoPage.productsLinki.click();

        // 3- Verify that Brands are visible on left side bar
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!autoPage.brandsElements.isEmpty(),
                "Brands are NOT visible!");

        // 4- Click on any brand name
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",autoPage.kookieKidsButton);
        autoPage.kookieKidsButton.click();

        // 5- Verify that user is navigated to brand page and brand products are displayed
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(
                "https://automationexercise.com/brand_products/Kookie%20Kids"),
                "You are NOT on the selected brand page!");

        softAssert.assertTrue(!autoPage.productElements.isEmpty(),
                "Products are NOT visible");

        // 6- On left side bar, click on any other brand link
        autoPage.bibaButton.click();

        // 7- Verify that user is navigated to that brand page and can see products
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(
                "https://automationexercise.com/brand_products/Biba"),
                "You are NOT on the selected brand page!");

        softAssert.assertTrue(!autoPage.productElements.isEmpty(),
                "Products are NOT visible");

        Driver.quitDriver();
    }
}
