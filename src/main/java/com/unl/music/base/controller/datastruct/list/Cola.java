// package com.unl.music.base.controller.datastruct.list;

// public class Cola {
//     //Atributos:
//     private Nodo primerNodo;
//     private Nodo ultimoNodo;
//     //Consructor:
//     public Cola() {
//         this.primerNodo = null;
//         this.ultimoNodo = null;
//     }
//     //Metodos:
//     public void encolar(E data){
//         Nodo nuevoNodo = new Nodo<>(data); 
//         if (ultimoNodo == null) {
//             primerNodo = nuevoNodo;
//         } else {
//             ultimoNodo.setNext(nuevoNodo);
//         }
//         ultimoNodo = nuevoNodo;
//     }
//     public E desencolar(){
//         if (primerNodo == null) {
//             return null;
//         }
//         E data = primerNodo.getData();
//         primerNodo = primerNodo.getNext();
//         if (primerNodo == null) {
//             ultimoNodo = null;
//         }
//         return data;
//     }
// }
