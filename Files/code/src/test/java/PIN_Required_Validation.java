import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIN_Required_Validation {

    private static final String APP = "/Users/Gordon/Downloads/Twiga DMS v3.11.0-210317_0912(STAGING).apk";
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("app", APP);
        driver = new AndroidDriver(new URL(APPIUM), caps);
        try { Thread.sleep(3000); } catch (Exception ign) {}
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.twigafoods.soko.staging:id/edtPhoneNumber")));
        username.sendKeys("0793256440");

        driver.hideKeyboard();

        WebElement login = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/btnLogin"));
        login.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'PIN is required')]")));

        String errorMessage = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'PIN is required')]")).getText();

        Assert.assertEquals(errorMessage,"PIN is required");


    }
}

// WebElement add_new_booking = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("com.twigafoods.soko.staging.sourcing:id/btnAddBooking")));
//  add_new_booking.click();



//   WebElement add_new_booking = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Add Booking"));
//   add_new_booking.click();

// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
/*
        WebElement product_type_banana = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductsDropDown"));
        product_type_banana.sendKeys("bananas");

     //   WebElement product_type_banana_click = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductItemsDropDown"));
     //   product_type_banana_click.click();

        WebElement product_item_type_banana = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductItemsDropDown"));
        product_item_type_banana.sendKeys("4 for 20 (71-80 pcs)");

      //  WebElement product_item_type_banana_click = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/layoutUnitQuantity"));
      //  product_item_type_banana_click.click();

     //   WebElement edit_quantity_clear = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextQuantity"));
     //   edit_quantity_clear.clear();

        WebElement edit_quantity = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextQuantity"));
        edit_quantity.sendKeys("100");

        WebElement unit_price = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextUnitPrice"));
        unit_price.sendKeys("10");

        WebElement date_today = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextDate"));
        date_today.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebElement date_ok_button = driver.findElement(MobileBy.id("android:id/button1"));
        date_ok_button.click();

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        WebElement add_button = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnAdd"));
        add_button.click();

       /*

        WebElement item_count_button = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnItemCount"));
        item_count_button.click();

        WebElement confirm_booking_button = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnConfirmBooking"));
        confirm_booking_button.click();

        WebElement collection_centre = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtCollectionCenterDropDown"));
        collection_centre.sendKeys("Pack House");

        WebElement harvest_area = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtHarvestArea"));
        harvest_area.sendKeys("Baba Dogo");

        WebElement farm = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtFarm"));
        farm.sendKeys("A1");


        WebElement shutter_button = driver.findElement(MobileBy.id("com.android.camera2:id/shutter_button"));
        shutter_button.click();

       WebElement menu_tab = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Menu')]"));
        menu_tab.click();

        WebElement log_out = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/tvLogout"));
        log_out.click();

        WebElement yes_log_out = driver.findElement(MobileBy.id("android:id/button1"));
        yes_log_out.click();

    */
//  WebElement home_tab = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/m_home"));
//  home_tab.click();