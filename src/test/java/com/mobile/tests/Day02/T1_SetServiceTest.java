package com.mobile.tests.Day02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class T1_SetServiceTest {

    AppiumDriver<MobileElement> driver;
    AppiumDriverLocalService service;

    @Test
    public void test1() throws InterruptedException{

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
//                .usingPort(1111)
                .usingAnyFreePort()
                .build();

        service.clearOutPutStreams();//not to write appium log --> appium logları düşmez.
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:udid", "B1673511013");
        capabilities.setCapability("appium:version", "8");
        capabilities.setCapability("appium:deviceName", "GM8 go");
//           capabilities.setCapability("appium:realDevice", "false");
        capabilities.setCapability("platformName", "Android");


        capabilities.setCapability("appPackage","com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver=new AndroidDriver<>(service.getUrl(),capabilities);

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
