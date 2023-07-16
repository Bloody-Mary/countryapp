package ru.babushkina.countryapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Country {
    private static Country instance;

    private final String name;
    private final City capital;
    private final List<Region> regions;
    private final List<Citizen> citizens;

    private Country(String name, City capital, List<Region> regions) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
        this.citizens = new ArrayList<>();
        generateCitizens();
    }

    public static Country getInstance() {
        if (instance == null) {
            City capital = new City("Москва", 2561.5);
            List<Region> regions = new ArrayList<>();

            Region region1 = new Region("Московская область", 45800);
            Region region2 = new Region("Смоленская область", 49800);
            Region region3 = new Region("Ленинградская область", 83900);
            Region region4 = new Region("Новосибирская область", 177800);
            Region region5 = new Region("Магаданская область", 462464);

            regions.add(region1);
            regions.add(region2);
            regions.add(region3);
            regions.add(region4);
            regions.add(region5);

            instance = new Country("Россия", capital, regions);
        }
        return instance;
    }

    public City getCapital() {
        return capital;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    private void generateCitizens() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int id = i + 1;
            String firstName = generateRandomName();
            String lastName = generateRandomName();
            int age = generateRandomAge();
            Citizen citizen = new Citizen(id, firstName, lastName, age, this);
            citizens.add(citizen);
        }
    }

    private String generateRandomName() {
        Random random = new Random();
        int length = random.nextInt(10 - 5 + 1) + 5;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    private int generateRandomAge() {
        Random random = new Random();
        return random.nextInt(90 - 18 + 1) + 18;
    }

    public void printCitizensWithLetter(char letter) {
        System.out.println("Горожане с именем, начинающимся на букву '" + letter + "':");
        for (Citizen citizen : citizens) {
            if (citizen.getFirstName().toLowerCase().startsWith(String.valueOf(letter).toLowerCase())) {
                System.out.println(citizen);
            }
        }
    }
}
