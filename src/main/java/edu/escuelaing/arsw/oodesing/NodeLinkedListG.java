/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.oodesing;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author J. Eduardo Arias
 */
public class NodeLinkedListG<E>  {
    private E valor;
    private NodeLinkedListG<E> next;
    
    public NodeLinkedListG(E valor){
        this.valor=valor;
        next=null;
    }

    public NodeLinkedListG<E> getNext() {
        return next;
    }

    public void setNext(NodeLinkedListG<E> next) {
        this.next = next;
    }
    
 

    public E getValor() {
        return valor;
    }

    
}
