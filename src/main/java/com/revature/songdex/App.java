package com.revature.songdex;

public class App {
    public static void main(String[] args) {
        DexRepository dexRepository = new DexRepository("songs_dataset.csv");
        DexService dexService = new DexService(dexRepository);
        SearchFormService searchFormService = new SearchFormService();
        DexServer server = new DexServer(dexService, searchFormService);
        server.run();
    }
}
