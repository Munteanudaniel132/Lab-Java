package worldpop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadCsvThread {
    public static void main(String[] args) {
        String filePath = "C:\\Anul 2 ETTI\\Java anul 2\\lab 6\\world-country-populations.csv";

        CsvReader csvReader = new CsvReader(filePath);
        Thread csvThread = new Thread(csvReader);
        csvThread.start();

        try {
            csvThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<CsvData> dataList = csvReader.getDataList();
        if (dataList != null) {
            Collections.sort(dataList);

            for (CsvData country : dataList) {
                System.out.println(country);
            }
        }
    }
}
class CsvReader implements Runnable {
    private String filePath;
    private List<CsvData> dataList;

    public CsvReader(String filePath) {
        this.filePath = filePath;
        this.dataList = new ArrayList<>();
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Ignoră prima linie (headerul)
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                CsvData csvData = new CsvData(
                        Integer.parseInt(values[0].trim()),
                        Integer.parseInt(values[1].trim()),
                        values[2].trim(),
                        values[3].trim(),
                        Double.parseDouble(values[4].trim()),
                        values[5].trim()
                );
                dataList.add(csvData);
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului CSV: " + e.getMessage());
        }
    }

    // Metodă pentru a obține lista de date citite
    public List<CsvData> getDataList() {
        return dataList;
    }
}