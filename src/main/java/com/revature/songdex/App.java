package com.revature.songdex;

import com.revature.songdex.repositories.SWRepo;
import com.revature.songdex.repositories.SWRepoCSV;
import com.revature.songdex.repositories.SWRepoSQL;
import com.revature.songdex.server.SWServer;
import com.revature.songdex.service.SWService;

public class App {
    public static void main(String[] args) {
        String filename = "starwars.csv";
        SWRepo swRepo = new SWRepoCSV(filename);
        //SWRepo swRepo = new SWRepoSQL();
        SWService swService = new SWService(swRepo);
        SWServer server = new SWServer(swService);
        server.run();
    }
}