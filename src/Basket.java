import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Basket {
    private String[] product;
    private int[] prices;
    private int[] numbers;
    private int[] sumProducts = new int[3];
    private int[] numberOfProduct = new int[3];
    private int priceOfGoods = 0;

    public Basket(int[] prices, String[] product, int[] numbers) {
        this.prices = prices;
        this.product = product;
        this.numbers = numbers;
    }

    public void addToCart(int productNum, int amount) {
        numberOfProduct[productNum] = productNum;
        priceOfGoods += (amount * prices[productNum]);
        sumProducts[productNum] += amount;
    }

    public void printCart() {
        System.out.println("Vasha korzina: ");
        for (int i = 0; i < numberOfProduct.length; i++) {
            if (sumProducts[i] != 0) {
                System.out.println(numbers[i] + " " + product[i] + " " + sumProducts[i] + " shtuk, " + "cena " +
                        prices[i] + " rub/za shtuku, " + "Vsego za dannii tovar " + (prices[i] * sumProducts[i]) + " rub");
            }
        }
        System.out.println("Itogovaya stoimost' " + priceOfGoods + " rub");
    }


    public void saveTxt() throws IOException {
        File file = new File("basket.txt");
        try (PrintWriter out = new PrintWriter(file);) {
            for (int i = 0; i < numberOfProduct.length; i++) {
                if (sumProducts[i] != 0) {
                    String s = numbers[i] + " " + product[i] + " " + sumProducts[i] + " shtuk, " + "cena " +
                            prices[i] + " rub/za shtuku, " + "Vsego za dannii tovar " + (prices[i] * sumProducts[i]) + " rub";
                    out.write(s + "\n");
                }
            }
            out.write("Itogovaya stoimost': ");
            String itog = priceOfGoods + " rub";
            out.write(itog + "\n");
            out.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static Basket loadFromTxtFile() throws IOException {
        File file = new File("basket.txt");
        InputStreamReader in = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        System.out.println("Schitivaem s faila:");
        while (in.ready()) {
            char read = (char) in.read();
            System.out.print(read);
        }
        in.close();
        return null;
    }
}



