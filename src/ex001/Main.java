package ex001;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Locale.setDefault(Locale.US);

        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Employee #%d data: \n" , i);
            System.out.print("Outsourced? (y/n): ");
            char outSourced = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (outSourced == 'y'){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                employeeList.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                employeeList.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println("PAYMENTS: ");
        for (Employee employee: employeeList) {
            System.out.println(employee.getName() + " - $ " + employee.payment());
        }

        sc.close();

    }
}
