package com.gaudi.model;

/**
 *
 * @author Javier Vergara Lee
 */
public class ViewObra {
    private int codigo;
    private String nombreObra;
    private int anio;
    private float alto;
    private float ancho;
    private String tecnica;
    private String genero;
    private String nombreAutor;
    private String nombreSala;

    public ViewObra(int codigo, String nombreObra, int anio, float alto, float ancho, String tecnica, String genero, String nomrbeAutor, String nombreSala) {
        this.codigo = codigo;
        this.nombreObra = nombreObra;
        this.anio = anio;
        this.alto = alto;
        this.ancho = ancho;
        this.tecnica = tecnica;
        this.genero = genero;
        this.nombreAutor = nomrbeAutor;
        this.nombreSala = nombreSala;
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

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
}
