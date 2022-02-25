package com.revature.songdex.servlet;

import com.revature.songdex.domain.Person;
import com.revature.songdex.service.SWService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    SWService service;

    public ListServlet(SWService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> people;

        people = service.getPerson();

        resp.getWriter().println(service.listHeader());
        for (Person p : people)
            resp.getWriter().println("<a href='search?searchName=" + p.getName() + "'>" + p + "</a></br>");
    }
}
