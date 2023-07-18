package ru.babushkina.countryapp.model.entity;

import java.util.List;

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

    public <E> List<E> getDistricts() {
        return null;
    }
}
