package com.revature.songdex.domain;

import java.util.Objects;

public class Song implements Comparable<Song> {
    private String songId, songName, artistId, artistName, popularity, explicit, songType, trackNumber, numArtists, numAvailableMarkets, releaseDate, durationMs, key, mode, timeSignature, acousticness, danceability, energy, instrumentalness, liveness, loudness, speechiness, valence, tempo;

    public static Song fromLine(String line) {
        String[] columns = line.split("\t");

        Song newSong = new Song();

        newSong.songId = columns[0];
        newSong.songName = columns[1];
        newSong.artistId = columns[2];
        newSong.artistName = columns[3];
        newSong.popularity = columns[4];
        newSong.explicit = columns[5];
        newSong.songType = columns[6];
        newSong.trackNumber = columns[7];
        newSong.numArtists = columns[8];
        newSong.numAvailableMarkets = columns[9];
        newSong.releaseDate = columns[10];
        newSong.durationMs = columns[11];
        newSong.key = columns[12];
        newSong.mode = columns[13];
        newSong.timeSignature = columns[14];
        newSong.acousticness = columns[15];
        newSong.danceability = columns[16];
        newSong.energy = columns[17];
        newSong.instrumentalness = columns[18];
        newSong.liveness = columns[19];
        newSong.loudness = columns[20];
        newSong.speechiness = columns[21];
        newSong.valence = columns[22];
        newSong.tempo = columns[23];

        return newSong;
    }

    // Builder and related methods
    public static Song songBuilder() {
        return new Song();
    }

    public Song songId(String id) {
        this.songId = id;
        return this;
    }

    public Song songName(String name) {
        this.songName = name;
        return this;
    }

    public Song artistId(String id) {
        this.artistId = id;
        return this;
    }

    public Song artistName(String name) {
        this.artistName = name;
        return this;
    }

    public Song() {
    }

    public void setSongId(String id) {
        this.songId = id;
    }

    public void setSongName(String name) {
        this.songName = name;
    }

    public void setArtistId(String id) {
        this.artistId = id;
    }

    public void setArtistName(String name) {
        this.artistName = name;
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