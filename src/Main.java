import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] product = {"Moloko ", "Xleb ", "Grechka "};
        int[] prices = {50, 14, 80};
        int[] numbers = {1, 2, 3};

        Basket basket = new Basket(numbers, product, prices);
        File file = new File("basket.txt");
        if (file.exists()) {
            basket.loadFromTxtFile();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vi hotite izmenit' sostav korzini? Vvedite yes or no");
        String input = scanner.nextLine();
        if ("no".equals(input)) {
            System.out.println("Vasha korzina:");
            basket.loadFromTxtFile();
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
            basket.saveTxt();
        }
    }

}






















