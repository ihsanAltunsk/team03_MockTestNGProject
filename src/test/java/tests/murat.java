package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoPage;
import pages.AutoSignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class murat {
    AutoPage autoPage = new AutoPage();
    AutoSignUpPage autoSignUpPage = new AutoSignUpPage();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

    @Test(groups = {"regression","murat"},priority = 1)
    public void testCase1(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(autoPage.homepagelink.isEnabled());

        //4. Click on 'Signup / Login' button
        autoPage.singupbutton.click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(autoSignUpPage.newusersiguptext.isDisplayed());

        //6. Enter name and email address
        autoSignUpPage.nametextbox.sendKeys(faker.name().fullName());
        autoSignUpPage.emailtextbox.sendKeys(faker.internet().emailAddress());

        //7. Click 'Signup' button
        autoSignUpPage.signupbutton.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String expectedtext = "ENTER ACCOUNT INFORMATION";
        String actualtext = autoSignUpPage.informationstext.getText() ;

        Assert.assertEquals(actualtext,expectedtext);

        //9. Fill details: Title, Name, Email, Password, Date of birth

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

        //10. Select checkbox 'Sign up for our newsletter!'
        autoSignUpPage.newslettercheckbox.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        actions.click(autoSignUpPage.partnerscheckbox)

                //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
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

                //13. Click 'Create Account button'
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(autoSignUpPage.acccreatedtext.isDisplayed());

        //15. Click 'Continue' button
        autoSignUpPage.countinuebutton.click();

        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(autoPage.loggedtext.isDisplayed());

        //17. Click 'Delete Account' button
        autoPage.deleteaccount.click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(autoPage.accdeleted.isDisplayed());
        autoSignUpPage.countinuebutton.click();

        Driver.closeDriver();
    }

    @Test(groups = {"regression","murat"},priority = 9)
    public void testCase9(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(autoPage.homepagelink.isEnabled());

        //4. Click on 'Products' button
        autoPage.productsLinki.click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(autoPage.allProductsText.isDisplayed());

        //6. Enter product name in search input and click search button
        autoPage.searchBox.sendKeys(ConfigReader.getProperty("product"));
        autoPage.searchBoxButton.click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(autoPage.searchedProductsText.isDisplayed());

        //8. Verify all the products related to search are visible
        Assert.assertTrue(autoPage.urunResmi.isDisplayed());

        Driver.closeDriver();
    }

    @Test(groups = {"regression","murat"},priority = 11)
    public void testCase11(){

    }
}