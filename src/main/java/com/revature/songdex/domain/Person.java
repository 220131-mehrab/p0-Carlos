package com.revature.songdex.domain;

import java.util.Objects;

/**
 * Person is a datatype for Star Wars characters
 * Each Person has an id, name, height, mass, hair color,skin color, eye color, birth year, gender, homeworld, and species
 */

public class Person {
    // Fields
    private int id;
    private String name;
    private int height;
    private double mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private double birthYear;
    private String gender;
    private String homeworld;
    private String species;

    /**
     * Builder creates a new Person object
     *
     * @return new Person object
     */
    public static Person builder() {
        return new Person();
    }

    public Person id(String id) {
        id = id.replace("\"", "");
        int intId = Integer.parseInt(id);
        this.id = intId;
        return this;
    }

    public Person name(String name) {
        name = name.replace("\"", "");
        this.name = name;
        return this;
    }

    public Person height(String height) {
        height = height.replace("\"", "");

        if (height.equals("NA"))
            this.height = -1;
        else
            this.height = Integer.parseInt(height);
        return this;
    }

    public Person mass(String mass) {
        mass = mass.replace("\"", "");

        if (mass.equals("NA"))
            this.mass = -1;
        else
            this.mass = Double.parseDouble(mass);
        return this;
    }

    public Person hairColor(String hairColor) {
        hairColor = hairColor.replace("\"", "");
        this.hairColor = hairColor;
        return this;
    }

    public Person skinColor(String skinColor) {
        skinColor = skinColor.replace("\"", "");
        this.skinColor = skinColor;
        return this;
    }

    public Person eyeColor(String eyeColor) {
        eyeColor = eyeColor.replace("\"", "");
        this.eyeColor = eyeColor;
        return this;
    }

    public Person birthYear(String birthYear) {
        birthYear = birthYear.replace("\"", "");
        if (birthYear.equals("NA"))
            this.birthYear = -1;
        else
            this.birthYear = Double.parseDouble(birthYear);
        return this;
    }

    public Person gender(String gender) {
        gender = gender.replace("\"", "");
        this.gender = gender;
        return this;
    }

    public Person homeworld(String homeworld) {
        homeworld = homeworld.replace("\"", "");
        this.homeworld = homeworld;
        return this;
    }

    public Person species(String species) {
        species = species.replace("\"", "");
        this.species = species;
        return this;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
