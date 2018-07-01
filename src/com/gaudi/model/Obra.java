package com.gaudi.model;

/**
 *
 * @author Javier Vergara Lee
 */
public class Obra {
    private int codigo;
    private String nombreObra;
    private int anio;
    private float alto;
    private float ancho;
    private int fk_tecnica;
    private int fk_genero;
    private int fk_autor;
    private int fk_sala;

    public Obra(int codigo, String nombreObra, int anio, float alto, float ancho, int fk_tecnica, int fk_genero, int fk_autor, int fk_sala) {
        this.codigo = codigo;
        this.nombreObra = nombreObra;
        this.anio = anio;
        this.alto = alto;
        this.ancho = ancho;
        this.fk_tecnica = fk_tecnica;
        this.fk_genero = fk_genero;
        this.fk_autor = fk_autor;
        this.fk_sala = fk_sala;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public int getFk_tecnica() {
        return fk_tecnica;
    }

    public void setFk_tecnica(int fk_tecnica) {
        this.fk_tecnica = fk_tecnica;
    }

    public int getFk_genero() {
        return fk_genero;
    }

    public void setFk_genero(int fk_genero) {
        this.fk_genero = fk_genero;
    }

    public int getFk_autor() {
        return fk_autor;
    }

    public void setFk_autor(int fk_autor) {
        this.fk_autor = fk_autor;
    }

    public int getFk_sala() {
        return fk_sala;
    }

    public void setFk_sala(int fk_sala) {
        this.fk_sala = fk_sala;
    }
}
