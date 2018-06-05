package edu.luc.cs271.linkedstack;

import java.util.*;

public class LinkedQueue<E> implements MyQueue<E> {

    Node<E> first;
    Node<E> last;
    int size = 0;
    //hospitalqueue = new LinkedList<>();

    public boolean offer(final E object) {


        if (size == 0) {
            first = new Node<>(object, last);
            last = first;
        } else
        {prioritize(object);}

            size = size++;
        return true;
    }


    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return first.data;
    }

    public E poll() {
        if (isEmpty())
            return null;
        else {
            E to_return = first.data;
            first = first.next;
            size = size--;
            return to_return;
        }
    }

    public boolean isEmpty() {
        if (first == null)
            return true;
        else
            return false;
    }

    public int size() {

        return size;
    }

    public List asList() {

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

        Node<E> before = first;
        E testing = first.data;
        boolean done = false;
        while (before != null || done == false) {
            if (Integer.parseInt(testing.toString().substring(0, 2)) > Integer.parseInt(obj.toString().substring(0, 2))) {
                testing = first.next.data;
            } else {
                Node<E> temp = before.next;
                before.next = new Node<>(obj, temp);
                done = true;
            }
        }

        if (before == null) {
            last.next = new Node<>(obj);
        }
        return true;
    }
}