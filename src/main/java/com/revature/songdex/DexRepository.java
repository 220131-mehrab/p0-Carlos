package com.revature.songdex;

import java.util.List;

public interface DexRepository {
    List<Song> getSongs();
    String getSong(String name);
    String getStats(String name);
}
