package com.mobile.tests.Day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Day01 {

    AppiumDriver<MobileElement> driver;
//    AppiumDriver driver; --> version 8 de bu şekilde tanımlıyoruz. Biz şu anda 7 yi kullanıyoruz.

    @Test
    public void test1() throws InterruptedException, MalformedURLException {
       /**
        //obje oluşturduk
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //which platform? --> hangi platformda test yapacağımız belirtmemiz gerekiyor; anroid mi ios mu?
        //1 way
//        desiredCapabilities.setCapability("platformName","Android");
        //2 way
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

        // which version? --> hangi versiyounu kullanacağımızı belirtiyoruz. -> Android Studyo da SDK platfroms da aslında versiyonu seçtik.
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"8");

        //device name?
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixcel_2");
*/
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:udid", "B1673511013");
        capabilities.setCapability("appium:version", "8");
        capabilities.setCapability("appium:deviceName", "GM8 go");
        //   capabilities.setCapability("appium:realDevice", "false");
        capabilities.setCapability("platformName", "Android");


        //set Application's package name
        //terminale yaz. --> dumpsys window | grep -E mCurrentFocus
        capabilities.setCapability("appPackage","com.google.android.calculator");

        //set Application's activity name
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver=new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
//        driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        //locate element
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
    }
}
