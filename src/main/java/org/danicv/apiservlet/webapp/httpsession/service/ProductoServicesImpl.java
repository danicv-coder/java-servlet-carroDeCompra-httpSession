package org.danicv.apiservlet.webapp.httpsession.service;

import org.danicv.apiservlet.webapp.httpsession.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServicesImpl implements ProductoService {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "Computacion", 175000),
                new Producto(2L, "mesa de escritorio", "oficina", 8000),
                new Producto(3L, "teclado mecanico", "computacion", 4000));

    }

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream().filter(p -> p.getId().equals(id)).findAny();
    }
}
