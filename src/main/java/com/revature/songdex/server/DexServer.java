package com.revature.songdex.server;

import com.revature.songdex.servlet.DefaultServlet;
import com.revature.songdex.servlet.DexServlet;
import com.revature.songdex.service.SongDexService;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class DexServer {
    private Tomcat server;

    public DexServer(DexServlet dexServlet, SongDexService songDexService) {
        String webAppName = "";

        this.server = new Tomcat();
        this.server.setBaseDir(System.getProperty("java.io.tmpdir"));
        this.server.getConnector();
        this.server.addContext(webAppName, null);

        this.server.addServlet(webAppName, "defaultServlet", new DefaultServlet()).addMapping("/*");
        this.server.addServlet(webAppName, "dexServlet", dexServlet).addMapping("/list");
    }

    public void run() {
        try {
            this.server.start();
            this.server.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
