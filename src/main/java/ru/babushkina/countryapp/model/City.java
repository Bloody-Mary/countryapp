package ru.babushkina.countryapp.model;

public class City {
    private final String name;
    private final double area;

    public City(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }
}
