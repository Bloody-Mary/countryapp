package ru.babushkina.countryapp.controller;

import ru.babushkina.countryapp.model.entity.Citizen;
import ru.babushkina.countryapp.model.entity.Country;
import ru.babushkina.countryapp.model.entity.Region;
import ru.babushkina.countryapp.view.MainView;

import java.util.Scanner;

public class MainController {
    private final MainView view;
    private final Country country;

    public MainController(MainView view, Country country) {
        this.view = view;
        this.country = country;
    }

    public void Run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.showMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println(country.toString());
                    break;
                case 2:
                    System.out.println("Столица: " + country.getCapital().getName());
                    break;

                case 3:
                    System.out.println("Количество областей: " + country.getRegions().size());
                    break;
                case 4:
                    double totalArea = 0;
                    for (Region region : country.getRegions()) {
                        totalArea += region.getArea();
                    }
                    System.out.println("Площадь государства: " + totalArea);
                    break;
                case 5:
                    System.out.println("Областные центры:");
                    for (Region region : country.getRegions()) {
                        System.out.println("Область: " + region.getName() + ", Областной центр: " + region.getCenter());
                    }
                    break;
                case 6:
                    int totalAge = 0;
                    int citizenCount = country.getCitizens().size();
                    for (Citizen citizen : country.getCitizens()) {
                        totalAge += citizen.getAge();
                    }
                    double averageAge = totalAge / (double) citizenCount;
                    System.out.println("Средний возраст жителей: " + averageAge);
                    break;
                case 7:
                    System.out.println("Введите количество букв в имени:");
                    int letterCount = scanner.nextInt();
                    System.out.println("Жители с именем, состоящим из " + letterCount + " букв:");
                    for (Citizen citizen : country.getCitizens()) {
                        if (citizen.getFirstName().length() == letterCount) {
                            System.out.println(citizen);
                        }
                    }
                    break;
                case 8:
                    System.out.println("Введите первую букву:");
                    char startingLetter = scanner.next().charAt(0);
                    country.printCitizensWithLetter(startingLetter);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

}
