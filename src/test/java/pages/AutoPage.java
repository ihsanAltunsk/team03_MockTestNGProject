package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutoPage {

    public AutoPage(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "(//div[@class= 'carousel-inner'])[1]")
    public WebElement homePageSlider;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signupLoginButton;

    @FindBy(xpath = "//*[text()='Login to your account']")
    public WebElement loginToYourAccount;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@data-qa='login-password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Your email or password is incorrect!']")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//*[text()='Category']")
    public WebElement categories;

    @FindBy(xpath = "(//i[@class='fa fa-plus'])[1]")
    public WebElement WomencategoryClick;

    @FindBy(xpath = "//*[@id='Women']/div/ul/li[1]/a")
    public WebElement dressClick;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement WomenDressProductsText;

    @FindBy(xpath = "(//span[@class='badge pull-right'])[2]")
    public WebElement catagoryMen;

    @FindBy(xpath = "//*[@id='Men']/div/ul/li[1]/a")
    public WebElement catagoryMenTsort;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement MenProductsText;

    @FindBy(xpath = "//*[h2='Login to your account']")
    public WebElement Logintoyouraccount;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement emailauto;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@type='submit'][1]")
    public WebElement autoLogin;

    @FindBy(xpath = "//li[10]")
    public WebElement Loggedinas;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteaccount;

    @FindBy (xpath = "//*[text()='New User Signup!']")
    public WebElement newUserYaziElementi;

    @FindBy (xpath = "//*[@data-qa='signup-name']")
    public WebElement nameButton;

    @FindBy (xpath = "//*[@data-qa='signup-email']")
    public WebElement emailButton;

    @FindBy (xpath = "//*[@data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy (xpath = "//*[text()='Email Address already exist!']")
    public WebElement hataMesaji;

    @FindBy(xpath = "//li[2]")
    public WebElement productsLinki;

    @FindBy(xpath = "(//img[@alt='ecommerce website products'])[2]")
    public WebElement urunResmi2;

    @FindBy(xpath = "//a[@data-product-id='2']")
    public WebElement addToCart2;

    @FindBy(xpath = "//*[text()='View Cart']")
    public WebElement viewCart;

    @FindBy(xpath = "//*[text()='Blue Top']")
    public WebElement BlueTopInCart;

    @FindBy(xpath = "//*[text()='Men Tshirt']")
    public WebElement MenTshirtInCart;

    @FindBy(xpath = "(//*[@class='cart_total_price'])[1]")
    public WebElement totalprice1;

    @FindBy(xpath = "(//*[@class='cart_price'])[1]")
    public WebElement price1;

    @FindBy(xpath = "(//button[@class='disabled'])[1]")
    public WebElement quantity1;

    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[1]")
    public WebElement addToCart;

    @FindBy(xpath = "(//img[@alt='ecommerce website products'])[1]")
    public WebElement urunResmi;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShopping;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    public WebElement homepagelink;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement singupbutton;

    @FindBy(xpath = "//li[10]")
    public WebElement loggedtext;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    public  WebElement accdeleted;

    @FindBy(xpath = "//*[@href='/view_cart']")
    public  WebElement cartButton;

    @FindBy(xpath = "//*[@class='active']")
    public  WebElement cartVerify;

    @FindBy(xpath = "//*[text()='Proceed To Checkout']")
    public  WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[text()='Register / Login']")
    public  WebElement registerLoginButton;

    @FindBy(xpath = "//*[text()='Address Details']")
    public  WebElement adressDetailsVerify;

    @FindBy(xpath = "//*[text()='Review Your Order']")
    public  WebElement reviewYourOrderVerify;

    @FindBy(xpath = "//*[@class='form-control']")
    public  WebElement textArea;

}