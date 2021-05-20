import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.NoHttpResponseException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Test {

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
        caps.setCapability("noReset", "true");
        caps.setCapability("app Activity","com.twigafoods.soko.ui.common.auth.LoginActivity");
        caps.setCapability("app Activity","com.twigafoods.soko.ui.common.auth.LoginActivity");
        caps.setCapability("app Activity","com.twigafoods.soko.ui.common.ui.MainDashboardActivity");
        caps.setCapability("app Package", "com.twigafoods.soko.staging");
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
        WebDriverWait wait = new WebDriverWait(driver, 70);
/*

        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.twigafoods.soko.staging:id/edtPhoneNumber")));
        username.sendKeys("0793256440");

        WebElement password = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/edtPassword"));
        password.sendKeys("9612");

        WebElement login = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/btnLogin"));
        login.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Tech Operations')]")));

        String successLogin = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Tech Operations')]")).getText();

        Assert.assertEquals(successLogin,"Tech Operations");
   */
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement menu_tab = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/m_menu"));
        menu_tab.click();

        WebElement products_sync = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/btnProductsSync"));
        products_sync.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        WebElement supplier = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'Suppliers')]")));
        supplier.click();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebElement search_supplier = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/textInputEditTextSearch"));
        search_supplier.sendKeys("appium");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebElement supplierMoja = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'appium')]")));
        supplierMoja.click();

       // WebElement supplierMoja = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Gordon Osoo')]"));
       // supplierMoja.click();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement add_new_bookings = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Add Bookings']"));
        add_new_bookings.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement add_bookings_button = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnAddBooking"));
        add_bookings_button.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement click_add_product = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductsDropDown"));
        click_add_product.click();

         WebElement add_product = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductsDropDown"));
         add_product.sendKeys("Afia Mango");

       // WebElement add_product = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductsDropDown"));
       //add_product.click();

        List<WebElement> items1 = driver.findElements(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductItemsDropDown"));
        items1.get(0).click();

        driver.hideKeyboard();

        WebElement click_add_product_item = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductItemsDropDown"));
        click_add_product_item.click();

        WebElement add_product_item = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductItemsDropDown"));
        add_product_item.sendKeys("200ml x 12pcs");

        List<WebElement> itemss2 = driver.findElements(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductItemsDropDown"));
        itemss2.get(0).click();

        driver.hideKeyboard();

        WebElement add_quantity = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextQuantity"));
        add_quantity.sendKeys("100");

        WebElement add_unit_price = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextUnitPrice"));
        add_unit_price.sendKeys("100");

        //  WebElement click_date = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextDate"));
        // click_date.click();

        WebElement date_today = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextDate"));
        date_today.click();

        WebElement date_ok_button = driver.findElement(MobileBy.id("android:id/button1"));
        date_ok_button.click();


        //   accessibility id	31 May 2021
        //   xpath	//android.view.View[@content-desc="31 May 2021"]

        WebElement confirm_add_booking = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnAdd"));
        confirm_add_booking.click();

        WebElement item_count = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnItemCount"));
        item_count.click();

        WebElement confirm_new_booking = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnConfirmBooking"));
        confirm_new_booking.click();



    }
}
