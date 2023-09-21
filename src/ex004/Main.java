package ex004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Insira os dados da conta");
            System.out.print("Numero: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Titular: ");
            String name = sc.nextLine();
            System.out.print("Balanco Inicial: ");
            Double initialDeposit = sc.nextDouble();
            System.out.print("Limite de Saque: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, name, initialDeposit, withdrawLimit);

            System.out.print("Quanto deseja sacar? ");
            double saque = sc.nextDouble();

            account.withdraw(saque);
        }
        catch (BussinessException e){
            System.out.println("Erro: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado");
        }
        sc.close();

    }
}
