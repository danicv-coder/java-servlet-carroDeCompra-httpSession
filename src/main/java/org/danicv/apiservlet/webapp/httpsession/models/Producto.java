package org.danicv.apiservlet.webapp.httpsession.models;

public class Producto {
    private Long id;
    private String nombre;
    private String tip;
    private int precio;

    public Producto() {
    }

    public Producto(Long id, String nombre, String tip, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.tip = tip;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
