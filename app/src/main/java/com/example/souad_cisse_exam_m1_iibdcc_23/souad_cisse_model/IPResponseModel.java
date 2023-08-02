package com.example.souad_cisse_exam_m1_iibdcc_23.souad_cisse_model;

import com.google.gson.annotations.Expose;


public class IPResponseModel {
    @Expose
    private String ip;
    @Expose
    private String city;
    @Expose
    private String region;
    @Expose
    private String country;
    @Expose
    private String loc;
    @Expose
    private String org;
    @Expose
    private String timezone;
    @Expose
    private String readme;

    // Getter Methods

    public String getIp() {
        return ip;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getLoc() {
        return loc;
    }

    public String getOrg() {
        return org;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getReadme() {
        return readme;
    }

    // Setter Methods

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }
}

