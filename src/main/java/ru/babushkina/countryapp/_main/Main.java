package ru.babushkina.countryapp._main;

import ru.babushkina.countryapp.model.entity.Country;
import ru.babushkina.countryapp.controller.MainController;
import ru.babushkina.countryapp.view.MainView;

public class Main {
    public static void main(String[] args) {
        Country country = Country.getInstance();
        MainView view = new MainView();
        MainController controller = new MainController(view, country);
        controller.Run();
    }
}