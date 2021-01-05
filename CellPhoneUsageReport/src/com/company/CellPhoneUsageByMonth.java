package com.company;

import java.time.LocalDate;

public class CellPhoneUsageByMonth {
    private String employeeId;
    private LocalDate date;
    private int minutesUsed;
    private double dataUsed;

    public CellPhoneUsageByMonth(String employeeId,LocalDate date, int minutesUsed, double dataUsed) {
        this.employeeId = employeeId;
        this.date=date;
        this.minutesUsed = minutesUsed;
        this.dataUsed = dataUsed;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMinutesUsed() {
        return minutesUsed;
    }

    public void setMinutesUsed(int minutesUsed) {
        this.minutesUsed = minutesUsed;
    }

    public double getDataUsed() {
        return dataUsed;
    }

    public void setDataUsed(double dataUsed) {
        this.dataUsed = dataUsed;
    }

    @Override
    public String toString() {
        return "CellPhoneUsageByMonth{" +
                "employeeId='" + employeeId + '\'' +
                ", date=" + date +
                ", minutesUsed=" + minutesUsed +
                ", dataUsed=" + dataUsed +
                '}';
    }
}
