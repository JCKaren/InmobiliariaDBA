package com.mycompany.Modelo;
public class Cuenta {
    private String nombre;
    private String contrasena;

    public Cuenta() {
    }

    public Cuenta(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }
}

