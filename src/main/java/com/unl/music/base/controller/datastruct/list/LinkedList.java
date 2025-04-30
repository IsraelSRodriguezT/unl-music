package com.unl.music.base.controller.datastruct.list;
public class LinkedList<E> { 
    //Atributos:
    private Nodo<E> head;
    private Nodo<E> last;
    private Integer length;
    //Constructor:
    public LinkedList() {
        this.head = null;
        this.last = null;
        this.length = 0;
    }
    //Getters and Setters:
    public E get(Integer pos) throws ArrayIndexOutOfBoundsException {
        return getNodo(pos).getData();
    }
    public E getDataFirst() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Lista vacia");
        }
        return head.getData();
    }
    public E getDataLast() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Lista vacia");
        }
        return last.getData();
    }
    public Integer getLength() {
        return length;
    }
    private Nodo<E> getNodo(Integer pos) throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Lista vacia");
        } else if (pos < 0 || pos >= length) {
            throw new ArrayIndexOutOfBoundsException("Indice fuera de rango");
        } else if (pos == 0) {
            return head;
        } else if ((length.intValue()-1) == pos.intValue()) {
            return last;
        } else {
            Nodo<E> search = head;
            Integer cont = 0;
            while (cont < pos) {
                search = search.getNext();
                cont++;
            }
            return search;
        }
    }
    public boolean isEmpty(){ //?
        return head == null || length == 0;
    }
    public void setLength(Integer length){
        this.length = length;
    }

    //Metodos:
    
    public void add(E data, Integer pos) throws ArrayIndexOutOfBoundsException {
        if (pos == 0) {
            addFirst(data);
        } else if (length.intValue() == pos.intValue()) {
            addLast(data);
        } else {
            Nodo<E> search_preview = getNodo(pos-1);
            Nodo<E> search = getNodo(pos);
            Nodo<E> aux = new Nodo<E>(data, search);
            search_preview.setNext(aux);
            length++;
        }
    }
    public void add(E data) {
        addLast(data);
    }
    private void addFirst(E data){
        if(isEmpty()){
            Nodo<E> aux = new Nodo<E>(data);
            head = aux;
            last = aux;
        } else{
            Nodo<E> head_old = head;
            Nodo<E> aux = new Nodo<E>(data, head_old);
            head=aux;
        }
        length++;
    }
    private void addLast(E data){
        if(isEmpty()){
            addFirst(data);
        } else{
            Nodo<E> aux = new Nodo<E>(data);
            last.setNext(aux);
            last = aux;
            length ++;

        }
    }
    public void clear() {
        this.head = null;
        this.last = null;
        this.length = 0;
    }
    public String print() {
        if (isEmpty()) {
            return "La lista está vacia";
        } else {
            StringBuilder resp = new StringBuilder();
            Nodo<E> help = head;
            while (help != null) {
                resp.append(help.getData()).append(" -> ");
                help = help.getNext();
            }
            resp.append("\n");
            return resp.toString();
        }
    }
    public void update(E data, Integer pos) throws ArrayIndexOutOfBoundsException {
        getNodo(pos).setData(data);
    }
    // public void delete(E data, Integer pos) throws ArrayIndexOutOfBoundsException {
    //     if (pos == 0) {
    //         deleteFirst(data);
    //     } else if (length.intValue() == pos.intValue()) {
    //         deleteLast(data);
    //     } else {
    //         Nodo<E> search_preview = getNodo(pos-1);
    //         Nodo<E> search = getNodo(pos);
    //         Nodo<E> aux = new Nodo<E>(data, search);
    //         search_preview.setNext(aux);
    //         length++;
    //     }
    // }
    // public void delete(E data) {
    //     deleteLast(data);
    // }
    // private void deleteFirst(E data){
    //     if(isEmpty()){
    //         Nodo<E> aux = new Nodo<E>(data);
    //         head = aux;
    //         last = aux;
    //     } else{
    //         Nodo<E> head_old = head;
    //         Nodo<E> aux = new Nodo<E>(data, head_old);
    //         head=aux;
    //     }
    //     length++;
    // }
    // private void deleteLast(E data){
    //     if(isEmpty()){
    //         addFirst(data);
    //     } else{
    //         Nodo<E> aux = new Nodo<E>(data);
    //         last.setNext(aux);
    //         last = aux;
    //         length ++;

    //     }
    // }
    public E[] toArray(){
        Class clazz = null;
        E[] matriz = null;
        if(this.length > 0){
            clazz = head.getData().getClass();
            matriz = (E[]) java.lang.reflect.Array.newInstance(clazz, this.length);
            Nodo<E> aux = head;
            for (int i = 0; i < length; i++){
                matriz[i] = aux.getData();
                aux = aux.getNext();
            }
        }
        return matriz;
    }

    public LinkedList<E> toList(E[] matriz){
        clear();
        for (int i=0; i<length; i++){
            this.add(matriz[i]);
        }
        return this;
    }

    public static void main (String[] args) throws ArrayIndexOutOfBoundsException {
        LinkedList<Double> lista = new LinkedList<>();
        try {
            System.out.println("Hola");
            System.out.println("Lista enlazada empezando:");
            lista.add(56.7);
            System.out.println(lista.print());
            System.out.println("Lista enlazada agregando 2ndo valor");
            lista.add(65.7);
            System.out.println(lista.print());
            System.out.println("Lista enlazada agregando valor al inicio");
            lista.add(1.0, 0);
            System.out.println(lista.print());
            System.out.println("Lista enlazada agregando 4rto valor");
            lista.add(4.7);
            System.out.println(lista.print());
            System.out.println("Lista enlazada agregando valor en la posicion 3");
            lista.add(9.0, 3);
            System.out.println(lista.print());
            System.out.println(lista.get(lista.getLength()-1));
            System.out.println("Actualizar");
            lista.update(10.00, 3);
            System.out.println(lista.print());
        } catch (Exception e) {
            System.out.println("Error: " + e);
            // TODO: handle exception
        }
        System.out.println("Lista enlazada final:");
        System.out.println(lista.print());
        System.out.println("Final");
    }
}
