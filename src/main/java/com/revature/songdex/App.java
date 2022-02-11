package com.revature.songdex;

public class App {
    public static void main(String[] args) {
        DexRepository dexRepository = new DexRepository("songs_dataset.csv");
        DexService dexService = new DexService(dexRepository);
        DexServer server = new DexServer(dexService);
    }
}
