package com.gaudi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier Vergara Lee
 */
public class Data {

    private final Conexion con;

    public Data() throws ClassNotFoundException, SQLException {
        this.con = new Conexion("localhost", "bd_gaudi", "root", "");
    }

    public User encontrarUsuario(String user) throws SQLException {
        String query = "SELECT * FROM usuario WHERE usuario = '" + user + "';";
        ResultSet rs = con.ejecutarSelect(query);
        User u = null;

        while (rs.next()) {
            u = new User();
            u.setId(rs.getInt(1));
            u.setUsuario(rs.getString(2));
            u.setPass(rs.getString(3));
        }

        con.close();

        return u;
    }

    public User loginUser(String user, String pass) throws SQLException {
        String query = "SELECT * FROM usuario WHERE usuario = '" + user + "' AND pass = '" + pass + "';";
        ResultSet rs = con.ejecutarSelect(query);
        User u = null;

        while (rs.next()) {
            u = new User();
            u.setId(rs.getInt(1));
            u.setUsuario(rs.getString(2));
            u.setPass(rs.getString(3));
        }

        con.close();

        return u;
    }

    public String getPass(String user) throws SQLException {
        String query = "SELECT * FROM usuario WHERE usuario = '" + user + "';";
        ResultSet rs = con.ejecutarSelect(query);

        String pass = null;
        while (rs.next()) {
            pass = rs.getString(3);
        }

        con.close();

        return pass;
    }

    public List<Autor> selectAutor() throws SQLException {
        String query = "SELECT * FROM autor;";
        ResultSet rs = con.ejecutarSelect(query);

        List<Autor> a = new ArrayList<>();

        while (rs.next()) {
            Autor au = new Autor(rs.getInt(1), rs.getString(2));
            a.add(au);
        }

        return a;
    }

    public List<Tecnica> selectTecnica() throws SQLException {
        String query = "SELECT * FROM tecnica;";
        ResultSet rs = con.ejecutarSelect(query);

        List<Tecnica> t = new ArrayList<>();

        while (rs.next()) {
            Tecnica te = new Tecnica(rs.getInt(1), rs.getString(2));
            t.add(te);
        }

        return t;
    }

    public List<Genero> selectGenero() throws SQLException {
        String query = "SELECT * FROM genero;";
        ResultSet rs = con.ejecutarSelect(query);

        List<Genero> g = new ArrayList<>();

        while (rs.next()) {
            Genero ge = new Genero(rs.getInt(1), rs.getString(2));
            g.add(ge);
        }

        return g;
    }

    public List<Sala> selectSala() throws SQLException {
        String query = "SELECT * FROM sala;";
        ResultSet rs = con.ejecutarSelect(query);

        List<Sala> s = new ArrayList<>();

        while (rs.next()) {
            Sala sa = new Sala(rs.getInt(1), rs.getString(2), rs.getInt(3),
                    rs.getFloat(4), rs.getBoolean(5), rs.getBoolean(6), rs.getString(7));
            s.add(sa);
        }

        return s;
    }

    public List<ViewObra> viewObra() throws SQLException {
        String query = "SELECT * FROM viewObra;";
        ResultSet rs = con.ejecutarSelect(query);

        List<ViewObra> o = new ArrayList<>();

        while (rs.next()) {
            ViewObra v = new ViewObra(rs.getInt(1), rs.getString(2), rs.getInt(3),
                    rs.getFloat(4), rs.getFloat(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9));
            o.add(v);
        }

        return o;
    }

    public void createObra(int codigo, String nombre, int anio, float alto,
            float ancho, String tecnica, String genero, String autor, String sala) throws SQLException {

        String query = "CALL crearObra (" + codigo + ",'"
                + nombre + "','"
                + anio + "',"
                + alto + ","
                + ancho + ",'"
                + tecnica + "','"
                + genero + "','"
                + autor + "','"
                + sala + "');";
        con.ejecutar(query);
        con.close();
    }

    public void deleteObra(int codigo) throws SQLException {
        String query = "DELETE FROM obra WHERE codigo = " + codigo + ";";
        con.ejecutar(query);
        con.close();
    }

    public List<ViewObra> filterObraSala(String sala) throws SQLException {
        String query = "SELECT * FROM viewObra WHERE nombreSala = '" + sala + "';";
        ResultSet rs = con.ejecutarSelect(query);

        List<ViewObra> o = new ArrayList<>();

        while (rs.next()) {
            ViewObra v = new ViewObra(rs.getInt(1), rs.getString(2), rs.getInt(3),
                    rs.getFloat(4), rs.getFloat(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9));
            o.add(v);
        }

        return o;
    }

    public List<ViewObra> filterObraNombre(String nombre) throws SQLException {
        String query = "SELECT * FROM viewObra WHERE nombreObra LIKE '%" + nombre + "%';";
        ResultSet rs = con.ejecutarSelect(query);

        List<ViewObra> o = new ArrayList<>();

        while (rs.next()) {
            ViewObra v = new ViewObra(rs.getInt(1), rs.getString(2), rs.getInt(3),
                    rs.getFloat(4), rs.getFloat(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9));
            o.add(v);
        }

        return o;
    }

    public List<ViewObra> filterObraNombreSala(String nombre, String sala) throws SQLException {
        String query = "SELECT * FROM viewObra WHERE nombreObra LIKE '%" + nombre + "%' AND nombreSala = '" + sala + "';";
        ResultSet rs = con.ejecutarSelect(query);

        List<ViewObra> o = new ArrayList<>();

        while (rs.next()) {
            ViewObra v = new ViewObra(rs.getInt(1), rs.getString(2), rs.getInt(3),
                    rs.getFloat(4), rs.getFloat(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9));
            o.add(v);
        }

        return o;
    }
}
