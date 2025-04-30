package com.unl.music.base.controller.datastruct.list;
//K,v   KEY, VALUE
//E  COLECCIONES
//T DATO GENERICO
// Cambia porque T es generico y al tratarse de una lista enlazada mejor se usa E pr tratarse de una coleccion
public class Nodo<E>{
    private E data;
    private Nodo<E> next;

    public Nodo(E data, Nodo<E> next) {
        this.data = data;
        this.next = next;
    }
    public Nodo(E data) {
        this.data = data;
        this.next = null;
    }
    public Nodo() {
        this.data = null;
        this.next = null;
    }
    public E getData(){
        return data;
    }
    public void setData(E data){
        this.data = data;
    }
    public Nodo<E> getNext(){
        return next;
    }
    public void setNext(Nodo<E> next){
        this.next = next;
    }
}