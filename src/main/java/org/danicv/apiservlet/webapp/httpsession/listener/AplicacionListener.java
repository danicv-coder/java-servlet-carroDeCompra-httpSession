package org.danicv.apiservlet.webapp.httpsession.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.danicv.apiservlet.webapp.httpsession.models.Carro;

@WebListener("/index.html")
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;
    private String nombreCompleto = "Daniel Enrique Calderon Vera";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Iniciando la aplicacion");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mennsaje", "Algun valor global para la aplicacion!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("Destruyendo la aplicacion");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("Destruyendo el request");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Iniciando el request");
        sre.getServletRequest().setAttribute("mensaje", "Guardando un valor para el request");
        sre.getServletRequest().setAttribute("nombreCompleto", nombreCompleto);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Inicilizando la session http");
        Carro carro = new Carro();
        HttpSession session = se.getSession();
        session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la session http");
    }
}
