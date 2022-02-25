package com.revature.songdex.servlet;

import com.revature.songdex.domain.Person;
import com.revature.songdex.service.SWService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ListServlet extends HttpServlet {
    SWService service;

    public ListServlet(SWService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(service.listHeader());
        resp.getWriter().println(service.listContents());
    }
}
