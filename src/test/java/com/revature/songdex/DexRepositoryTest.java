package com.revature.songdex;

import com.revature.songdex.domain.Song;
import com.revature.songdex.respositories.CSVDexRepository;
import com.revature.songdex.respositories.SQLDexRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DexRepositoryTest {
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

    @Test
    public void getSQLSongTest() {
        SQLDexRepository testRepo = new SQLDexRepository();
        Song actual = testRepo.getSong("Big Iron");

        Song expected = Song.songBuilder()
                .songId("1")
                .songName("Big Iron")
                .artistId("1")
                .artistName("Marty Robbins");

        Assertions.assertEquals(expected, actual);
    }
}
