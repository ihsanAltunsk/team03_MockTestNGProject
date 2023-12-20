package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class burcu {

    @Test
    public void test01() {


        // 2.  url ye gıt 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));
        // 3. Anasayfanın basarıyla goruntulendıgını dogrulayın
        AutoPage autoPage = new AutoPage();
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://automationexercise.com";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl);

        // 4. kayıt giris dugmesıne tıkla
        autoPage.signupLoginButton.click();
        //  5. hesabınıza gırıs yapamanın gorunur oldugunu dogrulayın
        Assert.assertTrue(autoPage.Logintoyouraccount.isDisplayed());
        // 6. dogru e posta adresını ve sıfreyı gırın
        autoPage.emailauto.sendKeys(ConfigReader.getProperty("correctEmail"));
        autoPage.passwordKutusu.sendKeys(ConfigReader.getProperty("correctPassword"));
        // 7. giriş dugmesıne tıklayın
        autoPage.autoLogin.click();

        // 9. Hesabı sıl butonuna tıklayın
        //autoPage.deleteaccount.click();
        //10. silinen hesabın görunur oldugunu dogrulayın
        //Assert.assertTrue(autoPage.Loggedinas.isDisplayed());

        Driver.quitDriver();
    }
    @Test
    public void testcase06() {


        // 1. Launch browser
        //2. Navigate to url https://automationexercise.com(url 'ye gıt)
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl1"));
        //3. Verify that home page is visible successfully(ana sayfanın basarıyla gorunur oldugunu dogrulayın)
        AutoPage autoPage=new AutoPage();
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://automationexercise.com";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);
        //4. Scroll down to footer(alt bılgıye dogru asagı kaydır)
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",autoPage.subscription);

        //5. Verify text 'SUBSCRIPTION'(metın abonelıgını dogrula)
        Assert.assertTrue(autoPage.subscription.isDisplayed());
        // 6. Enter email address in input and click arrow button(girise eposta adresını gırın ve ok dugmesıne tıklayın)
        // autoPage.emailauto.sendKeys(ConfigReader.getProperty("wisequarter@gmail.com"));
        // autoPage.emailauto.click();


        //7. Verify success message 'You have been successfully subscribed!' is visible(basarıyla abone oldugunuzu dogrulayan basarı mesajının görunur oldugunu dogrulayn)
        Assert.assertTrue(autoPage.subscription.isDisplayed());
    }
}
