package com.gaudi.model;

/**
 *
 * @author Javier Vergara Lee
 */
public class Sala {
    private int id;
    private String nombreSala;
    private int lamparas;
    private float temperatura;
    private boolean cierreCentralizado;
    private boolean alarmaIncendio;
    private String fk_encargado;

    public Sala(int id, String nombreSala, int lamparas, float temperatura, boolean cierreCentralizado, boolean alarmaIncendio, String fk_encargado) {
        this.id = id;
        this.nombreSala = nombreSala;
        this.lamparas = lamparas;
        this.temperatura = temperatura;
        this.cierreCentralizado = cierreCentralizado;
        this.alarmaIncendio = alarmaIncendio;
        this.fk_encargado = fk_encargado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getLamparas() {
        return lamparas;
    }

    public void setLamparas(int lamparas) {
        this.lamparas = lamparas;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isCierreCentralizado() {
        return cierreCentralizado;
    }

    public void setCierreCentralizado(boolean cierreCentralizado) {
        this.cierreCentralizado = cierreCentralizado;
    }

    public boolean isAlarmaIncendio() {
        return alarmaIncendio;
    }

    public void setAlarmaIncendio(boolean alarmaIncendio) {
        this.alarmaIncendio = alarmaIncendio;
    }

    public String getFk_encargado() {
        return fk_encargado;
    }

    public void setFk_encargado(String fk_encargado) {
        this.fk_encargado = fk_encargado;
    }
    
    
}
