package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/main"})
public class MainHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("navLink", "main");
        getServletContext().getRequestDispatcher("/navigation").include(req, resp);

        resp.getWriter().println("<p>Main page</p>");

    }

}
