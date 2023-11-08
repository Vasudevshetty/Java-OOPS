/*Given that an EMPLOYEE class contains the following members:
Members: Employee ID, Employee Name, Department name & Basic Pay
Methods: To read each employee details, to calculate Gross Pay and to print 
the employee details. Develop an application to read data of N employees 
and compute the Gross Pay and Net Pay of each employee.
Gross Pay = Basic Pay + DA + HRA (DA = 58% of Basic Pay, HRA = 
16% of Basic Pay)
Net Pay = Gross – Income Tax
Income Tax calculated as follows:
Gross Pay - Up to 2 lakhs - Nil 
Above 2 and up to 3 lakhs - 10% of the Gross Pay
Above 3 and up to 5 lakhs - 15% of the Gross Pay and 
Above 5 lakhs 30 % of the Gross Pay, an additional charge of 2% of the tax 
will be added to total tax */

import java.util.Scanner;

class Employee{
    private int Id;
    private String name;
    private String deptName;
    private double basicPay;
    private double grossPay;
    private double incomeTax;
    private double netPay;

    // constrctor 
    public Employee(int Id, String name, String deptName, double basicPay){
        this.Id = Id;
        this.name = name;
        this.deptName = deptName;
        this.basicPay = basicPay;
    }

    // method to calculate gross pay.
    public void calculateGrossPay(){
        double DA = 0.58 * basicPay;
        double HRA = 0.16 * basicPay;
        grossPay = basicPay + DA + HRA;
    }

    // method to calculate income tax
    public void calculateIncomeTax(){
        if(grossPay <= 200000) incomeTax = 0;
        else if(grossPay <= 300000) incomeTax = 0.1 * grossPay;
        else if(grossPay <= 500000) incomeTax = 0.15 * grossPay;
        else{
            incomeTax = 0.3 * grossPay;
            incomeTax += 0.02 * incomeTax;
        }
    }

    // method to calcuate net pay
    public void calculateNetPay(){
        netPay = grossPay - incomeTax;
    }

    // method to display the information of the empolyeee.
    public void displayEmpolyeeInformation(){
        System.out.println("Information of the Empolyee,");
        System.out.println("Empolyee Name : "  + name);
        System.out.println("Empolyee ID : " + Id);
        System.out.println("Department name : " + deptName);
        System.out.println("Basic pay : " + basicPay);
        System.out.println("Gross pay : " + grossPay);
        System.out.println("Net pay : " + netPay);
    }
}

public class EmployeePay {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of empolyee : ");
        int N = scan.nextInt();
        scan.nextLine(); // consume next line..

        Employee[] employees = new Employee[N];

        for(int i = 0; i < N; i++){
            // Intend the way you want..
            System.out.println("Enter the details of employee " + (i+1) + ",");
            System.out.print("Enter the name : ");
            String name = scan.nextLine();
            System.out.print("Enter the deptartment name : ");
            String deptName = scan.nextLine();
            System.out.print("Enter the ID : " );
            int Id = scan.nextInt();
            System.out.print("Enter the basic pay : ");
            double basicPay = scan.nextDouble();

            scan.nextLine(); // consume next line.

            // construct and call the calcualte functions 
            employees[i] = new Employee(Id, name, deptName, basicPay);
            employees[i].calculateGrossPay();
            employees[i].calculateIncomeTax();
            employees[i].calculateNetPay();

            System.out.println();
        }

        // call display method for every empolyee using a loop.
        for(Employee employee : employees){
            employee.displayEmpolyeeInformation();
            System.out.println();
        }

        scan.close();
    }
}
