package ru.mmtr.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TranslateToJsp extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp, String s) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("vocabulares.jsp");
        req.setAttribute("req", s);
    }


}
