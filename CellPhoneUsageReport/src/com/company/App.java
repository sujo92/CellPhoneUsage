package com.company;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class App {
    public static List<CellPhone> cellPhoneList;
    public static List<CellPhoneUsageByMonth> cellPhoneUsageList;
    public static Map<String,List<CellPhoneUsageByMonth>> map;
    public static List<UserDetails> userDetails;
    public static ReportHeader reportHeader;
    public static int totalMinutes;
    public static double totalData;

    public static void main(String[] args) throws IOException {
        ReadCSV readCSV  = new ReadCSV();
        cellPhoneList = readCSV.getCellPhoneDetails("/Users/sujatapatil/Desktop/CellPhone.csv");
        cellPhoneUsageList = readCSV.getCellPhoneUsageDetails("/Users/sujatapatil/Desktop/CellPhoneUsageByMonth.csv");

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the year to get report");
        int userYear = Integer.parseInt(in.nextLine());

        //create map for each employee and his usage entry for user provided year
        map=  new HashMap<>();
        cellPhoneUsageList.stream()
                .filter(e -> e.getDate().getYear()==userYear)
                .forEach(a->{
                    if(! map.containsKey(a.getEmployeeId())){
                        map.put(a.getEmployeeId(),new ArrayList<>());
                    }
                    List<CellPhoneUsageByMonth> list = map.get(a.getEmployeeId());
                    list.add(a);

                });

        createReport(userYear);
        printHeader();
        printDetailsNew();
    }

    /**
     * print report header
     */
    private static void printHeader() {
        System.out.println("================================================================");
        System.out.println("Report Run Date: "+LocalDate.now());
        System.out.println("Number of Phones: "+reportHeader.getNumPhones());
        System.out.println("Total Minutes: "+reportHeader.getTotalMinutes());
        System.out.println("Total Data: "+reportHeader.getTotalData());
        System.out.println("Average Minutes: "+reportHeader.getAvgMinutes());
        System.out.println("Average Data: "+reportHeader.getAvgData());
        System.out.println("================================================================");

    }

    /**
     * print report details
     */
    private static void printDetailsNew() {
        userDetails.forEach(emp-> {
                    System.out.println("Employee Id:" +emp.getEmployeeId());
                    System.out.println("Employee Name:" + emp.getEmployeeName());
                    System.out.println("Model:" + emp.getModel());
                    System.out.println("Purchase Date:" + emp.getPurchaseDate());
                    System.out.println("Minutes Usage:");
                    int[] monthlyMinutes = emp.getMinutesUsage();
                    double[] monthlyData = emp.getDataUsage();
                    for(int i=0; i<monthlyMinutes.length; i++){
                        String monthString = new DateFormatSymbols().getMonths()[i];
                        System.out.print(monthString+": ");
                        System.out.print(monthlyMinutes[i]+"\t");
                    }

                    System.out.println();
                    System.out.println("Data Usage:");
                    DecimalFormat df = new DecimalFormat("#.##");
                    for(int i=0; i<monthlyData.length; i++){
                        String monthString = new DateFormatSymbols().getMonths()[i];
                        System.out.print(monthString+": ");
                        System.out.print(df.format(monthlyData[i])+"\t");
                    }
                    System.out.println();
                    System.out.println("------------------------------------------------------------------------");
                }
        );
    }

    /**
     * goes through all employees having cell phone and creates monthly distribution of usage per month for given year
     * @param userYear user provided year
     */
    private static void createReport(int userYear) {
        userDetails = new LinkedList<>();
        cellPhoneList.stream().forEach(emp -> //go through all emp having cell phone
        {
            UserDetails ud = new UserDetails();
            ud.setEmployeeId(emp.getEmployeeId());
            ud.setEmployeeName(emp.getEmployeeName());
            ud.setModel(emp.getModel());
            ud.setPurchaseDate(emp.getPurchaseDate());

            List<CellPhoneUsageByMonth> currEmpRec = map.get(emp.getEmployeeId()); //get usage data for current employee

            int[] monthlyMinutes = new int[12];
            double[] monthlyData = new double[12];
            Set<LocalDate> seen = new HashSet<>();
            currEmpRec.stream().forEach(empMonthData->{  //go through usage data and add all entry for same month
                        LocalDate date = empMonthData.getDate();
                        if(! seen.contains(date)) {
                            seen.add(date);
                            int month = date.getMonthValue();
                            totalMinutes += empMonthData.getMinutesUsed();
                            totalData += empMonthData.getDataUsed();
                            monthlyMinutes[month - 1] += empMonthData.getMinutesUsed();
                            monthlyData[month - 1] += empMonthData.getDataUsed();
                        }
                    });
            ud.setMinutesUsage(monthlyMinutes);
            ud.setDataUsage(monthlyData);
            userDetails.add(ud);
        });

        reportHeader = new ReportHeader();
        reportHeader.setNumPhones(cellPhoneList.size());
        reportHeader.setTotalMinutes(totalMinutes);
        reportHeader.setTotalData(totalData);
        reportHeader.setAvgMinutes(totalMinutes/cellPhoneList.size());
        reportHeader.setAvgData(totalData/cellPhoneList.size());
    }
}
