package org.danicv.apiservlet.webapp.httpsession.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.danicv.apiservlet.webapp.httpsession.models.Carro;
import org.danicv.apiservlet.webapp.httpsession.models.ItemCarro;
import org.danicv.apiservlet.webapp.httpsession.models.Producto;
import org.danicv.apiservlet.webapp.httpsession.service.ProductoService;
import org.danicv.apiservlet.webapp.httpsession.service.ProductoServicesImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregaCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        ProductoService service = new ProductoServicesImpl();
        Optional<Producto> producto = service.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            HttpSession session = req.getSession();
            Carro carro = (Carro) session.getAttribute("carro");
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/carro/ver");
    }
}
