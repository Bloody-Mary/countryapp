package model.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.babushkina.countryapp.model.entity.Citizen;
import ru.babushkina.countryapp.model.entity.Country;
import ru.babushkina.countryapp.model.entity.Region;

import java.util.List;

public class CountryTest {
    private static Country country;

    @BeforeClass
    public static void setUp() {
        country = Country.getInstance();
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
    public void testGetName() {
        String expectedName = "Россия";
        String actualName = country.getName();

        Assert.assertEquals(actualName, expectedName);
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