package com.revature.songdex;

import com.revature.songdex.domain.Person;
import com.revature.songdex.repositories.SWRepoCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CSVRepoTest {
    SWRepoCSV repo;

    @Test
    public void loadTest() {
        // should run without errors
        repo = new SWRepoCSV("testDataset.csv");
    }

    @Test
    public void getPeopleTest() {
        repo = new SWRepoCSV("testDataset.csv");

        List<Person> peeps = repo.getAll();
        Person[] peepsArray = new Person[2];
        peeps.toArray(peepsArray);

        Assertions.assertEquals("Carlos", peepsArray[0].getName());
        Assertions.assertEquals("Ray", peepsArray[1].getName());
    }

    @Test
    public void getPersonTest() {
        repo = new SWRepoCSV("testDataset.csv");

        Person p1 = repo.getPerson("Carlos");
        Person p2 = repo.getPerson("Ray");

        Assertions.assertEquals(1, p1.getId());
        Assertions.assertEquals(2, p2.getId());
    }
}