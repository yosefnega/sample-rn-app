package com.yosef;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CreateDriverSession {


    public static AppiumDriver<MobileElement> init(String platform) throws Exception {

        AppiumDriver<MobileElement> driver = null;

        DesiredCapabilities caps=  new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.APP,  "/Users/yosefnega/Desktop/dev/android/app-debug.apk");
        URL url  = new URL("http://127.0.0.1:4723/wd/hub");
        switch (platform){
            case "Android":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel4");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                driver = new AndroidDriver<>(url, caps);
                break;
            case "Ios":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Ios");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XUITest");
                driver = new IOSDriver<>(url, caps);
                break;
            default:
                throw new Exception("unknown platform: "+ platform);
        }

        return driver;
    }

    public static void main(String[] args) throws Exception {
        AppiumDriver<MobileElement> driver = CreateDriverSession.init("Android");
        MobileElement elem = driver.findElementsByClassName("android.widget.TextView").get(1);
        System.out.println(elem.getText());
        elem.click();
    }
}
