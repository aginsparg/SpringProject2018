package edu.luc.cs271.linkedstack;

import java.util.*;

public class LinkedQueue<E> implements MyQueue<E> {

    Node<E> first;
    Node<E> last = null;
    int size = 0;


    public boolean offer(final E object) {

        if (size == 0) {
            first = new Node<>(object, last);
            //last = first;
        } else
        {prioritize(object);}

            size = size+1;
        return true;
    }


    public E peek() {
        if(isEmpty()){
            return null;
        }

        return first.data;
    }

    public E poll() {
        if (isEmpty())
            return null;
        else {
            E to_return = first.data;
            first = first.next;
            size = size-1;
            return to_return;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {

        return size;
    }

    public List<E> asList() {

        Node<E> tempfirst = first;
        List<E> hostpitallist = new ArrayList<>();
        while (first != null) {
            hostpitallist.add(first.data);
            first = first.next;
        }

        first = tempfirst;


        return hostpitallist;
    }

    public boolean prioritize(E obj) {

        Node<E> nodetesting;
        nodetesting = first;
        E testing = nodetesting.data;
        Node<E> nodeInsertAfter = first;
        boolean done = false;

        if (nodetesting == null) {
            nodeInsertAfter.next = new Node<>(obj, last);
            done = true;
        }
        while (!done) {
            if (Integer.parseInt(testing.toString().substring(0, 1)) > Integer.parseInt(obj.toString().substring(0, 1))) {
                nodeInsertAfter = nodetesting;
                nodetesting = nodetesting.next;
                testing = nodetesting.data;
            } else {
                nodeInsertAfter.next = new Node<>(obj, nodetesting);
                done = true;
            }
        }


        return true;
    }
}