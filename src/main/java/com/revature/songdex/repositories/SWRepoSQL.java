package com.revature.songdex.repositories;

import com.revature.songdex.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SWRepoSQL implements SWRepo {
    Connection conn;
    Statement stmt;

    public SWRepoSQL() {
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            stmt = conn.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();
        try {
            String query = "select * from people";
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                people.add(Person.builder()
                        .id(resultSet.getString("id"))
                        .name(resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return people;
    }

    @Override
    public Person getPerson(String name) {
        Person result = null;
        try {
            String query = "select * from people where name = '" + name + "'";
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                result = Person.builder()
                        .id(resultSet.getString("id"))
                        .name(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Person> getHeightSort() {
        List<Person> people = new ArrayList<>();

        try {
            String query = "select * from people where height != -1 order by height";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                Person p = Person.builder()
                        .id(results.getString("id"))
                        .name(results.getString("name"))
                        .height(results.getString("height"));

                people.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public List<Person> getMassSort() {
        List<Person> people = new ArrayList<>();

        try {
            String query = "select * from people where mass != -1 order by mass";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                Person p = Person.builder()
                        .id(results.getString("id"))
                        .name(results.getString("name"))
                        .mass(results.getString("mass"));

                people.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public List<Person> getYearSort() {
        List<Person> people = new ArrayList<>();

        try {
            String query = "select * from people where birthyear != -1 order by birthyear desc";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                Person p = Person.builder()
                        .id(results.getString("id"))
                        .name(results.getString("name"))
                        .birthYear(results.getString("birthyear"));

                people.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public List<Person> getNameSort() {
        List<Person> people = new ArrayList<>();

        try {
            String query = "select * from people order by name";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                Person p = Person.builder()
                        .id(results.getString("id"))
                        .name(results.getString("name"));

                people.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return people;
    }
}
