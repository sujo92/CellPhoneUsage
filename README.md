## CellPhoneUsage

Problem Statement: ("https://github.com/WCF-Insurance/java-developer-cell-phone-usage#cell-phone-usage-report")


### Main Components:
 **ReadCSV Class**
- Reads the input files
- It has two methods to read data from two different files
	- getCellPhoneDetails
	- getCellPhoneUsageDetails

 **App Class** 
- This is starting point of app.
- It prompts user to enter the year for fetching usage report of that year.


### Assumptions:

- In problem statement its mentioned that there may be more than one record for an employee on a single date, I assumed that second entry should be ignored in case of duplication

- As there are multiple records for different days of same month, I have added this data to populate monthly data consumption.

- As I was not sure what Average Data field means I have divided total Data for given year with number of employees using cellphone to get average consumption by each employee  for given year. (same applies for Average Minutes)


### Design choices:

- created object model of CellPhoneUsageByMonth and CellPhone to read data in List of these objects.

- To efficiently access data I created hashmap with employee id as key and list of CellPhoneUsageByMonth for user provided year as value.

- Later for each cellphone user I got the usage data list from hashmap and populated data usage for each month.