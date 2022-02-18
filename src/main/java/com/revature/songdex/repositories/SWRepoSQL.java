package com.revature.songdex.repositories;

import com.revature.songdex.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SWRepoSQL implements SWRepo {

    @Override
    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = conn.createStatement();
            String query = "select * from people";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                people.add(Person.builder()
                        .id(resultSet.getString("id"))
                        .name(resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    @Override
    public Person getPerson(String name) {
        Person result = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = conn.createStatement();
            String query = "select * from people where name = '" + name + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = Person.builder()
                        .id(resultSet.getString("id"))
                        .name(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
