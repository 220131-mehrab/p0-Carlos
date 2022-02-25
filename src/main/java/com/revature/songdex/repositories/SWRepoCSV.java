package com.revature.songdex.repositories;

import com.revature.songdex.domain.Person;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

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
            if (person.nameMatch(name))
                return person;

        return null;
    }

    @Override
    public List<Person> getHeightSort() {
        List<Person> peeps = new ArrayList<>();
        for (Person p : people)
            if (p.getHeight() != -1)
                peeps.add(p);

        // Compare using getHeight method
        peeps.sort(Comparator.comparingDouble(Person::getHeight));

        return peeps;
    }

    @Override
    public List<Person> getMassSort() {
        List<Person> peeps = new ArrayList<>();
        for (Person p : people)
            if (p.getMass() != -1)
                peeps.add(p);

        // Compare using getMass method
        peeps.sort(Comparator.comparingDouble(Person::getMass));

        return peeps;
    }

    @Override
    public List<Person> getYearSort() {
        List<Person> peeps = new ArrayList<>();
        for (Person p : people)
            if (p.getBirthYear() != -1)
                peeps.add(p);

        // Compare using getBirthYear method
        peeps.sort(Comparator.comparingDouble(Person::getBirthYear).reversed());

        return peeps;
    }

    @Override
    public List<Person> getNameSort() {
        List<Person> peeps = new ArrayList<>(people);

        // Compare using getName method
        peeps.sort(Comparator.comparing(Person::getName));

        return peeps;
    }
}
