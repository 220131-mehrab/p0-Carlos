package com.revature.songdex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DexRepositoryTest {
    DexRepository dexRepository = new DexRepository("testDataset.csv");

    @Test
    public void testGetSongs() {
        List<Song> songs = dexRepository.getSongs();
        Song[] songArray = new Song[2];
        songs.toArray(songArray);

        Assertions.assertEquals("Yo", songArray[0].getSongName());
        Assertions.assertEquals("This", songArray[1].getSongName());
    }
}
