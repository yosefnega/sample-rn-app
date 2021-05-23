package tests;

import com.microsoft.appcenter.appium.Factory;
import global.DriverManager;
import global.Platform;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SampleTest {

    private static Logger logger = LoggerFactory.getLogger(SampleTest.class);
    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    private AppiumDriver<WebElement> driver;


    @Before
    public void init(){
        this.driver = DriverManager.init(Platform.fromString("Android"));
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        System.out.println("test started");

        WebElement num_1 = this.driver.findElementByXPath("//*[@text=\"1\"]");
        WebElement num_2 = this.driver.findElementByXPath("//*[@text=\"2\"]");
        WebElement plus = this.driver.findElementByXPath("//*[@text=\"+\"]");
        WebElement equal = this.driver.findElementByXPath("//*[@text=\"=\"]");

        num_1.click();
        plus.click();
        num_2.click();
        equal.click();

        WebElement result = this.driver.findElementsByClassName("android.widget.TextView").get(0);
        System.out.println(result.getText());

    }


    @After
    public void clean() {
        this.driver.quit();
        this.driver = null;
        System.out.println("cleanup");

    }
}
