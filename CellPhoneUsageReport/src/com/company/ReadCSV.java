package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class ReadCSV {
    public List<CellPhoneUsageByMonth> getCellPhoneUsageDetails(String file) {
        Path filePath = Paths.get(file);
        List<CellPhoneUsageByMonth> cellUsageList= new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String row = br.readLine();
            row = br.readLine();
            while(row != null){
                String[] attributes = row.split(",");
                CellPhoneUsageByMonth cp =getOneCellPhoneUsage(attributes);
                cellUsageList.add(cp);
                row = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellUsageList;
    }

    private CellPhoneUsageByMonth getOneCellPhoneUsage(String[] attributes) {
        String employeeId=attributes[0];
        String[] arr = attributes[1].split("/");
        LocalDate date= LocalDate.of(Integer.parseInt(arr[2]),Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
        int minutesUsed= Integer.parseInt(attributes[2]);;
        double dataUsed= Double.parseDouble(attributes[3]);;
        CellPhoneUsageByMonth cum = new CellPhoneUsageByMonth(employeeId,date,minutesUsed,dataUsed);
        return cum;
    }

    public List<CellPhone> getCellPhoneDetails(String file) {
        Path filePath = Paths.get(file);
        List<CellPhone> cellList= new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String row = br.readLine();
            row = br.readLine();
            while(row != null){
                String[] attributes = row.split(",");
                CellPhone cp =getOneCellPhone(attributes);
                cellList.add(cp);
                row = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellList;
    }

    private CellPhone getOneCellPhone(String[] attributes) {
        String employeeId = attributes[0];
        String employeeName = attributes[1];

        int year = Integer.parseInt(attributes[2].substring(0,4));
        int month = Integer.parseInt(attributes[2].substring(4,6));
        int day= Integer.parseInt(attributes[2].substring(6));
        LocalDate purchaseDate= LocalDate.of(year,month,day);

        String model= attributes[3];
        CellPhone cp = new CellPhone(employeeId,employeeName,purchaseDate,model);
        return cp;
    }

}
