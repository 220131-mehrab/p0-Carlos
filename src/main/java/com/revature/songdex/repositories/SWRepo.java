package com.revature.songdex.repositories;

import com.revature.songdex.domain.Person;

import java.util.List;

/**
 * SWRepo is an interface outlining the requirements of a Star Wars Repository class
 */
public interface SWRepo {

    /**
     * get all Person objects in the repository
     * @return Returns a list of Person objects
     */
    List<Person> getAll();

    /**
     * get a Person object in the repository based on name
     * @param name name of Person object to search with
     * @return Person object with matching name field, returns null if none found
     */
    Person getPerson(String name);
}
