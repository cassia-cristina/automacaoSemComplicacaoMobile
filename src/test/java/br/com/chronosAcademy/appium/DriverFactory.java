package br.com.chronosAcademy.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class DriverFactory {
    private DesiredCapabilities capabilities;
    private AppiumDriver<MobileElement> driver;

    public void setDriver() throws MalformedURLException {
        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public AppiumDriver<MobileElement> getDriver(){
        return driver;
    }

    public void setCapabilities(Map<String, String> map){
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, map.get("platform"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, map.get("device"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, map.get("automation"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, map.get("appPackage"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, map.get("appActivity"));
    }

}
