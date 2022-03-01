package com.revature.songdex;

import com.revature.songdex.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    public void equalsTest() {
        Person p1 = Person.builder()
                .id("1")
                .name("Carlos")
                .mass("190");

        Person p2 = Person.builder()
                .id("1")
                .name("Carlos")
                .mass("12");

        Person p3 = Person.builder()
                .id("3")
                .name("Carlos")
                .mass("190");

        // First two should be equal, second two shouldn't
        Assertions.assertEquals(p1, p2);
        Assertions.assertNotEquals(p1, p3);
    }

    @Test
    public void formatTest() {
        Person p1 = Person.builder()
                .id("1")
                .name("Carlos")
                .mass("190");

        String expected = "  1 - Carlos";

        Assertions.assertEquals(expected, p1.toStringFormat());
    }
}
