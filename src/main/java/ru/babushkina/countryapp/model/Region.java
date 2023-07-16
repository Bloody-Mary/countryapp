package ru.babushkina.countryapp.model;

public class Region {
    private final String name;
    private final double area;
    public City getCenter;
    private final String center;

    public Region(String name, double area, String center) {
        this.name = name;
        this.area = area;
        this.center = center;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }
    
    public String getCenter() {
        return center;
    }
}
