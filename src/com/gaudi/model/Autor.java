package com.gaudi.model;

/**
 *
 * @author Javier Vergara Lee
 */
public class Autor {
    private int id;
    private String nombreAutor;

    public Autor() {
    }

    public Autor(int id, String nombreAutor) {
        this.id = id;
        this.nombreAutor = nombreAutor;
    }

    public int getId() {
        return id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }
}
