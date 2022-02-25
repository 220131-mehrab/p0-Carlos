package com.revature.songdex.service;

import com.revature.songdex.domain.Person;
import com.revature.songdex.repositories.SWRepo;

import java.util.List;
import java.util.Locale;

/**
 * Star Wars Service provides services for the servlet classes
 */
public class SWService {
    SWRepo repo;

    /**
     * SWService constructor takes a SWRepo that it will use as its repository
     * @param repo Repository of charcters to use
     */
    public SWService(SWRepo repo) {
        this.repo = repo;
    }

    /**
     * Gets all characters
     * @return List of Persons objects holding all the characters in repo
     */
    public List<Person> getPerson() {
        return repo.getAll();
    }

    /**
     * Searches for a specific character by name
     * @param input Name of character being searched for
     * @return Person object with matching name
     */
    public Person getPerson(String input) {
        return repo.getPerson(input.trim().toLowerCase(Locale.ROOT));
    }

    /**
     * Creates the HTML Form to search for a character
     * @return String of html form
     */
    public String searchForm() {
        String HTMLForm = "<html>\n" +
                "<meta charset='UTF-8'/>\n" +
                "<head><title>Search Star Wars Characters</title></head>\n" +
                "<body>\n" +
                "    <form action='list' method='get'>\n" +
                "        <input type='submit' value='Full Character List'/>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";

        return HTMLForm;
    }

    public String infoPage(Person p) {
        String HTMLStats = "<html>\n" +
                "<body>\n" +
                "<h1>" + p.getName() +  "</h1>\n" +
                "<p>Height: " + p.getHeight() + "</p>\n" +
                "<p>Mass: " +  p.getMass() + "</p>\n" +
                "<p>Hair Color: " + p.getHairColor() + "</p>\n" +
                "<p>Skin Color: " + p.getSkinColor() + "</p>\n" +
                "<p>Eye Color: " + p.getEyeColor() + "</p>\n" +
                "<p>Birth Year: " + p.getBirthYear() + "</p>\n" +
                "<p>Gender: " + p.getGender() + "</p>\n" +
                "<p>Homeworld: " + p.getHomeworld() + "</p>\n" +
                "<p>Species: " + p.getSpecies() + "</p>\n" +
                "</body>\n" +
                "</html>";

        return HTMLStats;
    }

    public String listHeader() {
        String HTMLListHead = "<html>\n" +
                "<meta charset='UTF-8'/>\n" +
                "<head><title>Star Wars Character List</title></head>\n" +
                "<body>\n" +
                "<h1>Character List</h1>\n" +
                "    <form action='search' method='get'>\n" +
                "        <input type='text' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "    </form>\n" +
                "</html>";

        return HTMLListHead;
    }
}
