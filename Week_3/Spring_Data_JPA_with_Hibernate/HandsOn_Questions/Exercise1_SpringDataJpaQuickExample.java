import java.util.Arrays;
import java.util.List;

public class Exercise1_SpringDataJpaQuickExample {
    public static void main(String[] args) {
        CountryService service = new CountryService();

        Country india = new Country("IN", "India");
        Country usa = new Country("US", "United States");

        service.addCountry(india);
        service.addCountry(usa);

        List<Country> countries = service.getAllCountries();
        System.out.println("Countries saved in database:");
        countries.forEach(System.out::println);
    }
}

class Country {
    private String code;
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}';
    }
}

class CountryRepository {
    public void save(Country country) {
        System.out.println("Saved: " + country);
    }

    public List<Country> findAll() {
        return Arrays.asList(
                new Country("IN", "India"),
                new Country("US", "United States")
        );
    }
}

class CountryService {
    private final CountryRepository repository = new CountryRepository();

    public void addCountry(Country country) {
        repository.save(country);
    }

    public List<Country> getAllCountries() {
        return repository.findAll();
    }
}
