/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidnessapp;

/**
 *
 * @author quesa
 */
    public class Administrador extends Persona {
    public Administrador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Administrador del Sistema");
    }
}
