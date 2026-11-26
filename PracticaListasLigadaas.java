/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

import java.util.Scanner;

/**
 *
 * @author Ariadna Yenisey
 */
public class PracticaListasLigadaas {
    public static void main(String[] args) {
      /* Scanner teclado = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        int opcion;

        do {
            SScanner teclado = new Scanner(System.in);
        ystem.out.println("\n===== MENÚ LISTA LIGADA =====");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Buscar un valor");
            System.out.println("4. Eliminar un valor");
            System.out.println("5. Mostrar la lista");
            System.out.println("6. Ver tamaño");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor: ");
                    lista.insertarInicio(teclado.nextInt());
                    break;
                case 2:
                    System.out.print("Valor: ");
                    lista.insertarFinal(teclado.nextInt());
                    break;
                case 3:
                    System.out.print("Valor a buscar: ");
                    int buscado = teclado.nextInt();
                    System.out.println(lista.buscar(buscado)
                            ? "Sí está en la lista"
                            : "No está en la lista");
                    break;
                case 4:
                    System.out.print("Valor a eliminar: ");
                    int eliminado = teclado.nextInt();
                    System.out.println(lista.eliminar(eliminado)
                            ? "Eliminado"
                            : "No encontrado");
                    break;
                case 5:
                    lista.mostrar();
                    break;
                case 6:
                    System.out.println("Tamaño: " + lista.getTamanio());
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        teclado.close();
    }*/
    // 1. Creamos la lista vacía
    /*ListaEnlazada lista = new ListaEnlazada();
    int[] valores = {7, 4, 8, 1, 3, 2, 2};

    for (int dato : valores) {
        System.out.println("Insertando: " + dato);
        lista.insertarOrdenado(dato);
        System.out.println("Lista actual:" + lista);
    }
    }*/
    Scanner sc = new Scanner(System.in);
        listaDoble lista = new listaDoble();
        int opcion;

        do {
            System.out.println("\n========= MENÚ LISTA DOBLEMENTE ENLAZADA =========");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posición");
            System.out.println("4. Insertar ordenado");
            System.out.println("5. Eliminar al inicio");
            System.out.println("6. Eliminar al final (eliminarUltimo)");
            System.out.println("7. Eliminar por valor");
            System.out.println("8. Eliminar por posición");
            System.out.println("9. Imprimir  y ver tamaño");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Valor a insertar al inicio: ");
                        lista.InsertaInicio(sc.nextInt());
                        mostrarEstado(lista);
                        break;
                    case 2:
                        System.out.print("Valor a insertar al final: ");
                        lista.InsertarFinal(sc.nextInt());
                        mostrarEstado(lista);
                        break;
                    case 3:
                        System.out.print("Posición: ");
                        int posIns = sc.nextInt();
                        System.out.print("Valor: ");
                        int valIns = sc.nextInt();
                        lista.InsertarEnPocision(posIns, valIns);
                        mostrarEstado(lista);
                        break;
                    case 4:
                        System.out.print("Valor a insertar ordenado: ");
                        lista.insertarOrdenado(sc.nextInt());
                        mostrarEstado(lista);
                        break;
                    case 5:
                        System.out.println("Eliminado del inicio: " + lista.EliminarInicio());
                        mostrarEstado(lista);
                        break;
                    case 6:
                        System.out.println("¿Se eliminó el último?: " + lista.eliminarUltimo());
                        mostrarEstado(lista);
                        break;
                    case 7:
                        System.out.print("Valor a eliminar: ");
                        System.out.println("¿Se eliminó?: " + lista.EliminarporValor(sc.nextInt()));
                        mostrarEstado(lista);
                        break;
                    case 8:
                        System.out.print("Posición a eliminar: ");
                        System.out.println("Dato eliminado: " + lista.EliminarEnPocision(sc.nextInt()));
                        mostrarEstado(lista);
                        break;
                    case 9:
                        mostrarEstado(lista);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IllegalStateException e) {
                System.out.println("ERROR controlado: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }

    // Muestra la lista hacia adelante, hacia atrás y su tamaño
    public static void mostrarEstado(listaDoble lista) {
        System.out.println("Adelante (cabeza -> cola): " + lista.toString());
        System.out.println("Tamaño actual: " + lista.getTamanio());
    }

}
