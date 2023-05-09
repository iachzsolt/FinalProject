package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Instant;

public class nopCommerceTest {
    private WebDriver driver;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void websiteTest() throws InterruptedException {

        //Changing currency
        WebElement selectCurrency = driver.findElement(By.id("customerCurrency"));
        selectCurrency.click();

        WebElement euroCurrency = driver.findElement(By.xpath("//option[text()='Euro']"));
        euroCurrency.click();

        //Selecting 2 products to compare

        Thread.sleep(1000);
        WebElement computers = driver.findElement(By.xpath("//a[text() = 'Computers ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(computers).build().perform();

        WebElement notebooks = driver.findElement(By.xpath("//a[text()='Notebooks ']"));
        notebooks.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        WebElement addFirstProductToCompareList = driver.findElement(By.cssSelector(".item-box>.product-item>.details>.add-info>.buttons>.add-to-compare-list-button"));
        addFirstProductToCompareList.click();

        Thread.sleep(1000);
        WebElement addSecondProductToCompareList = driver.findElement(By.cssSelector(".item-box:nth-child(4)>.product-item>.details>.add-info>.buttons>.add-to-compare-list-button"));
        addSecondProductToCompareList.click();

        Thread.sleep(1000);
        WebElement viewTheCompareList = driver.findElement(By.xpath("//a[text()='product comparison']"));
        viewTheCompareList.click();

        //Removing a product from the compare list

        WebElement removeSecondProduct = driver.findElement(By.cssSelector("td:nth-child(3)>button"));
        removeSecondProduct.click();

        //Selecting another product

        Thread.sleep(1000);
        WebElement clickOnComputers = driver.findElement(By.xpath("//a[text()='Computers ']"));
        clickOnComputers.click();

        WebElement clickOnNotebookPicture = driver.findElement(By.cssSelector(".item-box:nth-child(2)>.sub-category-item>.picture"));
        clickOnNotebookPicture.click();

        Thread.sleep(1000);
        WebElement addThirdProductToCompareList = driver.findElement(By.cssSelector(".item-box:nth-child(2)>.product-item>.details>.add-info>.buttons>.add-to-compare-list-button"));
        addThirdProductToCompareList.click();

        Thread.sleep(1000);
        WebElement viewTheCompareListAgain = driver.findElement(By.xpath("//a[text()='product comparison']"));
        viewTheCompareListAgain.click();

        //Remove a product again

        WebElement removeFirstProduct = driver.findElement(By.cssSelector("td:nth-child(2)>button"));
        removeFirstProduct.click();

        //Adding a product to cart

        Thread.sleep(1000);
        WebElement openLastProduct = driver.findElement(By.xpath(".//tbody/tr[3]/td[2]/a"));
        openLastProduct.click();

        Thread.sleep(1000);
        WebElement addToCartBtn = driver.findElement(By.className("add-to-cart-button"));
        addToCartBtn.click();

        Thread.sleep(1000);
        WebElement viewShoppingCart = driver.findElement(By.xpath("//a[text()='shopping cart']"));
        viewShoppingCart.click();

        //Update product quantity

        WebElement productQuantity = driver.findElement(By.xpath(".//tbody/tr/td[5]/input"));
        productQuantity.clear();
        Thread.sleep(1000);
        String newQuantity = "2";
        productQuantity.sendKeys(newQuantity);

        WebElement updateShoppingCartBtn = driver.findElement(By.id("updatecart"));
        updateShoppingCartBtn.click();

        //Checkout

        Thread.sleep(1000);
        WebElement termOfServiceCheckbox = driver.findElement(By.id("termsofservice"));
        termOfServiceCheckbox.click();

        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();

        WebElement checkoutAsGuestBtn = driver.findElement(By.cssSelector(".checkout-as-guest-button"));
        checkoutAsGuestBtn.click();

        WebElement firstName = driver.findElement(By.id("BillingNewAddress_FirstName"));
        firstName.sendKeys("Test");

        WebElement lastName = driver.findElement(By.id("BillingNewAddress_LastName"));
        lastName.sendKeys("Test");

        WebElement email = driver.findElement(By.id("BillingNewAddress_Email"));
        email.sendKeys("test@test.com");

        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("Romania");

        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("Test");

        WebElement address = driver.findElement(By.id("BillingNewAddress_Address1"));
        address.sendKeys("Test 34");

        WebElement postalCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        postalCode.sendKeys("0000");

        WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phoneNumber.sendKeys("000000000000");

        WebElement shippingFormsContinueBtn = driver.findElement(By.className("new-address-next-step-button"));
        shippingFormsContinueBtn.click();

        //Select shipping method

        Thread.sleep(1000);
        WebElement shippingOption = driver.findElement(By.id("shippingoption_1"));
        shippingOption.click();

        WebElement shippingOptionContinueBtn = driver.findElement(By.className("shipping-method-next-step-button"));
        shippingOptionContinueBtn.click();

        //Select payment method

        Thread.sleep(1000);
        WebElement creditCardOption = driver.findElement(By.id("paymentmethod_1"));
        creditCardOption.click();

        WebElement paymentMethodContinueBtn = driver.findElement(By.className("payment-method-next-step-button"));
        paymentMethodContinueBtn.click();

        //Payment information

        Thread.sleep(1000);
        WebElement selectCreditCard = driver.findElement(By.id("CreditCardType"));
        Select selectNewCreditCard= new Select(selectCreditCard);
        selectNewCreditCard.selectByVisibleText("Master card");

        WebElement cardholderName = driver.findElement(By.id("CardholderName"));
        cardholderName.sendKeys("Test Name");

        WebElement cardNumber = driver.findElement(By.id("CardNumber"));
        cardNumber.sendKeys("0000 0000 0000 0000");

        WebElement selectExpirationMonth = driver.findElement(By.id("ExpireMonth"));
        Select selectMonth = new Select(selectExpirationMonth);
        selectMonth.selectByVisibleText("03");

        WebElement selectExpirationYear = driver.findElement(By.id("ExpireYear"));
        Select selectYear = new Select(selectExpirationYear);
        selectYear.selectByVisibleText("2026");

        WebElement cardCode = driver.findElement(By.id("CardCode"));
        cardCode.sendKeys("000");

        WebElement paymentInformationBtn = driver.findElement(By.className("payment-info-next-step-button"));
        paymentInformationBtn.click();

        //Confirming the order
        Thread.sleep(1000);
        WebElement confirmOrder = driver.findElement(By.className("confirm-order-next-step-button"));
        confirmOrder.click();

        Thread.sleep(1000);
        String expectedText = "Your order has been successfully processed!";
        WebElement text = driver.findElement(By.cssSelector(".title>strong"));
        String actualText = text.getText();
        if (actualText.contains(expectedText)) {
            System.out.println("The test passed successfully!");
        } else {
            System.out.println("The test failed!");
        }

      }
      @AfterClass
      public void end(){
        driver.quit();
      }

}
