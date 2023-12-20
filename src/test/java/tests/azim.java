package tests;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class azim {
    @Test
    public  void test18(){

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

    public  void test20(){



    }



    public void test21(){




    }

}
