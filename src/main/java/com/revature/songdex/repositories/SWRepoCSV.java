package com.revature.songdex.repositories;

import com.revature.songdex.domain.Person;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * SWRepoCSV is a CSV Reader specialized for importing Star Wars Character data in a known format:
 * id, name, height, mass, hair color, skin color, eye color, birth year, gender, homeworld, species
 */
public class SWRepoCSV implements SWRepo {
    private List<Person> people;
    private InputStream file;

    /**
     * Constructor requiring path to CSV file
     * @param filename CSV file to parse
     */
    public SWRepoCSV(String filename) {
        this.people = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(filename);
        load();
    }

    /**
     * Loads CSV file into List
     */
    private void load() {
        Scanner scanner = new Scanner(this.file);
        scanner.useDelimiter("\n");

        //Line 1 is the headers
        scanner.next();
        while (scanner.hasNext()) {
            String[] columns = scanner.next().split(",");

            Person temp = Person.builder()
                    .id(columns[0])
                    .name(columns[1])
                    .height(columns[2])
                    .mass(columns[3])
                    .hairColor(columns[4])
                    .skinColor(columns[5])
                    .eyeColor(columns[6])
                    .birthYear(columns[7])
                    .gender(columns[8])
                    .homeworld(columns[9])
                    .species(columns[10]);

            people.add(temp);
        }
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

    @Override
    public Person getPerson(String name) {
        for (Person person : people)
            if (person.getName().equals(name))
                return person;

        return null;
    }
}