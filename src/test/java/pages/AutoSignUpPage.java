package pages;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutoSignUpPage {

    public AutoSignUpPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath =  "//*[text()='New User Signup!']")
    public WebElement newusersiguptext;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement nametextbox;

    @FindBy(xpath = "(//input[@type='email'])[2]")
    public WebElement emailtextbox;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement signupbutton;

    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    public WebElement informationstext;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement titlecheckboxmr;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newslettercheckbox;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement partnerscheckbox;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement acccreatedtext;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement countinuebutton;
}