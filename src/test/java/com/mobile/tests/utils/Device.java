package com.mobile.tests.utils;

public enum Device {

    PIXEL2("B1673511013",
            "8",
            "GM8 go",
            "Android"),

    PIXEL_2_v1("B1673511013",
                   "8",
                   "GM8 go",
                   "Android");

    public String udid;
    public String version;
    public String deviceName;
    public String platformName;


    Device(String udid, String version, String deviceName, String platformName) {
        this.udid = udid;
        this.version = version;
        this.deviceName = deviceName;
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return this.name();
    }


}
