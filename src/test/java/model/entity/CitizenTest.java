package model.entity;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.babushkina.countryapp.model.entity.Citizen;

public class CitizenTest {
    @Test
    public void testToString() {
        int id = 105;
        String firstName = "hgnjhnm";
        String lastName = "аримтаоа";
        int age = 30;

        Citizen citizen = new Citizen(id, firstName, lastName, age, null);
        String expectedString = "Гражданин " + id + ": " + firstName + " " + lastName + ", Возраст: " + age;
        String actualString = citizen.toString();

        Assert.assertEquals(actualString, expectedString);
    }
}
