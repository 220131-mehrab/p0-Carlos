package com.revature.songdex;

import com.revature.songdex.domain.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SongTest {

    @Test
    public void songNameTest() {
        Song song = new Song();
        song.setSongName("testSong");
        String actual = song.getSongName();

        // Tests default constructor, setSongName, and getSongName
        Assertions.assertEquals("testSong", actual);
    }

    @Test
    public void songEqualsTest() {
        // Dummy line to initialize the
        String testLine1 = "1\tYo\t2\tMama\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t ";
        Song song1 = Song.fromLine(testLine1);

        String testLine2 = "2\tThat\t1\tB\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t ";
        Song song2 = Song.fromLine(testLine2);

        Song song3 = Song.fromLine(testLine1);

        // Test the equals method
        boolean match1 = song1.equals(song2);
        boolean match2 = song1.equals(song3);

        Assertions.assertEquals(false, match1);
        Assertions.assertEquals(true, match2);
    }
}
