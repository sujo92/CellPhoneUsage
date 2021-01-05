package com.company;

import java.time.LocalDate;

public class UserDetails {
    private String employeeId;
    private String employeeName;
    private LocalDate purchaseDate;
    private String model;
    private int[] minutesUsage;
    private double[] dataUsage;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int[] getMinutesUsage() {
        return minutesUsage;
    }

    public void setMinutesUsage(int[] minutesUsage) {
        this.minutesUsage = minutesUsage;
    }

    public double[] getDataUsage() {
        return dataUsage;
    }

    public void setDataUsage(double[] dataUsage) {
        this.dataUsage = dataUsage;
    }
}
