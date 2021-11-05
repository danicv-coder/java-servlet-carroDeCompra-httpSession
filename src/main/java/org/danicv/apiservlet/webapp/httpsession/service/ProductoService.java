package org.danicv.apiservlet.webapp.httpsession.service;

import org.danicv.apiservlet.webapp.httpsession.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
}
