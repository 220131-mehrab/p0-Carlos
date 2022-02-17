package com.revature.songdex.respositories;

import com.revature.songdex.domain.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDexRepository implements DexRepository {
    private List<Song> songs;
    private InputStream file;
    private InputStreamReader fileReader;
    private BufferedReader bufferedReader;


    public CSVDexRepository(String filename) {
        this.songs = new ArrayList<>();
        try {
            this.file = getClass().getClassLoader().getResourceAsStream(filename);
            this.fileReader = new InputStreamReader(file);
            this.bufferedReader = new BufferedReader(fileReader);
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() throws IOException {
        bufferedReader.readLine();
        String line = bufferedReader.readLine();

        while (line != null) {
            this.songs.add(Song.fromLine(line));
            line = bufferedReader.readLine();
        }
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Song getSong(String name) {
        for (Song song : this.songs) {
            if (song.getSongName().equals(name)) {
                return song;
            }
        }

        return null;
    }

    //Returns a line with relevant song statistics
    public String getStats(String name) {
        Song targetSong = getSong(name);
        if (targetSong != null) return targetSong.HTMLStats();
        else return "";
    }
}
