/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Objetos {
    private int id;
    private String nombre;
    private int precio;
    private String descripcion;
    private int daño;
    private int armadura;
    private String tipo;

    public Objetos() {
    }

    public Objetos(String nombre, int precio, String descripcion, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Objetos(String nombre, int precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.daño = 0;
        this.armadura = 0;
    }

    public Objetos(String nombre, int precio, String tipo, int daño, int armadura) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.daño = daño;
        this.armadura = armadura;
    }
   
    public Objetos(String nombre, int precio, String tipo, int daño, int armadura, String des) {
        this.nombre = nombre;
        this.precio = precio;
        this.daño = daño;
        this.armadura = armadura;
        this.tipo = tipo;
        this.descripcion = des;
    }

    public Objetos(int id, String nombre, int precio, String descripcion, int daño, int armadura, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.daño = daño;
        this.armadura = armadura;
        this.tipo = tipo;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Objetos{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion + ", da\u00f1o=" + daño + ", armadura=" + armadura + '}';
    }

    public String[] toArrayString(){
        String[] s = new String[7];
        
        s[0] = String.valueOf(id);
        s[1] = nombre;
        s[2] = String.valueOf(precio);
        s[3] = descripcion;
        s[4] = String.valueOf(daño);
        s[5] = String.valueOf(armadura);
        s[6] = String.valueOf(tipo);

        return s;
    }
    
    
}
