package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class NotFoundServlet implements Servlet {

    private static final Logger logger = LoggerFactory.getLogger(NotFoundServlet.class);
    private  ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("NotFoundServlet is initialized");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("Request in NotFoundServlet");
        res.getWriter().println("Not Found");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
