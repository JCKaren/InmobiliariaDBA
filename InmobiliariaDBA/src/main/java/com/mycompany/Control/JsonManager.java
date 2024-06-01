package com.mycompany.Control;

import com.mycompany.Modelo.Cuenta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {

    public void LeerJson() {
        try {
            Gson gson = new GsonBuilder().create();
            FileReader fileReader = new FileReader("cuentas.json");
            Type typeListPerson = new TypeToken<List<Cuenta>>() {
            }.getType();
            List<Cuenta> result = gson.fromJson(fileReader, typeListPerson);
            for (Cuenta c : result) {
                System.out.println("Nombre: " + c.getNombre() + " Contraseña: " + c.getContrasena());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

    public void EscribirJson(Cuenta cuenta) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().setLenient().create();
            FileReader fileReader = new FileReader("cuentas.json");
            Type typeListPerson = new TypeToken<List<Cuenta>>() {
            }.getType();
            List<Cuenta> cuentas = gson.fromJson(fileReader, typeListPerson);
            if (cuentas == null) {
                cuentas = new ArrayList<>();
            }
            cuentas.add(cuenta);
            FileWriter fileWriter = new FileWriter("cuentas.json");
            gson.toJson(cuentas, fileWriter);
            fileWriter.close();
            System.out.println("Cuenta guardada correctamente");
        } catch (IOException e) {
            System.err.println("Error al guardar la cuenta: " + e.getMessage());
        }

    }

    public Boolean BuscarInfo(Cuenta cuenta) {
        try {
            Gson gson = new GsonBuilder().setLenient().create();
            FileReader fileReader = new FileReader("cuentas.json");
            Type typeListPerson = new TypeToken<List<Cuenta>>() {
            }.getType();
            List<Cuenta> result = gson.fromJson(fileReader, typeListPerson);
            return result.stream().anyMatch(c -> c.getNombre().equals(cuenta.getNombre()) && c.getContrasena().equals(cuenta.getContrasena()));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return null;

    }
}
