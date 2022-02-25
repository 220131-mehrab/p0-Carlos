package com.revature.songdex.servlet;

import com.revature.songdex.domain.Person;
import com.revature.songdex.service.SWService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchServlet extends HttpServlet {
    SWService service;

    public SearchServlet(SWService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getParameter("searchName");
        resp.getWriter().println(service.searchForm());

        Person person = service.getPerson(input);

        resp.getWriter().println(service.infoPage(person));
    }
}
