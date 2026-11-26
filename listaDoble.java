/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ariadna Yenisey
 */
public class listaDoble {
    private int tamanio;
    private nodoDoble cabeza;
    private nodoDoble cola;
    
    public listaDoble(){
        tamanio=0;
        cabeza=null;
        cola=null;
    }
    public boolean EstaVacia(){
        if(cabeza==null && cola==null){
            return true;
        }else{
            return false;
        }        
    } 

    /**
     * @return the tamanio
     */
    public int getTamanio() {
        return tamanio;
    }
     //metodo para buscar un nodo
    public boolean buscar(int dato){
        nodoDoble aux=cabeza;
        while(aux!=null){
            if(aux.getDato()==dato){
                return true;
            }
            aux=aux.getSiguiente();
        }
        
        return false;
    }
    //metodo toString
    @Override
    public String toString(){
        String res="null";
        nodoDoble aux=cabeza;
        while(aux!=null){
            res=res+"<-["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }
        res=res+"null";
        return res;
    }
    
    //obtener Nodo
    public nodoDoble ObtenerNodo(int pos){
        //el primer caso seria que buscaran un nodo que este fuera del rango
        if(pos<=0||pos>tamanio){
            //deberia marcar un error tecnicamente:ahora lo arreglamos
            throw new IllegalStateException("El valor que estas insertando esta fuera del rango");
        }
        nodoDoble aux=cabeza;
        for(int i=1;i<pos;i++){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    
    //
    public void actualizar(int pos, int valor){
        nodoDoble val=ObtenerNodo(pos);
        val.setDato(valor);
    }
    
   public void InsertaInicio(int valor){
        nodoDoble nuevo = new nodoDoble(valor);
        if(EstaVacia()){
            cola = nuevo;
        } else {
            cabeza.setAnterior(nuevo);
            nuevo.setSiguiente(cabeza);
        }
        cabeza = nuevo;
        tamanio++;
    }
    
    // metodo para insertar al final de la lista
    public void InsertarFinal(int valor){
        nodoDoble nuevo = new nodoDoble(valor);
        if(EstaVacia()){
            cabeza = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
        }
        cola = nuevo;
        tamanio++;
    }
    
    public int EliminarInicio(){
        if(EstaVacia()){
            throw new IllegalStateException("No se puede eliminar con la lista vacia");
        }
        int dato = cabeza.getDato();
        if(cabeza == cola){ // Caso borde: solo había 1 nodo
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.getAnterior().setSiguiente(null);
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }

    public void InsertarEnPocision(int pos, int valor){
        if(pos <= 0 || pos > tamanio + 1){
            throw new IllegalStateException("El valor que estás insertando está fuera de rango");
        }
        if(pos == 1){
            InsertaInicio(valor);
            return;
        }
        nodoDoble aux = ObtenerNodo(pos - 1);
        nodoDoble nuevo = new nodoDoble(valor);
        nuevo.setSiguiente(aux.getSiguiente());
        nuevo.setAnterior(aux);
        
        if (aux.getSiguiente() != null) {
            aux.getSiguiente().setAnterior(nuevo);
        } else {
            cola = nuevo; // Caso borde: se insertó al final
        }
        aux.setSiguiente(nuevo); 
        tamanio++;       
    }

    public boolean EliminarporValor(int valor){
        if(EstaVacia()){
            return false; 
        }
        // caso 2 el valor esta justo al inicio de la lista
        if(cabeza.getDato() == valor){
            EliminarInicio(); // Reutilizamos EliminarInicio que ya maneja cabeza, cola y tamanio
            return true;
        }
        // en cualquier lugar de la fila
        nodoDoble aux = cabeza;
        while(aux.getSiguiente() != null){
            if (aux.getSiguiente().getDato() == valor) {
                nodoDoble nodoAEliminar = aux.getSiguiente();
                aux.setSiguiente(nodoAEliminar.getSiguiente());

                if (nodoAEliminar.getSiguiente() != null) {
                    nodoAEliminar.getSiguiente().setAnterior(aux);
                } else {
                    cola = aux; // Caso borde: se eliminó el último nodo
                }

                tamanio--;
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public int EliminarEnPocision(int pocision) {
        if (pocision <= 0 || pocision > tamanio) {
            throw new IllegalStateException("La posición está fuera de rango");
        }
        if (pocision == 1) {
            return EliminarInicio();
        }
        nodoDoble aux = ObtenerNodo(pocision - 1);
        nodoDoble objetivo = aux.getSiguiente();
        int dato = objetivo.getDato();

        aux.setSiguiente(objetivo.getSiguiente());

        if (objetivo.getSiguiente() != null) {
            objetivo.getSiguiente().setAnterior(aux);
        } else {
            cola = aux; // Caso borde: se eliminó el último nodo
        }

        tamanio--;
        return dato;
    }

    public boolean eliminarUltimo() {
        if (EstaVacia()) {
            return false;
        }
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamanio--;
        return true;
    }

    public void insertarOrdenado(int dato) {
        if (EstaVacia()) {
            InsertaInicio(dato);
            return;
        }
        if (dato <= cabeza.getDato()) {
            InsertaInicio(dato);
            return;
        } else {
            nodoDoble nuevo = new nodoDoble(dato);
            nodoDoble aux = cabeza;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato() < dato) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);

            if (aux.getSiguiente() != null) {
                aux.getSiguiente().setAnterior(nuevo);
            } else {
                cola = nuevo;
            }
            aux.setSiguiente(nuevo);
        }
        tamanio++;
    }
}