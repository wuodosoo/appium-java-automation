import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Incorrect_Login_Validation {

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

        WebElement password = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/edtPassword"));
        password.sendKeys("0000");

        WebElement login = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/btnLogin"));
        login.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Login: Failed')]")));

        String errorMessage = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Login: Failed')]")).getText();

        Assert.assertEquals(errorMessage,"Login: Failed");


    }
}