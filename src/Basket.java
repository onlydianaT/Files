import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Basket implements Serializable {
    private String[] product = {"Moloko ", "Xleb ", "Grechka "};
    private int[] prices = {50, 14, 80};
    private int[] numbers = {1, 2, 3};
    private int[] sumProducts = new int[3];
    private int[] numberOfProduct = new int[3];
    private int priceOfGoods = 0;

    public Basket() {
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

    public void saveBin(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        for (int i = 0; i < numberOfProduct.length; i++) {
            if (sumProducts[i] != 0) {
                String s = numbers[i] + " " + product[i] + " " + sumProducts[i] + " shtuk, " + "cena " +
                        prices[i] + " rub/za shtuku, " + "Vsego za dannii tovar " + (prices[i] * sumProducts[i]) + " rub";
                out.writeObject(s);
            }
        }
        out.close();
    }

    public static Basket loadFromBinFile(File file) throws IOException, ClassNotFoundException {
        Basket basket = new Basket();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        String d = (String) in.readObject();
        try {
            while (!d.equals(null)) {
                System.out.println(d);
                d = (String) in.readObject();
            }
        } catch (IOException e) {
        }
        in.close();
        return basket;
    }
}




