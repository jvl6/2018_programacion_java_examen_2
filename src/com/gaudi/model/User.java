package com.gaudi.model;

/**
 *
 * @author Javier Vergara Lee
 */
public class User {
    private int id;
    private String usuario;
    private String pass;

    public User() {
    }

    public User(int id, String usuario, String pass) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
