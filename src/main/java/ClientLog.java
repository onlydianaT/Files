import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class ClientLog {
    private int productNum;
    private int amount;
    private Object[] ar = new Object[2];

    private Map<Integer, Integer> map = new HashMap();

    public void log(int productNum, int amount) {
        map.put(productNum + 1, amount);
    }

    public void exportAsCSV(File txtFile) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(txtFile, true))) {
            for (int key : map.keySet()) {
                String value = String.valueOf(map.get(key));
                String log = String.valueOf(key + "," + value);
                try {
                    FileReader myFile = new FileReader(txtFile);
                    BufferedReader InputFile = new BufferedReader(myFile);
                    if (txtFile.exists() && InputFile.readLine() == null) {
                        String title = "productNum" + "," + "amount";
                        csvWriter.writeNext(title.split(","));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                csvWriter.writeNext(log.split(","));
            }
        }
    }
}
