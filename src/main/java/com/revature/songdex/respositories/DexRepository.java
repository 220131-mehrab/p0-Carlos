package com.revature.songdex.respositories;

import com.revature.songdex.domain.Song;

import java.util.List;

public interface DexRepository {
    List<Song> getSongs();
    Song getSong(String name);
    String getStats(String name);
}
