package org.danicv.apiservlet.webapp.httpsession.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.danicv.apiservlet.webapp.httpsession.service.LoginService;
import org.danicv.apiservlet.webapp.httpsession.service.LoginServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()) {
            Cookie cookie = new Cookie("username", "");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);

        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
