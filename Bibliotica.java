/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotica;

import javax.swing.JOptionPane;

public class Bibliotica {

    public static void main(String[] args) {
        ListaCategorias listaCategorias = new ListaCategorias();
        ListaLibros listaLibros = new ListaLibros();

        // Ejemplo de inserción de categorías y libros
        DatoListaCategorias categoria1 = new DatoListaCategorias();
        categoria1.setIdCategoria(1);
        categoria1.setNombreCategoria("Ficción");

        DatoListaCategorias categoria2 = new DatoListaCategorias();
        categoria2.setIdCategoria(2);
        categoria2.setNombreCategoria("Ciencia");

        listaCategorias.agregarCategoria(categoria1);
        listaCategorias.agregarCategoria(categoria2);

        Libros libro1 = new Libros();
        libro1.setIdLibro(1);
        libro1.setNombre("1984");
        libro1.setCategoria("Ficción");
        libro1.setAutor("George Orwell");
        libro1.setEditorial("Debolsillo");

        Libros libro2 = new Libros();
        libro2.setIdLibro(2);
        libro2.setNombre("Cien años de soledad");
        libro2.setCategoria("Ficción");
        libro2.setAutor("Gabriel García Márquez");
        libro2.setEditorial("Cien años de soledad");

        listaLibros.insertar(libro1);
        listaLibros.insertar(libro2);

        // Menú interactivo con JOptionPane
        String[] opciones = {"Agregar Libro", "Eliminar Libro", "Ver Libros", "Salir"};

        while (true) {
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null,
                    "Selecciona una opción:", "Bibliotica", JOptionPane.PLAIN_MESSAGE,
                    null, opciones, opciones[0]);

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Bibliotica", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            switch (opcionSeleccionada) {
                case "Agregar Libro":
                    agregarLibro(listaLibros, listaCategorias);
                    break;
                case "Eliminar Libro":
                    eliminarLibro(listaLibros);
                    break;
                case "Ver Libros":
                    verLibros(listaLibros);
                    break;
                default:
                    break;
            }
        }
    }

    private static void agregarLibro(ListaLibros listaLibros, ListaCategorias listaCategorias) {
        Libros nuevoLibro = new Libros();

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del libro:");
        nuevoLibro.setNombre(nombre);

        String autor = JOptionPane.showInputDialog("Ingrese el nombre del autor:");
        nuevoLibro.setAutor(autor);

        String editorial = JOptionPane.showInputDialog("Ingrese el nombre de la editorial:");
        nuevoLibro.setEditorial(editorial);

        // Mostrar categorías disponibles para seleccionar
        StringBuilder opcionesCategorias = new StringBuilder();
        NodoListaCategorias actual = listaCategorias.getPrimerNodo();
        do {
            DatoListaCategorias categoria = actual.getDato();
            opcionesCategorias.append(categoria.getIdCategoria()).append(". ")
                    .append(categoria.getNombreCategoria()).append("\n");
            actual = actual.getSiguiente();
        } while (actual != listaCategorias.getPrimerNodo());

        int idCategoriaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione la categoría del libro:\n" + opcionesCategorias.toString()));

        // Asociar la categoría seleccionada al libro
        Libros libroAsociado = listaLibros.buscarLibro(nuevoLibro.getIdLibro());
        if (libroAsociado != null) {
            nuevoLibro.setCategoria(libroAsociado.getCategoria());
        }

        // Insertar el nuevo libro en la lista de libros
        listaLibros.insertar(nuevoLibro);

        JOptionPane.showMessageDialog(null, "Libro agregado exitosamente.", "Bibliotica", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void eliminarLibro(ListaLibros listaLibros) {
        int idLibro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del libro a eliminar:"));
        boolean eliminado = listaLibros.eliminarLibro(idLibro);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente.", "Bibliotica", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ID.", "Bibliotica", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void verLibros(ListaLibros listaLibros) {
        String listaLibrosStr = listaLibros.toString();
        JOptionPane.showMessageDialog(null, listaLibrosStr, "Lista de Libros", JOptionPane.PLAIN_MESSAGE);
    }
}
