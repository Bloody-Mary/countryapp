package ru.babushkina.countryapp._main;

import ru.babushkina.countryapp.model.Citizen;
import ru.babushkina.countryapp.model.Country;
import ru.babushkina.countryapp.model.Region;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Country country = Country.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Вывести столицу");
            System.out.println("2. Вывести количество областей");
            System.out.println("3. Вывести площадь государства");
            System.out.println("4. Вывести областные центры");
            System.out.println("5. Вывести средний возраст жителей");
            System.out.println("6. Вывести жителей с именем, состоящим из N букв");
            System.out.println("7. Вывести список жителей, у которых имя начинается с буквы m");
            System.out.println("8. Выйти из программы");
            System.out.println("Введите номер команды: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Столица: " + country.getCapital().getName());
                    break;
                case 2:
                    System.out.println("Количество областей: " + country.getRegions().size());
                    break;
                case 3:
                    double totalArea = 0;
                    for (Region region : country.getRegions()) {
                        totalArea += region.getArea();
                    }
                    System.out.println("Площадь государства: " + totalArea);
                    break;
                case 4:
                    System.out.println("Областные центры:");
                    for (Region region : country.getRegions()) {
                        System.out.println("Область: " + region.getName() + ", Областной центр: " + region.getCenter());
                    }
                    break;
                case 5:
                    int totalAge = 0;
                    int citizenCount = country.getCitizens().size();
                    for (Citizen citizen : country.getCitizens()) {
                        totalAge += citizen.getAge();
                    }
                    double averageAge = totalAge / (double) citizenCount;
                    System.out.println("Средний возраст жителей: " + averageAge);
                    break;
                case 6:
                    System.out.println("Введите количество букв в имени:");
                    int letterCount = scanner.nextInt();
                    System.out.println("Жители с именем, состоящим из " + letterCount + " букв:");
                    for (Citizen citizen : country.getCitizens()) {
                        if (citizen.getFirstName().length() == letterCount) {
                            System.out.println(citizen);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Введите первую букву:");
                    char startingLetter = scanner.next().charAt(0);
                    country.printCitizensWithLetter(startingLetter);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}