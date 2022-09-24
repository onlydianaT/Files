import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] product = {"Moloko ", "Xleb ", "Grechka "};
        int[] prices = {50, 14, 80};
        int[] numbers = {1, 2, 3};
        int[] sumProducts = new int[3];
        int[] numberOfProduct = new int[3];
        int priceOfGoods = 0;

        Basket basket = new Basket();
        File file = new File("basket.bin");
        if (file.exists()) {
            basket=basket.loadFromBinFile(file);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vi hotite izmenit' sostav korzini? Vvedite yes or no");
        String input = scanner.nextLine();
        if ("no".equals(input)) {
            System.out.println("Vasha korzina predstavlena vishe");

        } else {
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i] + " " + product[i] + prices[i] + " rub/shtuka");
            }
            while (true) {
                System.out.println("Viberete nomer tovara i kolichestvo ili napishite end");
                String in = scanner.nextLine();
                if ("end".equals(in)) {
                    break;
                } else {

                    String[] parts = in.split(" ");
                    int productNumber = Integer.parseInt(parts[0]) - 1;// 0=1.1=2.2=3
                    int productCount = Integer.parseInt(parts[1]);// kolichestvo
                    basket.addToCart(productNumber, productCount);
                }
            }
            basket.printCart();
            basket.saveBin(file);

        }


    }

}
























