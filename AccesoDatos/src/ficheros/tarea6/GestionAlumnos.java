package ficheros.tarea6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

import ficheros.tarea5.Alumno5;

public class GestionAlumnos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String ficheroEnUso = null;
        int opcion = 0;

        do {
            System.out.println("\n========= MENÚ DE GESTIÓN DE ALUMNOS =========");
            System.out.println("1. Generar fichero vacío");
            System.out.println("2. Seleccionar fichero existente");
            System.out.println("3. Añadir alumno al fichero en uso");
            System.out.println("4. Mostrar todos los alumnos del fichero en uso");
            System.out.println("5. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // limpiar buffer

            switch (opcion) {

            case 1: // Crear fichero vacío
                System.out.print("Introduce el nombre del nuevo fichero (sin extensión): ");
                String nombreNuevo = entrada.nextLine();
                ficheroEnUso = nombreNuevo + ".dat";

                try (FileOutputStream fo = new FileOutputStream(ficheroEnUso)) {
                    System.out.println("Fichero " + ficheroEnUso + " creado correctamente.");
                } catch (IOException e) {
                    System.out.println("Error al crear el fichero.");
                    e.printStackTrace();
                }
                break;

            case 2: // Seleccionar fichero existente
                System.out.print("Introduce el nombre del fichero existente (sin extensión): ");
                String nombreExistente = entrada.nextLine();
                ficheroEnUso = nombreExistente + ".dat";
                File f = new File(ficheroEnUso);
                if (f.exists()) {
                    System.out.println("Fichero " + ficheroEnUso + " seleccionado correctamente.");
                } else {
                    System.out.println("El fichero no existe. Intenta crearlo primero.");
                    ficheroEnUso = null;
                }
                break;

            case 3: // Añadir alumno manualmente
                if (ficheroEnUso == null) {
                    System.out.println("Primero debes crear o seleccionar un fichero.");
                    break;
                }

                try {
                    System.out.print("NIA: ");
                    int nia = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidos = entrada.nextLine();

                    System.out.print("Género (M/F): ");
                    String genero = entrada.next();
                    entrada.nextLine();

                    System.out.print("Dime el año de nacimiento");
                    int anio = entrada.nextInt();
                    System.out.println("Dime el mes de nacimiento");
                    int mes=entrada.nextInt();
                    System.out.println("Dime el dia de tu nacimiento");
                    int dia=entrada.nextInt();
                    
                    System.out.print("Ciclo: ");
                    String ciclo = entrada.nextLine();

                    System.out.print("Curso: ");
                    String curso = entrada.nextLine();

                    System.out.print("Grupo: ");
                    String grupo = entrada.nextLine();
                    
                    
                    Alumno5 alumno = new Alumno5(nombre, apellidos, ciclo, curso, grupo, nia, genero,
    						LocalDate.of(anio, mes, dia));                    
                    // Escribir alumno en modo append
                    File fichero = new File(ficheroEnUso);
                    FileOutputStream fos = new FileOutputStream(fichero, true);
                    if (fichero.length() == 0) {
                        // Si el fichero está vacío, escribimos cabecera normal
                        try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(fos)) {
                            oos.writeObject(alumno);
                        }
                    } else {
                        // Si ya tiene objetos, usamos MiObjectOutputStream para evitar nueva cabecera
                        try (ObjectOutputStream moos = new ObjectOutputStream(fos)) {
                            moos.writeObject(alumno);
                        }
                    }

                    System.out.println("Alumno añadido correctamente al fichero " + ficheroEnUso);

                } catch (IOException e) {
                    System.out.println("Error al escribir en el fichero.");
                    e.printStackTrace();
                }
                break;

            case 4: // Mostrar todos los alumnos
                if (ficheroEnUso == null) {
                    System.out.println("Primero debes crear o seleccionar un fichero.");
                    break;
                }

                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroEnUso))) {
                    System.out.println("\n--- LISTA DE ALUMNOS EN " + ficheroEnUso + " ---");
                    while (true) {
                        try {
                            Alumno5 a = (Alumno5) ois.readObject();
                            System.out.println(a.toString());
                        } catch (EOFException e) {
                            break; // fin del fichero
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("No se encuentra el fichero.");
                } catch (IOException e) {
                    System.out.println("Error leyendo el fichero.");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case 5:
                System.out.println("Fin del programa.");
                break;

            default:
                System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        entrada.close();
    }
}
