import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.io.FileWriter;

public class Basket {
    private String[] product = {"Moloko ", "Xleb ", "Grechka "};

    private int[] prices = {50, 14, 80};

    private int[] numbers = {1, 2, 3};

    private int[] sumProducts = new int[3];

    private int[] numberOfProduct = new int[3];
    private int priceOfGoods = 0;


    public Basket() {
        this.numbers = numbers;
        this.product = product;
        this.sumProducts = sumProducts;
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

    public Basket serialization(File file) throws IOException {
        Basket basket = new Basket();
        JSONObject obj = new JSONObject();
        for (int i = 0; i < numberOfProduct.length; i++) {
            if (sumProducts[i] != 0) {
                obj.put("number", numbers[i]);
                obj.put("name of product", product[i]);
                obj.put("amount", sumProducts[i]);
                obj.put("price", prices[i]);
                obj.put("general sum", prices[i] * sumProducts[i]);
                try (FileWriter files = new FileWriter(file, true)) {
                    files.write(obj.toString());
                    files.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return basket;
    }

    public static Basket deserialization(File file) throws IOException, ClassNotFoundException {
        Basket basket = new Basket();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return basket;
    }
}



