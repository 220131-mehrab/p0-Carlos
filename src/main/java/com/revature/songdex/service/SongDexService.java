package com.revature.songdex.service;


import com.revature.songdex.domain.Song;
import com.revature.songdex.respositories.DexRepository;

import java.util.List;

public class SongDexService {
    private DexRepository dexRepo;

    public SongDexService(DexRepository dexRepo) {
        this.dexRepo = dexRepo;
    }

    public String searchForm() {
        String HTMLForm = "<html>\n" +
                "<head><Title>Search SongDex</Title></head>\n" +
                "<body>\n" +
                "    <form action='/list' method='get'>\n" +
                "<input type='name' name='searchName'/>\n" +
                "        \n" +
                "    " +
                "   <input type='submit' value='Search'>\n" +
                "        " +
                "</body>\n" +
                "\n" +
                "</html>";

        return HTMLForm;
    }

    public List<Song> getSong() {
        return dexRepo.getSongs();
    }

    public Song getSong(String input) {
        return dexRepo.getSong(input);
    }
}
