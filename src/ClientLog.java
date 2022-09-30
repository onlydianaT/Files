import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientLog {
    private int productNum;
    private int amount;

    private Object[] ar = new Object[2];

    public void log(int productNum, int amount) {
        ar[0] = productNum + 1;
        ar[1] = amount;
    }

    public void exportAsCSV(File txtFile) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(txtFile, true))) {
            csvWriter.writeNext(Arrays.deepToString(ar).split(","));
        }
    }
}
