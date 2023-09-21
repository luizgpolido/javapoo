package ex002;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();

        for (int i = 1; i <= numberOfProducts; i++) {
            System.out.printf("Product #%d data: \n" , i);
            System.out.printf("Commom, used or imported? (c/u/i)");
            char typeOfProduct = sc.next().charAt(0);
            sc.nextLine();
            System.out.printf("Name: ");
            String name = sc.nextLine();
            System.out.printf("Price: ");
            double price = sc.nextDouble();

            if (typeOfProduct == 'i'){
                System.out.printf("Customs fee: ");
                double customsFee = sc.nextDouble();
                productList.add(new ImportedProduct(name, price, customsFee));
            } else if (typeOfProduct == 'u') {
                System.out.printf("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                productList.add(new UsedProduct(name, price, date));
            } else {
                productList.add(new Product(name, price));
            }

            System.out.println("PRICE TAGS");
        }

            for (Product product : productList) {
                System.out.println(product.priceTag());
            }


        sc.close();

    }
}
