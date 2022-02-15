package com.revature.songdex;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class DexServer {
    private Tomcat server;

    public DexServer(DexService dexService, SearchFormService searchFormService) {
        this.server = new Tomcat();
        this.server.setBaseDir(System.getProperty("java.io.tmpdir"));
        this.server.getConnector();
        this.server.addContext("", null);

        this.server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
        this.server.addServlet("", "dexServlet", dexService).addMapping("/list");
        this.server.addServlet("", "searchFormServlet", searchFormService).addMapping("/search");
    }

    public void run() {
        try {
            this.server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
