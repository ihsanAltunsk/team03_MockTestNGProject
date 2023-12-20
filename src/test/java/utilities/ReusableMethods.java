package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static utilities.Driver.driver;

public class ReusableMethods {
    public static List<String> stringlisteDönüştür(List<WebElement> elementlerListesi) {
        List<String> stringlerListesi = new ArrayList<>();
        for (WebElement each : elementlerListesi) {
            stringlerListesi.add(each.getText());
        }
        return stringlerListesi;
    }

    public static void bekle(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static WebDriver titleİleSayfaDeğiştir(String hedefSayfaTitle) {

        Set<String> tümWhdSeti = driver.getWindowHandles();
        for (String each : tümWhdSeti
        ) {
            String eachTitle = driver.switchTo().window(each).getTitle();
            if (eachTitle.equals(hedefSayfaTitle)) {
                return driver;
            }
        }
        return driver;
    }

    public static String ilkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWhd) {

        Set<String> tumWhdSeti = driver.getWindowHandles();
        tumWhdSeti.remove(ilkSayfaWhd);
        for (String each : tumWhdSeti
        ) {
            return each;
        }
        return null;
    }

    public static void tumSayfaTakeScreenshot(WebDriver driver) {

        TakesScreenshot tss = (TakesScreenshot) driver;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/tumSayfaScreenshot" +
                localDateTime.format(istenenFormat) +
                ".jpg";
        File tumSayfaScreenshot = new File(dinamikDosyaYolu);
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.bekle(5);
    }

    public static void tumSayfaTakeScreenshot(String testAdi, WebDriver driver) {

        TakesScreenshot tss = (TakesScreenshot) driver;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/" +
                testAdi
                +
                localDateTime.format(istenenFormat) +
                ".jpg";
        File tumSayfaScreenshot = new File(dinamikDosyaYolu);
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.bekle(5);
    }

    public static void istenenWebelementScreenshot(WebElement istenenWebelement) {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/istenenWebelementScreenshot" +
                localDateTime.format(istenenFormat) +
                ".jpg";
        File istenenWebelementScreenshot = new File(dinamikDosyaYolu);
        File geciciDosya = istenenWebelement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya, istenenWebelementScreenshot);
        } catch (IOException e) {
            System.out.println("Screenshot kopyalanamadi");
            throw new RuntimeException(e);
        }
    }

    public static String getScreenshot(String name) throws IOException {

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}