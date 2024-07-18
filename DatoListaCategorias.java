/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotica;

public class DatoListaCategorias {
    private int idCategoria;
    private String nombreCategoria;
    private ListaLibros listaLibrosAsociados;

    public DatoListaCategorias() {
        this.idCategoria = 0;
        this.nombreCategoria = "";
        this.listaLibrosAsociados = new ListaLibros();
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ListaLibros getListaLibrosAsociados() {
        return listaLibrosAsociados;
    }

    public void setListaLibrosAsociados(ListaLibros listaLibrosAsociados) {
        this.listaLibrosAsociados = listaLibrosAsociados;
    }
}

