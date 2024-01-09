package worldpop;

public class CsvData implements Comparable<CsvData>{
    int population_2023;
    int population_2022;
    String city;
    String country;
    double population_growhrate;
    String rate;
public int compareTo(CsvData bx){
    return country.compareTo(bx.country);
}
    public CsvData(int population_2023, int population_2022, String city, String country, double population_growhrate, String rate){
this.population_2023 = population_2023;
this.population_2022 = population_2022;
this.city = city;
this. country = country;
this.population_growhrate = population_growhrate;
this.rate = rate;
    }
    @Override
    public String toString() {
        return "population 2023 = " + population_2023 +
                ", population 2022 = " + population_2022 +
                ", city = " + city +
                ", country = " + country +
                ", population growth rate = " + population_growhrate +
                ", rate = " + rate;
    }

}