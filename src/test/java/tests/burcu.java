package tests;

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
}