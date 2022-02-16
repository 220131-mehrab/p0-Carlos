package com.revature.songdex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDexRepository implements DexRepository{
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
            this.songs.add(new Song(line));
            line = bufferedReader.readLine();
        }
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getSong(String name) {
        for (Song song : this.songs) {
            if (song.getSongName().equals(name)) {
                return song.toString();
            }
        }

        return "";
    }

    //Returns a line with relevant song statistics
    public String getStats(String name) {
        for (Song song : this.songs) {
            if (song.getSongName().equals(name))
                return song.HTMLStats();
        }
        return "";
    }
}
