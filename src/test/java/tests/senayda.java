package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class senayda {

    @Test
    public void testCase05() {

        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        //4. Click on 'Signup / Login' button
        AutoPage autoPage = new AutoPage();
        autoPage.signupLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(autoPage.newUserYaziElementi.isDisplayed());

        //6. Enter name and already registered email address
        Faker faker = new Faker();

        autoPage.nameButton.sendKeys(faker.name().firstName());
        autoPage.emailButton.sendKeys(ConfigReader.getProperty("correctEmail"));

        //7. Click 'Signup' button
        autoPage.signupButton.click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(autoPage.hataMesaji.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void testCase07(){

        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        //4. Click on 'Test Cases' button
        AutoPage autoPage = new AutoPage();
        autoPage.testCasesButton.click();

        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(autoPage.navigatedToTestCasesPage.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void testCase08(){

        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        //4. Click on 'Products' button
        AutoPage autoPage = new AutoPage();
        autoPage.ProductsClick.click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(autoPage.allProductsText.isDisplayed());

        //6. The products list is visible
        Assert.assertTrue(autoPage.searchedProductsText.isDisplayed());

        //7. Click on 'View Product' of first product
        autoPage.viewProductWomenClick.click();

        //8. User is landed to product detail page
        Assert.assertTrue(autoPage.productDetail.isDisplayed());

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(!(autoPage.productDetailsList.isEmpty()));
        Assert.assertTrue(autoPage.productDetail.isDisplayed());
        Assert.assertTrue(autoPage.productName.isDisplayed());
        Assert.assertTrue(autoPage.categoryElementi.isDisplayed());
        Assert.assertTrue(autoPage.priceElementi.isDisplayed());

        Driver.quitDriver();
    }
}
