package tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.lang.reflect.Array;

public class azim {
    @Test
    public  void test18(){
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};



/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that categories are visible on left side bar
4. Click on 'Women' category
5. Click on any category link under 'Women' category, for example: Dress
6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
7. On left side bar, click on any sub-category link of 'Men' category
8. Verify that user is navigated to that category page
 */

        AutoPage autoPage=new AutoPage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        // 3. Verify that categories are visible on left side bar
        Assert.assertTrue(autoPage.categories.isDisplayed());

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",autoPage.WomencategoryClick);
        ReusableMethods.bekle(1);

        //4. Click on 'Women' category
        autoPage.WomencategoryClick.click();

        //5.Click on any category link under 'Women' category, for example: Dress
        autoPage.dressClick.click();

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(autoPage.WomenDressProductsText.isDisplayed());

        //7. On left side bar, click on any sub-category link of 'Men' category
        autoPage.catagoryMen.click();
        autoPage.catagoryMenTsort.click();

        //8. Verify that user is navigated to that category page
        Assert.assertTrue(autoPage.MenProductsText.isDisplayed());

        Driver.closeDriver();
    }
@Test
    public  void test20(){


     /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well


       */
        AutoPage autoPage=new AutoPage();

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Click on 'Products' button
        autoPage.ProductsClick.click();

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(autoPage.allProducts.isDisplayed());

        //5. Enter product name in search input and click search button
        autoPage.searchproduct.sendKeys("DRESS");
        autoPage.submitsearchClick.click();

        //6. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(autoPage.searchedProducts.isDisplayed());

        //7. Verify all the products related to search are visible
        Assert.assertTrue(autoPage.searchedProducts.isDisplayed());

        //8. Add those products to cart
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",autoPage.addToCart);
        ReusableMethods.bekle(3);

        autoPage.addToCart.click();

        // 9. Click 'Cart' button and verify that products are visible in cart
        //Assert.assertTrue(automationPage.proceedToCheckout.isDisplayed());

        //10. Click 'Signup / Login' button and submit login details
        autoPage.signInLoginLinki20.click();

        autoPage.emailBox1.sendKeys("azimkaya777@gmail.com");
        autoPage.passwordBox1.sendKeys("5057906735");
        autoPage.loginLinkiClick1.click();















Driver.closeDriver();




    }


@Test
    public void test21(){


/*

1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Click on 'View Product' button
6. Verify 'Write Your Review' is visible
7. Enter name, email and review
8. Click 'Submit' button
9. Verify success message 'Thank you for your review.'
 */


            //1. Launch browser

            //2. Navigate to url 'http://automationexercise.com'
            Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));
             AutoPage autoPage=new AutoPage();

            //3. Click on 'Products' button
            autoPage.ProductsClick.click();

            //4. Verify user is navigated to ALL PRODUCTS page successfully
            Assert.assertTrue(autoPage.allProducts.isDisplayed());

            //5. Click on 'View Product' button
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();",autoPage.viewProducWomentClick);
            ReusableMethods.bekle(1);
            autoPage.viewProducWomentClick.click();


            //6. Verify 'Write Your Review' is visible
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(autoPage.writeYourReviewText.isDisplayed(),"Verify 'Write Your Review' is not visible");

            //7. Enter name, email and review
            Faker faker=new Faker();
            autoPage.yourReviewNameBox.sendKeys(faker.name().name());
            autoPage.yourReviewİmailBox.sendKeys(faker.internet().emailAddress());
            autoPage.addReviewHereBox.sendKeys(faker.lorem().paragraph());

            //8. Click 'Submit' button
            autoPage.buttonReview.click();

    Driver.closeDriver();

        }


}
