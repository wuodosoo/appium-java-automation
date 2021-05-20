import io.appium.java_client.MobileBy;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class create_new_supplier {

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
    public void test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 70);

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


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement supplier = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'Suppliers')]")));
        supplier.click();

        WebElement add_supplier = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Add Supplier')]"));
        add_supplier.click();

        WebElement enter_fname = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtFname"));
        enter_fname.sendKeys("appium");

        WebElement enter_lname = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtLname"));
        enter_lname.sendKeys("test");

        WebElement enter_phoneNumber = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtPhoneNumber"));
        enter_phoneNumber.sendKeys("070007760600998");

        WebElement product_spinner = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Select Products')]"));
        product_spinner.click();

        WebElement enter_product = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/alertSearchEditText"));
        enter_product.sendKeys("Bananas");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement click_check_box = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Bananas')]"));
        click_check_box.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement click_ok = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"));
        click_ok.click();

        WebElement confirm_supplier = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnConfirmSupplier"));
        confirm_supplier.click();

        WebElement confirm_creation = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnConfirm"));
        confirm_creation.click();

        WebElement view_supplier = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnViewSuppliers"));
        view_supplier.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement add_farm_button = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnAddFarm"));
        add_farm_button.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement add_farm_type = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtTypeFarmerDropDown"));
        add_farm_type.click();

        WebElement select_farm_type = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextFarmName")));
        select_farm_type.click();

        WebElement farm_name = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextFarmName"));
        farm_name.sendKeys("A1");


        WebElement farm_size = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/editTextFarmSize"));
        farm_size.sendKeys("100");

        WebElement collection_centre_clear = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtCollectionCenterDropDown"));
        collection_centre_clear.clear();

        WebElement collection_centre = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtCollectionCenterDropDown"));
         collection_centre.sendKeys("Pack House");

        List<WebElement> items = driver.findElements(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtCollectionCenterDropDown"));
        items.get(0).click();

        driver.hideKeyboard();

        WebElement harvest_area_clear = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtHarvestArea"));
        harvest_area_clear.clear();

         WebElement harvest_area_click = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtHarvestArea"));
         harvest_area_click.click();

        List<WebElement> itemss = driver.findElements(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtHarvestArea"));
        itemss.get(0).click();

        driver.hideKeyboard();


       WebElement select_harvest_area = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup"));
       select_harvest_area.click();

        driver.hideKeyboard();

        WebElement take_location = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/textViewTakeLocation"));
        take_location.click();

        WebElement select_location = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/imageViewLocation"));
        select_location.click();

        WebElement save_location = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnSave"));
        save_location.click();

        WebElement save_farm = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnSaveFarm"));
        save_farm.click();

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        WebElement confirm_save_Farm = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnConfirm"));
        confirm_save_Farm.click();

        WebElement view_save_Farm = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnViewSuppliers"));
        view_save_Farm.click();




        WebElement add_booking = driver.findElement(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Bookings\"]/android.widget.TextView"));
        add_booking.click();


        WebElement add_new_bookings = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Add Bookings']"));
        add_new_bookings.click();

        WebElement add_bookings_button = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/btnAddBooking"));
        add_bookings_button.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement click_add_product = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductsDropDown"));
        click_add_product.clear();

        WebElement add_product = driver.findElement(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductsDropDown"));
        add_product.sendKeys("Afia Mango");

        WebElement add_product_n = driver.findElement(MobileBy.id("//android.widget.TextView[@text='Afia Mango']\""));
        add_product_n.click();

       // List<WebElement> items1 = driver.findElements(MobileBy.id("com.twigafoods.soko.staging.sourcing:id/edtProductItemsDropDown"));
       // items1.get(0).click();

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
