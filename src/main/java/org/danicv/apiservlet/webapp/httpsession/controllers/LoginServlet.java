package org.danicv.apiservlet.webapp.httpsession.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.danicv.apiservlet.webapp.httpsession.service.LoginService;
import org.danicv.apiservlet.webapp.httpsession.service.LoginServiceImpl;
import org.danicv.apiservlet.webapp.httpsession.service.LoginServiceSessionImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> sessionOptional = auth.getUsername(req);
        if (sessionOptional.isPresent()) {
            resp.setContentType("text/html");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!Doctype html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Login</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Bienvenido " + sessionOptional.get() + " has iniciado sesión con éxito!</h1>");
                out.println("         <p><a href='" + req.getContextPath() + "/index.html'>Volver</a></p>");
                out.println("         <p><a href='" + req.getContextPath() + "/logout'>Cerrar sesión</a></p>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp); // esto es  para mostrar la interfaz de login.jsp
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            // Cookie usernameCookie = new Cookie("username", username);
            //resp.addCookie(usernameCookie);
            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no tiene autorización para ingresar en la pagina!");
        }
    }
}
