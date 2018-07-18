package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

abstract public class GeneralClass {

    public static WebDriver driver = null;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");

        DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
        handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new ChromeDriver(handlSSLErr);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://slotmachinescript.com/");

    }

    @AfterTest
    public void driverClose() {
        //driver.close();
    }
}
