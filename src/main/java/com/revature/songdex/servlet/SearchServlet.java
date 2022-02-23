package com.revature.songdex.servlet;

import com.revature.songdex.domain.Person;
import com.revature.songdex.service.SWService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {
    SWService service;

    public SearchServlet(SWService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getParameter("searchName");
        resp.getWriter().println(service.searchForm());

        List<Person> results = new ArrayList<>();
        if (input != null)
            results.add(service.getPerson(input));
        else
            results.addAll(service.getPerson());

        if (results.size() == 1)
            resp.getWriter().println(service.infoPage(results.get(0)));
        else
            for (Person p : results)
                resp.getWriter().println("<a href='search?searchName=" + p.getName() + "'>" + p + "</a></br>");
    }
}
