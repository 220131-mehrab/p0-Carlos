package com.revature.songdex;

import java.util.Objects;

public class Song implements Comparable<Song>{
    private String songId, songName, artistId, artistName, popularity, explicit, songType, trackNumber, numArtists, numAvailableMarkets, releaseDate, durationMs, key, mode, timeSignature, acousticness, danceability, energy, instrumentalness, liveness, loudness, speechiness, valence, tempo;

    public Song(String line) {
        String[] columns = line.split("\t");

        this.songId = columns[0];
        this.songName = columns[1];
        this.artistId = columns[2];
        this.artistName = columns[3];
        this.popularity = columns[4];
        this.explicit = columns[5];
        this.songType = columns[6];
        this.trackNumber = columns[7];
        this.numArtists = columns[8];
        this.numAvailableMarkets = columns[9];
        this.releaseDate = columns[10];
        this.durationMs = columns[11];
        this.key = columns[12];
        this.mode = columns[13];
        this.timeSignature = columns[14];
        this.acousticness = columns[15];
        this.danceability = columns[16];
        this.energy = columns[17];
        this.instrumentalness = columns[18];
        this.liveness = columns[19];
        this.loudness = columns[20];
        this.speechiness = columns[21];
        this.valence = columns[22];
        this.tempo = columns[23];
    }

    public Song() {}

    public void setSongName(String name) {
        this.songName = name;
    }

    @Override
    public String toString() {
        return this.songName + " - " + this.artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    public String HTMLStats() {
        String HTMLStats = "<html>\n" +
                "    <head>\n" +
                "        <title>\"" + this.songName + "\" Statistics</title>\n" +
                "    " +
                "</head>\n" +
                "    <body>\n" +
                "        <h1>" + this + "</h1>\n" +
                "        <h4>Popularity: " + this.popularity + "</h4>\n" +
                "        <h4>Release Date: " + this.releaseDate + "</h4>\n" +
                "        <h4>Tempo: " + this.tempo + "</h4>\n" +
                "    </body>\n" +
                "</html>";

        return HTMLStats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songName.equals(song.songName) && artistName.equals(song.artistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, artistName);
    }

    public String getArtistId() {
        return this.artistId;
    }

    public String getSongId() {
        return this.songId;
    }

    @Override
    public int compareTo(Song o) {
        return this.toString().compareTo(o.toString());
    }
}