package ex003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contribuinte> contribuinteList = new ArrayList<>();

        System.out.print("Insira o número de contribuintes: ");
        int numContribuintes = sc.nextInt();

        for (int i = 1; i <= numContribuintes; i++) {
            System.out.printf("Contribuinte #%d: \n" , i);
            System.out.print("Individual ou Company? (i/c): ");
            char tipoContribuinte = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Renda Anual: ");
            double rendaAnual = sc.nextDouble();

            if (tipoContribuinte == 'c'){
                System.out.print("Numero de Funcionarios:");
                int numeroFuncionarios = sc.nextInt();
                contribuinteList.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            } else {
                System.out.print("Gastos com saude: ");
                double gastosSaude = sc.nextDouble();
                contribuinteList.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            }
        }
        System.out.println("Impostos a pagar: ");
        for (Contribuinte contribuinte : contribuinteList ) {
            System.out.printf("%s: $ %.2f\n" , contribuinte.getName() , contribuinte.impostoDevido());
        }
        double soma = 0.0;
        for (Contribuinte contribuinte: contribuinteList ) {
            soma += contribuinte.impostoDevido();
        }

        System.out.printf("Imposto total recolhido: $%.2f" , soma);

        sc.close();
    }
}
