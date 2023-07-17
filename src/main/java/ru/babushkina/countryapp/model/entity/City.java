package ru.babushkina.countryapp.model.entity;

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
