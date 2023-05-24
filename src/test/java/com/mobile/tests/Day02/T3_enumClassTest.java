package com.mobile.tests.Day02;

import com.mobile.tests.utils.App;
import com.mobile.tests.utils.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class T3_enumClassTest {

    AppiumDriver<MobileElement> driver;
    AppiumDriverLocalService service;
    Device device = Device.PIXEL2;
    App app = App.CALCULATOR;

    @Test
    public void test1() throws InterruptedException {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();

        service.clearOutPutStreams();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("platformName", device.platformName);

        capabilities.setCapability("appPackage", app.appPackage);
        capabilities.setCapability("appActivity", app.appActivity);

        driver = new AndroidDriver<>(service.getUrl(), capabilities);

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // --> findelementle birlikte hareket ediyordu.

        MobileElement digit2=driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        digit2.click();
        MobileElement plusBtn=driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        plusBtn.click();
        MobileElement digit3=driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        digit3.click();
        MobileElement equalBtn=driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equalBtn.click();

        MobileElement result=driver.findElement(By.id("com.google.android.calculator:id/result_final"));

        String actualResult=result.getText();
        String expectedResult="5";
        Assert.assertEquals(expectedResult,actualResult);

        Thread.sleep(2000);
        driver.closeApp();
        service.stop();
    }

}
