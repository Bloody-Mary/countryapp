package ru.babushkina.countryapp.view;

import java.util.Scanner;

public class MainView {
    private final Scanner scanner;

    public MainView() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Вывести информацию о государстве");
        System.out.println("2. Вывести столицу");
        System.out.println("3. Вывести количество областей");
        System.out.println("4. Вывести площадь государства");
        System.out.println("5. Вывести областные центры");
        System.out.println("6. Вывести средний возраст жителей");
        System.out.println("7. Вывести жителей с именем, состоящим из N букв");
        System.out.println("8. Вывести список жителей, у которых имя начинается с буквы m");
        System.out.println("9. Выйти из программы");
        System.out.println("Введите номер команды: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }
}
