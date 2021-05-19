package global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

import java.net.MalformedURLException;
import java.net.URL;

public class AppManager {


    public static AppiumDriver init (String platform) {

        AppiumDriver<MobileElement> driver = null;

        DesiredCapabilities caps=  new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.APP,  "/Users/yosefnega/Desktop/dev/android/app-debug.apk");
        URL url  = null;

        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        }catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage());
        }
        switch (platform){
            case "android":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                driver = Factory.createAndroidDriver(url, caps);
                break;
            case "ios":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                driver = Factory.createIOSDriver(url, caps);
                break;
            default:
                throw new RuntimeException("unknown platform: "+ platform);
        }

        return driver;
    }
}
