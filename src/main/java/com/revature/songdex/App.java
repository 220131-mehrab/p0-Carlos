package com.revature.songdex;

import com.revature.songdex.respositories.CSVDexRepository;
import com.revature.songdex.server.DexServer;
import com.revature.songdex.servlet.DexService;
import com.revature.songdex.servlet.SearchFormService;

public class App {
    public static void main(String[] args) {
        CSVDexRepository csvDexRepository = new CSVDexRepository("songs_dataset.csv");
        DexService dexService = new DexService(csvDexRepository);
        SearchFormService searchFormService = new SearchFormService();
        DexServer server = new DexServer(dexService, searchFormService);
        server.run();
    }
}
