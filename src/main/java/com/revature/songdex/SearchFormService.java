package com.revature.songdex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchFormService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String HTMLForm = "<html>\n" +
                "<head><Title>Search SongDex</Title></head>\n" +
                "<body>\n" +
                "    <form action='/list' method='get'>\n" +
                "<input type='name' name='searchName'/>\n" +
                "        \n" +
                "    " +
                "   <input type='submit' value='Search'>\n" +
                "        " +
                "</body>\n" +
                "\n" +
                "</html>";

        resp.getWriter().println(HTMLForm);
    }
}
