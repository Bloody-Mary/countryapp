package model.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.babushkina.countryapp.model.entity.*;

import java.util.List;

public class CountryTest {
    private static Country country;
    private static Region region;
    private static City city;
    private static District district;
    private static Citizen citizen1;
    private static Citizen citizen2;
    private static Citizen citizen3;
    private static Citizen citizen4;
    private static Citizen citizen5;


    @BeforeClass
    public static void setUp() {
        country = Country.getInstance();
        region = new Region("Краснодарский край", 75485, "Краснодар");
        city = new City("Краснодар", 342);
        district = new District("Центральный", 22);

        citizen1 = new Citizen(5, "hfbvnfjd", "qjsbs", 37, country);
        citizen2 = new Citizen(48, "John", "hgana", 26, country);
        citizen3 = new Citizen(426, "hbdbq", "Anderson", 58, country);
        citizen4 = new Citizen(867, "птабыд", "тьвбыы", 55, country);
        citizen5 = new Citizen(555, "птаффыс", "hfnms",19, country);

        country.getCitizens().addAll(List.of(citizen1, citizen2, citizen3, citizen4, citizen5));
        city.getDistricts().add(district);
    }

    @Test
    public void testGetInstance() {
        Assert.assertNotNull(country);
        Assert.assertTrue(true);
        Country secondInstance = Country.getInstance();
        Assert.assertEquals(secondInstance, country);
    }

    @Test
    public void testGetInstanceCityAndRegions() {
        Country country = Country.getInstance();
        String expectedCountryName = "Россия";
        Assert.assertEquals(country.getName(), expectedCountryName);

        String expectedCapitalName = "Москва";
        double expectedCapitalArea = 2561.5;
        City capital = country.getCity();
        Assert.assertEquals(capital.getName(), expectedCapitalName);
        Assert.assertEquals(capital.getArea(), expectedCapitalArea, 0.001);

        List<Region> regions = country.getRegions();
        Assert.assertEquals(regions.size(), 5);

        Region region1 = regions.get(0);
        String expectedRegion1Name = "Московская область";
        int expectedRegion1Area = 45800;
        String expectedRegion1Capital = "Москва";
        Assert.assertEquals(region1.getName(), expectedRegion1Name);
        Assert.assertEquals(region1.getArea(), expectedRegion1Area);
        Assert.assertEquals(region1.getCenter(), expectedRegion1Capital);

        Region region2 = regions.get(0);
        String expectedRegion2Name = "Смоленская область";
        int expectedRegion2Area = 49800;
        String expectedRegion2Capital = "Смоленск";
        Assert.assertEquals(region2.getName(), expectedRegion2Name);
        Assert.assertEquals(region2.getArea(), expectedRegion2Area);
        Assert.assertEquals(region2.getCenter(), expectedRegion2Capital);

        Region region3 = regions.get(0);
        String expectedRegion3Name = "Ленинградская область";
        int expectedRegion3Area = 83900;
        String expectedRegion3Capital = "Санкт-Петербург";
        Assert.assertEquals(region3.getName(), expectedRegion3Name);
        Assert.assertEquals(region3.getArea(), expectedRegion3Area);
        Assert.assertEquals(region3.getCenter(), expectedRegion3Capital);

        Region region4 = regions.get(0);
        String expectedRegion4Name = "Новосибирская область";
        int expectedRegion4Area = 177800;
        String expectedRegion4Capital = "Новосибирск";
        Assert.assertEquals(region4.getName(), expectedRegion4Name);
        Assert.assertEquals(region4.getArea(), expectedRegion4Area);
        Assert.assertEquals(region4.getCenter(), expectedRegion4Capital);

        Region region5 = regions.get(0);
        String expectedRegion5Name = "Магаданская область";
        int expectedRegion5Area = 462464;
        String expectedRegion5Capital = "Магадан";
        Assert.assertEquals(region5.getName(), expectedRegion5Name);
        Assert.assertEquals(region5.getArea(), expectedRegion5Area);
        Assert.assertEquals(region5.getCenter(), expectedRegion5Capital);
    }

    @Test
    public void testGetRegions() {
        List<Region> expectedRegions = country.getRegions();
        List<Region> actualRegions = country.getRegions();

        Assert.assertEquals(actualRegions, expectedRegions);
    }

    @Test
    public void testGetCitizens() {
        List<Citizen> expectedCitizens = country.getCitizens();
        List<Citizen> actualCitizens = country.getCitizens();

        Assert.assertEquals(actualCitizens, expectedCitizens);
    }

    @Test
    public void testGenerateCitizens() {
        country = Country.getInstance();
        List<Citizen> citizens = country.getCitizens();

        Assert.assertEquals(citizens.size(), 1000);
    }

    @Test
    public void testGenerateRandomName() {
        country = Country.getInstance();
        String randomName = country.generateRandomName();

        Assert.assertNotNull(randomName);
        Assert.assertFalse(randomName.isEmpty());
        Assert.assertTrue(randomName.length() >= 5 && randomName.length() <= 10);
    }

    @Test
    public void testGenerateRandomAge() {
        country = Country.getInstance();
        int randomAge = country.generateRandomAge();

        Assert.assertTrue(randomAge >= 18 && randomAge <= 90);
    }

    @Test
    public void testPrintCitizensWithLetter() {
        char letter = 'm';
        System.out.println("Горожане с именем, начинающимся на букву '" + letter + "':");

        for (Citizen citizen : country.getCitizens()) {
            String firstName = citizen.getFirstName();
            if (firstName.toLowerCase().startsWith(String.valueOf(letter).toLowerCase())) {
                System.out.println(citizen);
            }
        }
    }

    @Test
    public void testToString() {
        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("Страна: Россия\n");
        expectedStringBuilder.append("Столица: Москва\n");
        expectedStringBuilder.append("Регионы:\n");

        List<Region> expectedRegions = country.getRegions();
        for (Region region : expectedRegions) {
            expectedStringBuilder.append("  - ").append(region.getName()).append("\n");
        }
        String expectedString = expectedStringBuilder.toString();
        String actualString = country.toString();

        Assert.assertEquals(actualString, expectedString);
    }
}