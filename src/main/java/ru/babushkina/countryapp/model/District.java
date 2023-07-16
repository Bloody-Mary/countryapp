package ru.babushkina.countryapp.model;

public class District {
    private final String name;
    private final double area;

    public District(String name, double area) {
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
