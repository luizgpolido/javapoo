package ex005.program;

import ex005.entities.Contract;
import ex005.entities.Installment;
import ex005.services.ContractService;
import ex005.services.PayPalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Enter the contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("Contract Price: ");
        double totalPrice = sc.nextDouble();

        Contract contract = new Contract(number, date, totalPrice);

        System.out.print("Enter the number of installments: ");
        int installments = sc.nextInt();



        ContractService contractService = new ContractService(new PayPalService());

        contractService.processContract(contract, installments);
        System.out.println("Installments: ");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

    }
}
