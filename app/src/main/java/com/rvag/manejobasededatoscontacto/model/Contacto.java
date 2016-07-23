package com.rvag.manejobasededatoscontacto.model;

import java.util.PriorityQueue;

/**
 * Created by Robert on 23/07/2016.
 */
public class Contacto {
    private  int Id;
    private String nombre;
    private String email;
    private String twitter;

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacto(int id, String nombre, String email, String twitter) {
        Id = id;
        this.nombre = nombre;
        this.email = email;
        this.twitter = twitter;
    }

}
