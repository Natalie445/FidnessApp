/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidnessapp;

import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private String nombreRutina;
    private List<Ejercicio> ejerciciosSeleccionados;

    public Rutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
        this.ejerciciosSeleccionados = new ArrayList<>();
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        ejerciciosSeleccionados.add(ejercicio);
    }

    public String getNombreRutina() {
        return nombreRutina;
    }

    public List<Ejercicio> getEjerciciosSeleccionados() {
        return ejerciciosSeleccionados;
    }
    
    public void mostrarRutina() {
        System.out.println("\n--- Rutina: " + nombreRutina + " ---");
        if (ejerciciosSeleccionados.isEmpty()) {
            System.out.println("No hay ejercicios en esta rutina todavía.");
        } else {
            for (int i = 0; i < ejerciciosSeleccionados.size(); i++) {
                System.out.println((i + 1) + ". " + ejerciciosSeleccionados.get(i));
            }
        }
    }
}
