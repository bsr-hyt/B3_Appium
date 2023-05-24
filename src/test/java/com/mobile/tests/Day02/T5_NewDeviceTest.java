package com.mobile.tests.Day02;

import com.mobile.tests.utils.App;
import com.mobile.tests.utils.Device;
import com.mobile.tests.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class T5_NewDeviceTest {

    AppiumDriver<MobileElement> driver;

    By ldigit2=By.id("com.google.android.calculator:id/digit_2");
    By lplusBtn=By.id("com.google.android.calculator:id/op_add");
    By ldigit3=By.id("com.google.android.calculator:id/digit_3");
    By lequalBtn=By.id("com.google.android.calculator:id/eq");
    By lresult=By.id("com.google.android.calculator:id/result_final");

    @Before
    public void beforeTest(){
        Driver.runAppium();
        driver=Driver.getDriver(Device.PIXEL_2_v1, App.CALCULATOR);
    }

    @After
    public void afterTest(){
        driver.quit();
        Driver.stopAppium();
    }


    @Test
    public void test1(){
//        Driver.runAppium();
//        driver=Driver.getDriver(Device.PIXEL_2_v1, App.CALCULATOR);

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

//        Driver.stopAppium();
    }

    @Test
    public void test2(){
        click(ldigit2);
        click(lplusBtn);
        click(ldigit3);
        click(lequalBtn);
        Assert.assertEquals("5",getText(lresult));

    }

    void click(By locator){
        Driver.getDriver().findElement(locator).click();
    }

    String getText(By locator){
        return Driver.getDriver().findElement(locator).getText();
    }
}
