package com.company;

public class ReportHeader {
    private int numPhones;
    private int totalMinutes;
    private double totalData;
    private int avgMinutes;
    private double avgData;

    public int getNumPhones() {
        return numPhones;
    }

    public void setNumPhones(int numPhones) {
        this.numPhones = numPhones;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public double getTotalData() {
        return totalData;
    }

    public void setTotalData(double totalData) {
        this.totalData = totalData;
    }

    public int getAvgMinutes() {
        return avgMinutes;
    }

    public void setAvgMinutes(int avgMinutes) {
        this.avgMinutes = avgMinutes;
    }

    public double getAvgData() {
        return avgData;
    }

    public void setAvgData(double avgData) {
        this.avgData = avgData;
    }
}
