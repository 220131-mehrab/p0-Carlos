package com.revature.songdex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class CSVDexRepositoryTest {
    CSVDexRepository csvDexRepository = new CSVDexRepository("testDataset.csv");

    @Test
    public void testGetSongs() {
        List<Song> songs = csvDexRepository.getSongs();
        Song[] songArray = new Song[2];
        songs.toArray(songArray);

        Assertions.assertEquals("Yo", songArray[0].getSongName());
        Assertions.assertEquals("This", songArray[1].getSongName());
    }

    @Test
    public void testSortSongs() {
        List<Song> songs = csvDexRepository.getSongs();

        songs.sort(null);

        System.out.println(songs);
    }

    @Test
    public void comparatorTest() {
        List<Song> songs = csvDexRepository.getSongs();

        /*songs.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                int songIdCompare = o1.getSongId().compareTo(o2.getSongId());
                int artistIdCompare = o1.getArtistId().compareTo(o2.getArtistId());

                if (songIdCompare == 0)
                    return artistIdCompare;
                else
                    return songIdCompare;
            }
        });*/

        // (o1, o2) -> {}
        songs.sort((o1, o2) -> {
            int songIdCompare = o1.getSongId().compareTo(o2.getSongId());
            int artistIdCompare = o1.getArtistId().compareTo(o2.getArtistId());

            if (songIdCompare == 0)
                return artistIdCompare;
            else
                return songIdCompare;});

        System.out.println(songs);
    }
}
