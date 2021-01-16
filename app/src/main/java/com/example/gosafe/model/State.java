package com.example.gosafe.model;

public class State {
    private String name;
    private String code;
    private int total;
    private int active;
    private int deaths;
    private int recovered;
    private String date;

    public State(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public State(String name, String code, int total, int active, int deaths, int recovered, String date) {
        this.name = name;
        this.code = code;
        this.total = total;
        this.active = active;
        this.deaths = deaths;
        this.recovered = recovered;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
