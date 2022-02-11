package com.revature.songdex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DexRepository {
    private List<String> songs;
    private InputStreamReader fileReader;
    private BufferedReader bufferedReader;
    private InputStream file;


    public DexRepository(String filename) {
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
            this.songs.add(line);
            line = bufferedReader.readLine();
        }
    }

    public List<String> getSongs() {
        return songs;
    }
}
