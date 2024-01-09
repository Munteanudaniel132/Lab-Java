package worldpop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ReadCsv {
    public static void main(String[] args){
        String filePath = "C:\\Anul 2 ETTI\\Java anul 2\\lab 6\\world-country-populations.csv";
        List<CsvData> dataList = new ArrayList<>();
try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
    br.readLine();
    String line;
    while ((line = br.readLine()) != null){
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
       // System.out.println(csvData);
    }
    Collections.sort(dataList);
    for(CsvData country: dataList);
    System.out.println(dataList);
}
catch(IOException e){
    e.printStackTrace();
}
    }
}
