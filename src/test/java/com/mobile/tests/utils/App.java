package com.mobile.tests.utils;

public enum App {

    CALCULATOR("com.google.android.calculator", "com.android.calculator2.Calculator","Calculator.apk");

    public String appPackage;
    public String appActivity;
    public String apk;

    App(String appPackage, String appActivity,String apk) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.apk=apk;
    }


}
