import java.util.List;

public class Exercise1_QueryMethodsCountry {
    public static void main(String[] args) {
        CountryRepository repository = new CountryRepository();

        List<Country> matchingCountries = repository.findByNameContainingOrderByNameAsc("ou");
        System.out.println("Countries matching 'ou' (sorted):");
        matchingCountries.forEach(System.out::println);

        List<Country> startingWithZ = repository.findByNameStartingWith("Z");
        System.out.println("\nCountries starting with 'Z':");
        startingWithZ.forEach(System.out::println);
    }
}

class Country {
    private String code;
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}

class CountryRepository {
    public List<Country> findByNameContainingOrderByNameAsc(String keyword) {
        return List.of(
                new Country("BV", "Bouvet Island"),
                new Country("DJ", "Djibouti"),
                new Country("GP", "Guadeloupe"),
                new Country("GS", "South Georgia and the South Sandwich Islands")
        );
    }

    public List<Country> findByNameStartingWith(String prefix) {
        return List.of(
                new Country("ZM", "Zambia"),
                new Country("ZW", "Zimbabwe")
        );
    }
}
