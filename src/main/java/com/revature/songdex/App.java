package com.revature.songdex;

public class App {
    public static void main(String[] args) {
        CSVDexRepository csvDexRepository = new CSVDexRepository("songs_dataset.csv");
        DexService dexService = new DexService(csvDexRepository);
        SearchFormService searchFormService = new SearchFormService();
        DexServer server = new DexServer(dexService, searchFormService);
        server.run();
    }
}
