package com.revature.songdex.servlet;

import com.revature.songdex.domain.Song;
import com.revature.songdex.service.SongDexService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DexServlet extends HttpServlet {
    SongDexService service;

    public DexServlet(SongDexService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput;
        userInput = req.getParameter("searchName");

        resp.getWriter().println(service.searchForm());

        List<Song> results = new ArrayList<>();
        if (userInput != null) {
            results.add(service.getSong(userInput));
        } else {
            results.addAll(service.getSong());
        }

        resp.getWriter().println(results);
    }
}
