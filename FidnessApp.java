/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fidnessapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FidnessApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Map<String, Persona> usuarios = new HashMap<>();
        List<Ejercicio> catalogo = new ArrayList<>();
        
        // Polimorfismo en acción
        usuarios.put("natalie", new Cliente("natalie", "1234"));
        usuarios.put("admin", new Administrador("admin", "admin0"));
        
        catalogo.add(new Ejercicio("Sentadillas", "pierna", "Bajar la cadera manteniendo la espalda recta."));
        catalogo.add(new Ejercicio("Dominadas", "espalda", "Subir el pecho hacia la barra contrayendo la espalda."));
        catalogo.add(new Ejercicio("Curl de Bíceps", "brazo", "Flexionar los codos levantando las mancuernas."));

        Persona usuarioActual = null;

        System.out.println("=== SISTEMA FIDNESS - AVANCE 2 ===");

        while (usuarioActual == null) {
            System.out.print("Usuario: ");
            String user = scanner.nextLine();
            System.out.print("Contraseña: ");
            String pass = scanner.nextLine();

            try {
                if (usuarios.containsKey(user) && usuarios.get(user).getContrasena().equals(pass)) {
                    usuarioActual = usuarios.get(user);
                    System.out.print("\n¡Acceso concedido! ");
                    usuarioActual.mostrarRol(); // Polimorfismo
                } else {
                    throw new DatoInvalidoException("Error: Usuario o contraseña incorrectos.");
                }
            } catch (DatoInvalidoException e) {
                System.out.println(e.getMessage() + " Intente de nuevo.\n");
            }
        }

        // Menú completo
        Rutina rutinaUsuario = null;
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver Catálogo de Ejercicios");
            System.out.println("2. Crear / Armar mi Rutina");
            System.out.println("3. Ver / Exportar mi Rutina");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            
            try {
                int op = Integer.parseInt(scanner.nextLine());
                
                switch (op) {
                    case 1:
                        System.out.println("\n--- CATÁLOGO ---");
                        for (int i = 0; i < catalogo.size(); i++) {
                            System.out.println((i + 1) + ". " + catalogo.get(i));
                        }
                        break;
                        
                    case 2:
                        System.out.print("Nombre de tu rutina (ej. Rutina Piernas): ");
                        String nombreR = scanner.nextLine();
                        rutinaUsuario = new Rutina(nombreR);

                        boolean agregando = true;
                        while (agregando) {
                            System.out.println("\nSelecciona un ejercicio para agregar:");
                            for (int i = 0; i < catalogo.size(); i++) {
                                System.out.println((i + 1) + ". " + catalogo.get(i).getNombre());
                            }
                            System.out.print("Número de ejercicio (0 para terminar): ");
                            int seleccion = Integer.parseInt(scanner.nextLine());

                            if (seleccion == 0) {
                                agregando = false;
                            } else if (seleccion > 0 && seleccion <= catalogo.size()) {
                                Ejercicio elegido = catalogo.get(seleccion - 1);
                                rutinaUsuario.agregarEjercicio(elegido);
                                System.out.println("¡Agregado: " + elegido.getNombre() + "!");
                            } else {
                                System.out.println("Opción no válida.");
                            }
                        }
                        break;
                        
                    case 3:
                        if (rutinaUsuario == null) {
                            System.out.println("\nTodavía no has creado ninguna rutina.");
                        } else {
                            rutinaUsuario.mostrarRutina();
                            System.out.println("\n[Sistema]: Rutina lista para consultar o exportar.");
                        }
                        break;
                        
                    case 4:
                        salir = true;
                        System.out.println("Saliendo del sistema...");
                        break;
                        
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("¡Error! Debes ingresar un número válido.");
            }
        }
        scanner.close();
    }
}