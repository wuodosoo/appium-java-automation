import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
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

public class logout {

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


        WebElement menu_tab = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/m_menu"));
        menu_tab.click();

        WebElement log_out = driver.findElement(MobileBy.id("com.twigafoods.soko.staging:id/tvLogout"));
        log_out.click();

        WebElement yes_log_out = driver.findElement(MobileBy.id("android:id/button1"));
        yes_log_out.click();


    }
}
