package com.revature.songdex.service;

import com.revature.songdex.domain.Person;
import com.revature.songdex.repositories.SWRepo;

import java.util.List;

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
        return repo.getPerson(input.trim());
    }

    /**
     * Creates the HTML Form to search for a character
     * @return String of html form
     */
    public String searchForm() {
        String HTMLForm = "<html>\n" +
                "<head><title>Search Star Wars Characters</title></head>\n" +
                "<body>\n" +
                "    <form action='search' method='get'>\n" +
                "        <input type='text' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";

        return HTMLForm;
    }
}
