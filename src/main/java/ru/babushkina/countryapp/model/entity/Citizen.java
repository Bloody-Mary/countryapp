package ru.babushkina.countryapp.model.entity;

public class Citizen {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Country country;

    public Citizen(int id, String firstName, String lastName, int age, Country country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Country getCountry() {
        return country;
    }

    public String toString() {
        return "Гражданин " + id + ": " + firstName + " " + lastName + ", Возраст: " + age;
    }
}
