package com.revature.songdex.respositories;

import com.revature.songdex.domain.Song;

import java.sql.*;
import java.util.List;

public class SQLDexRepository implements DexRepository {
    @Override
    public List<Song> getSongs() {
        return null;
    }

    @Override
    public Song getSong(String name) {
        Song result = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            String query = "select * from songs where songName = '" + name + "'";
            Statement statement = conn.createStatement();
            statement.execute(query);

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                result = Song.songBuilder()
                        .songId(resultSet.getString("songId"))
                        .songName(resultSet.getString("songName"))
                        .artistId(resultSet.getString("artistId"))
                        .artistName(resultSet.getString("artistName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String getStats(String name) {
        Song targetSong = getSong(name);
        if (targetSong != null) return targetSong.HTMLStats();
        else return "";
    }
}
