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


    public static AppiumDriver init(Platform platform) {

        if (platform == null) {
            throw new IllegalArgumentException("platform cannot be null");
        }

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.APP, "/Users/yosefnega/Desktop/dev/android/app-release.apk");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platform.getType());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, platform.getAutomator());

        URL url = null;

        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage());
        }
        switch (platform) {
            case ANDROID:
                return Factory.createAndroidDriver(url, caps);
            case IOS:
                return Factory.createIOSDriver(url, caps);
            default:
                throw new RuntimeException("unknown platform: " + platform);
        }
    }

}
