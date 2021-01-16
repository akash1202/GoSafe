package com.example.gosafe.model;

public class Hospital {
    private String link = "https://www.williamoslerhs.ca/patients-and-families/preparing-for-your-visit-or-stay/coronavirus-information-for-patients-families/assessment-centre-for-covid-19";
    private String phone = "1-800-361-5653";
    private String name = "William Osler Health System - Peel Memorial";
    private String postalCode = "L6W 2Z8";
    private String city = "Brampton";
    private String province="ON";
    private String street = "20 Lynch St";
    private double latitude = -79.75074123699994;
    private double longitude = 43.69046834900007;

    public Hospital() {
    }

    public Hospital(String link, String phone, String name, String postalCode, String city, String province, String street, double latitude, double longitude) {
        this.link = link;
        this.phone = phone;
        this.name = name;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.street = street;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
