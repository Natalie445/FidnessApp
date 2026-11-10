/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidnessapp;

public class Ejercicio {
    private String nombre;
    private String grupoMuscular;
    private String descripcionEjecucion;

    public Ejercicio(String nombre, String grupoMuscular, String descripcionEjecucion) {
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.descripcionEjecucion = descripcionEjecucion;
    }

    public String getNombre() { return nombre; }
    public String getGrupoMuscular() { return grupoMuscular; }
    public String getDescripcionEjecucion() { return descripcionEjecucion; }

    @Override
    public String toString() {
        return "[" + grupoMuscular.toUpperCase() + "] " + nombre + " -> " + descripcionEjecucion;
    }
}