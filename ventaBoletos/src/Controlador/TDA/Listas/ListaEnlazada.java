/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Listas;

import Controlador.TDA.Listas.Exception.EmptyException;

/**
 *
 * @author Estefania
 */
public class ListaEnlazada <E> {
    //declaracion de variable
    private Node<E> header;//cabecera
    private Node<E> last;//ultimo
    private Integer length;//longitud 

    //constructor 
    public ListaEnlazada() {
        header = null;//inicializa como valor nulo
        last = null;
        length = 0;//vacio
    }
    
    //verificar si la lista esta vacia
    public Boolean isEmpty() {
        return (header == null || length.intValue() == 0);
    }
    
    //añadir un nodo al inicio
    public void addHeader(E info) {
        Node<E> help;//aux
        //si esta vacia,se crea el nodo y se establece en cabecera y en el nodo ultimo
        if (isEmpty()) {
            help = new Node<>(info);
            header = help;
            last = help;//
            length++;//Incrementa longitud
        }
        else {//si no esta vacia,crea nodo info y lo enlaza con el nodo actual 
            Node<E> headHelp = header;
            help = new Node<>(info, headHelp);
            header = help;
            length++;
        }
    }
    //metodo para anadir el nodo final 
    public void addLast(E info) {
        Node<E> help;
        if (isEmpty()) {
            addHeader(info);//se agrega como encabezado si esta vacio
        }
        else {
            help = new Node<>(info, null);//crea nuevo 
            last.setNext(help);//se establece en el siguiente del ultimo nodo como nuevo
            last = help;//actualiza
            length++;//incrementa
        }
    }

    public void add(E info) {
        addLast(info);//añade un elemento

    }

    public E getInfo(Integer index) throws EmptyException, IndexOutOfBoundsException {
        return getNode(index).getInfo();
    }
  
    //obtener el primer elemento de la lista   
    private E getFirst() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("ListaVacia");
        }
        return header.getInfo();
    }
    //obtener el ultimo elemento de la lista 
    private E getLast() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("ListaVacia");
        }
        return last.getInfo();
    }
    // Obtener el nodo en la posición especificada
    private Node<E> getNode(Integer index) throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Error, Lista vacia");
        }
        else if (index.intValue() < 0 || index.intValue() >= length) {
            throw new IndexOutOfBoundsException("Error, Esta fuera del limite de la lista");
        }
        else if (index.intValue() == 0) {
            return header;//retorna el elemento cabecera
        }
        else if (index.intValue() == (length - 1)) {
            return last;//retorna el elemento ultimo
        }
        else {
            Node<E> search = header;
            int cont = 0;
            while (cont < index) {
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }
     
    //metodo para anadir un elemento en la posición especificada
    public void add(E info, Integer index) throws EmptyException, IndexOutOfBoundsException {
        if (isEmpty() || index.intValue() == 0) {
            addHeader(info);
        }
        else if (index.intValue() == length) {
            addLast(info);
        }
        else {
            Node<E> search_preview = getNode(index - 1);
            Node<E> search = getNode(index);
            Node<E> help = new Node<>(info, search);
            search_preview.setNext(help);
            length++;

        }
    }
    //obtener la longuitud de la lista
    public Integer getLength() {
        return length;

    }
    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista");
        try {
            Node<E> help = header;
            while (help != null) {
                sb.append(help.getInfo()).append("\n");
                help = help.getNext();
            }
        }
        catch (Exception e) {
            sb.append(e.getMessage());
        }
        return sb.toString();
    }
    
    //modificar 
    public  E merge(E data, Integer index) throws EmptyException,IndexOutOfBoundsException{
        Node<E> search=getNode(index);
        E help=search.getInfo();
        search.setInfo(data);
        return help;
        
        
    }
}
