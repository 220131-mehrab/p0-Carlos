package com.revature.songdex;

import com.revature.songdex.respositories.DexRepository;
import com.revature.songdex.respositories.SQLDexRepository;
import com.revature.songdex.server.DexServer;
import com.revature.songdex.servlet.DexServlet;
import com.revature.songdex.service.SongDexService;

public class App {
    public static void main(String[] args) {
        //CSVDexRepository csvDexRepository = new CSVDexRepository("songs_dataset.csv");
        DexRepository sqlRepo = new SQLDexRepository();
        SongDexService service = new SongDexService(sqlRepo);
        DexServlet dexServlet = new DexServlet(service);
        DexServer server = new DexServer(dexServlet, service);
        server.run();
    }
}
