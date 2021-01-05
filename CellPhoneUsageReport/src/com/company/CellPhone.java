package com.company;


import java.time.LocalDate;

public class CellPhone {
    private String employeeId;
    private String employeeName;
    private LocalDate purchaseDate;
    private String model;

    public CellPhone(String employeeId, String employeeName, LocalDate purchaseDate, String model) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.purchaseDate = purchaseDate;
        this.model = model;
    }

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

    @Override
    public String toString() {
        return "CellPhone{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", model='" + model + '\'' +
                '}';
    }
}
