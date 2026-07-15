import java.time.LocalDate;
import java.util.List;

public class Exercise2_QueryMethodsStock {
    public static void main(String[] args) {
        StockRepository repository = new StockRepository();

        List<Stock> septemberFb = repository.findByCodeAndDateBetween("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        System.out.println("Facebook stock in September 2019:");
        septemberFb.forEach(System.out::println);

        List<Stock> googleAbove1250 = repository.findByCodeAndCloseGreaterThan("GOOGL", 1250.0);
        System.out.println("\nGoogle stocks above 1250:");
        googleAbove1250.forEach(System.out::println);
    }
}

class Stock {
    private String code;
    private LocalDate date;
    private double open;
    private double close;
    private long volume;

    public Stock(String code, LocalDate date, double open, double close, long volume) {
        this.code = code;
        this.date = date;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public String getCode() { return code; }
    public LocalDate getDate() { return date; }
    public double getOpen() { return open; }
    public double getClose() { return close; }
    public long getVolume() { return volume; }

    @Override
    public String toString() {
        return code + " | " + date + " | " + open + " | " + close + " | " + volume;
    }
}

class StockRepository {
    public List<Stock> findByCodeAndDateBetween(String code, LocalDate start, LocalDate end) {
        return List.of(new Stock("FB", LocalDate.of(2019, 9, 3), 184.0, 182.39, 9779400));
    }

    public List<Stock> findByCodeAndCloseGreaterThan(String code, double price) {
        return List.of(new Stock("GOOGL", LocalDate.of(2019, 4, 22), 1236.67, 1253.76, 954200));
    }
}
