package com.gaudi.model;

/**
 *
 * @author Javier Vergara Lee
 */
public class Tecnica {
    private int id;
    private String tecnica;

    public Tecnica(int id, String tecnica) {
        this.id = id;
        this.tecnica = tecnica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
}
