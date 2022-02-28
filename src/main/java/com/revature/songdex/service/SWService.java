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
    String inlineStyle;

    /**
     * SWService constructor takes a SWRepo that it will use as its repository
     *
     * @param repo Repository of charcters to use
     */
    public SWService(SWRepo repo) {
        this.inlineStyle = "<style>\n" +
                "body {background-color: #E0FFFF;}\n" +
                "h1 {font-weight: bold; font-style: italic;}\n" +
                "form {font-weight: bold; text-decoration: underline; text-decoration-color: black;}\n" +
                "a {color: black; text-decoration: none;}" +
                "</style>\n";
        this.repo = repo;
    }

    /**
     * Gets all characters
     *
     * @return List of Persons objects holding all the characters in repo
     */
    public List<Person> getPerson() {
        return repo.getAll();
    }

    /**
     * Searches for a specific character by name
     *
     * @param input Name of character being searched for
     * @return Person object with matching name
     */
    public Person getPerson(String input) {
        return repo.getPerson(input.trim().toLowerCase(Locale.ROOT));
    }

    /**
     * Creates the HTML Header for the Search Page
     *
     * @return String of html header
     */
    public String searchHeader() {
        String HTMLHeader = "<html>\n" +
                "<meta charset='UTF-8'/>\n" +
                "<head><title>Search Star Wars Characters</title>" +
                inlineStyle +
                "<body>\n" +
                "    <form action='list' method='get'>\n" +
                "        <input type='submit' value='Full Character List'/>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";

        return HTMLHeader;
    }

    /**
     * Creates the HTML statistics for specific character
     *
     * @param p Person object to create statistics from
     * @return String of HTML statistics
     */
    public String infoPage(Person p) {
        String HTMLStats = "<html>\n" +
                "<body>\n" +
                "<h1>" + p.getName() + "</h1>\n" +
                "<p>Height: " + p.getHeight() + "</p>\n" +
                "<p>Mass: " + p.getMass() + "</p>\n" +
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

    /**
     * Creates header for list page
     *
     * @return String of HTML header
     */
    public String listHeader() {
        String HTMLListHead = "<html>\n" +
                "<meta charset='UTF-8'/>\n" +
                "<head><title>Star Wars Character List</title>" +
                inlineStyle +
                "</head>\n" +
                "<body>\n" +
                "<h1>Character List</h1>\n" +
                "<form action='sort' method='get'>\n" +
                "    Sort by Field:<br/>\n" +
                "    <input type='radio' name='option' value='name' class='opt'/>Name\n" +
                "    <input type='radio' name='option' value='height' class='opt'/>Height\n" +
                "    <input type='radio' name='option' value='mass' class='opt'/>Mass\n" +
                "    <input type='radio' name='option' value='birthYear' class='opt'/>Birth Year</br>\n" +
                "    <input type='submit' value='Sort'/>\n" +
                "</form>\n" +
                "<form action='search' method='get'>\n" +
                "    <input type='text' name='searchName'/>\n" +
                "    <input type='submit' value='Search'/>\n" +
                "</form>\n" +
                "</html>";

        return HTMLListHead;
    }

    /**
     * Generates an HTML list of all characters as links to their stats pages
     *
     * @return String of HTML List
     */
    public String listContents() {
        String HTMLListContents = "<html>\n";

        for (Person p : getPerson())
            HTMLListContents += "<a href='search?searchName=" + p.getName() + "'>" + p + "</a></br>\n";

        HTMLListContents += "</html>";

        return HTMLListContents;
    }

    /**
     * Generates a header for the Sorting pages
     *
     * @return String of HTML Header
     */
    public String sortHeader(String opt) {
        String HTMLHeader = "<html>\n" +
                "<meta charset='UTF-8'/>\n" +
                "<head><title>Sorted Star Wars Characters</title>" +
                inlineStyle +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Star Wars Characters Sorted By Field: " + opt + "</h1>" +
                "    <form action='list' method='get'>\n" +
                "        <input type='submit' value='Full Character List'/>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";

        return HTMLHeader;
    }

    /**
     * Generates HTML for sorted list
     *
     * @param option what kind of sorting is being done
     * @return String of HTML list
     */
    public String sortList(String option) {
        List<Person> peeps;
        switch (option) {
            case "height":
                peeps = repo.getHeightSort();
                break;
            case "mass":
                peeps = repo.getMassSort();
                break;
            case "birthYear":
                peeps = repo.getYearSort();
                break;
            case "name":
            default:
                peeps = repo.getNameSort();
        }

        String HTMLSortContents = "<html>\n";
        for (Person p : peeps)
            HTMLSortContents += "<a href='search?searchName=" + p.getName() + "'>" + p + "</a></br>\n";
        HTMLSortContents += "</html>";

        return HTMLSortContents;

    }
}
