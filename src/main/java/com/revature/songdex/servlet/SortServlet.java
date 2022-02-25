package com.revature.songdex.servlet;

import com.revature.songdex.service.SWService;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SortServlet extends HttpServlet {
    private SWService service;

    public SortServlet(SWService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String option = req.getParameter("option");

        resp.getWriter().println(service.sortHeader(option));
        resp.getWriter().println(service.sortList(option));
    }
}
