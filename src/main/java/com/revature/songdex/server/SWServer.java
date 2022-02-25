package com.revature.songdex.server;

import com.revature.songdex.service.SWService;
import com.revature.songdex.servlet.DefaultServlet;
import com.revature.songdex.servlet.ListServlet;
import com.revature.songdex.servlet.SearchServlet;
import com.revature.songdex.servlet.SortServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class SWServer {
    private Tomcat server;
    private String webAppName;

    /**
     * Creates a Tomcat server and initializes servlets using service provided
     * @param service SWService to use with Search Servlet
     */
    public SWServer(SWService service) {
        this.webAppName = "";

        this.server = new Tomcat();
        this.server.setBaseDir(System.getProperty("java.io.tempdir"));
        this.server.getConnector();
        this.server.addContext(webAppName, null);

        this.server.addServlet(webAppName, "defaultServlet", new DefaultServlet()).addMapping("/*");
        this.server.addServlet(webAppName, "searchServlet", new SearchServlet(service)).addMapping("/search");
        this.server.addServlet(webAppName, "listServlet", new ListServlet(service)).addMapping("/list");
        this.server.addServlet(webAppName, "sortServlet", new SortServlet(service)).addMapping("/sort");
    }

    /**
     * Runs the Tomcat server
     */
    public void run() {
        try {
            this.server.start();
            this.server.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
