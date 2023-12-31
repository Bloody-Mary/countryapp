package ru.babushkina.countryapp.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Country {
    private static Country instance;
    private String name;
    private City city;
    private final List<Region> regions;
    private final List<Citizen> citizens;

    private Country(String name, City capital, List<Region> regions) {
        this.name = name;
        this.city = capital;
        this.regions = regions;
        this.citizens = new ArrayList<>();
        generateCitizens();
    }

    public static Country getInstance() {
        if (instance == null) {
            City capital = new City("Москва", 2561.5);
            List<Region> regions = new ArrayList<>();
            Region region1 = new Region("Московская область", 45800, "Москва");
            Region region2 = new Region("Смоленская область", 49800, "Смоленск");
            Region region3 = new Region("Ленинградская область", 83900, "Санкт-Петербург");
            Region region4 = new Region("Новосибирская область", 177800, "Новосибирск");
            Region region5 = new Region("Магаданская область", 462464, "Магадан");
            instance = new Country("Россия", capital, regions);
            regions.add(region1);
            regions.add(region2);
            regions.add(region3);
            regions.add(region4);
            regions.add(region5);
        }
        return instance;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public String getName() {
        return name;
    }
    
    

    private void generateCitizens() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int id = i + 1;
            String firstName = generateRandomName();
            String lastName = generateRandomName();
            int age = generateRandomAge();
            Citizen citizen = new Citizen(id, firstName, lastName, age, this);
            citizens.add(citizen);
        }
    }

    public String generateRandomName() {
        Random random = new Random();
        int length = random.nextInt(10 - 5 + 1) + 5;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    public int generateRandomAge() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Страна: ").append(name).append("\n");
        sb.append("Столица: ").append(city.getName()).append("\n");
        sb.append("Регионы:\n");
        for (Region region : regions) {
            sb.append("  - ").append(region.getName()).append("\n");
        }
        return sb.toString();
    }
}


//    Вывод информации о Государстве с гражданами
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Страна: ").append(name).append("\n");
//        sb.append("Столица: ").append(capital.getName()).append("\n");
//        sb.append("Регионы:\n");
//        for (Region region : regions) {
//            sb.append("  - ").append(region.getName()).append("\n");
//        }
//        sb.append("Граждане:\n");
//        for (Citizen citizen : citizens) {
//            sb.append("  - ").append(citizen).append("\n");
//        }
//        return sb.toString();
//    }

