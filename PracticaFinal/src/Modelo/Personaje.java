/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author usuario
 */
public class Personaje {

   private int id;
   private String nombre;
   private String clase;
   private int puntosvida;
   private int puntosmana;
   private int puntosarmadura;
   private int puntosdanyo;
   private int dinero;

    public Personaje() {
        
    }

    public Personaje(int id, String nombre, String clase, int puntosvida, int puntosmana, int puntosarmadura, int puntosdanyo, int dinero) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.puntosvida = puntosvida;
        this.puntosmana = puntosmana;
        this.puntosarmadura = puntosarmadura;
        this.puntosdanyo = puntosdanyo;
        this.dinero = dinero;
    }

    public Personaje(String nombre, String clase, int puntosvida, int puntosmana, int puntosarmadura, int puntosdanyo, int dinero) {
        this.nombre = nombre;
        this.clase = clase;
        this.puntosvida = puntosvida;
        this.puntosmana = puntosmana;
        this.puntosarmadura = puntosarmadura;
        this.puntosdanyo = puntosdanyo;
        this.dinero = dinero;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getPuntosvida() {
        return puntosvida;
    }

    public void setPuntosvida(int puntosvida) {
        this.puntosvida = puntosvida;
    }

    public int getPuntosmana() {
        return puntosmana;
    }

    public void setPuntosmana(int puntosmana) {
        this.puntosmana = puntosmana;
    }

    public int getPuntosarmadura() {
        return puntosarmadura;
    }

    public void setPuntosarmadura(int puntosarmadura) {
        this.puntosarmadura = puntosarmadura;
    }

    public int getPuntosdanyo() {
        return puntosdanyo;
    }

    public void setPuntosdanyo(int puntosdanyo) {
        this.puntosdanyo = puntosdanyo;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
   
    @Override
    public String toString() {
        return "Personaje{" + "id=" + id + ", nombre=" + nombre + ", clase=" + clase + ", puntosvida=" + puntosvida + ", puntosmana=" + puntosmana + ", puntosarmadura=" + puntosarmadura + ", puntosdanyo=" + puntosdanyo + ", dinero=" + dinero + '}';
    }

  
}
