package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = "/navigation")
public class NavigationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String navLink = (String) req.getAttribute("navLink");

        HashMap<String, String> links = new HashMap<String, String>();
        links.put("main", "Main");
        links.put("catalog", "Catalog");
        links.put("product", "Product");
        links.put("cart", "Cart");
        links.put("order", "Order");

        resp.getWriter().println("<h1>" + navLink + "</h1>");

        for (String i : links.keySet()) {
            if (navLink.equals(i))
                resp.getWriter().println("<b>" + links.get(i) + "</b>");
            else
                resp.getWriter().println("<a href='/first-web-app/" + i + "'>" + links.get(i) + "</a>");
        }
    }
}
