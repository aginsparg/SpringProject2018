package edu.luc.cs271.linkedstack;

import java.util.*;

public class LinkedQueue<E> implements MyQueue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    /** Adds a new object to the queue. Unless object is the first in the queue, object will be prioritized to be placed
     * in order within the queue through an insertion sort. Adds to size of queue.
     *
     * @post queue is one size larger
     * @param object
     * @return true if properly processed
     */
    public boolean offer(final E object) {

        if (size == 0) {
            first = new Node<>(object, last);

        } else
        {prioritize(object);}

            size = size+1;
        return true;
    }

    /** Displays the first node of the queue without removing it. If the queue is empty returns a null value.
     *
     * @return object contained in first node of queue
     */
    public E peek() {
        if(isEmpty()){
            return null;
        }

        return first.data;
    }

    /** Returns value of first node in queue. If empty returns null. Decreases size of queue.
     *
     * @post queue is one size smaller
     * @return Value in the first node of queue
     */
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

    /** Tests if queue is empty based on size of queue.
     *
     * @return true if size is 0, false if size is greater than zero.
     */
    public boolean isEmpty() {
        if(size == 0)
        return true;
        else
            return false;
    }

    /** Tests for size of queue.
     *
     * @return size of queue
     */
    public int size() {

        return size;
    }

    /** Puts contents of queue into a list without taking apart queue.
     *
     * @return contents of queue in form of a list.
     */
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

    /** Called by offer and does insertion sort to ensure that obj added to queue in proper location to ensure
     * priority level of patients remains in order. Within same emergency level, prioritize() ensures first come first serve order.
     *
     * @param obj
     * @return true if processed and placed obj in proper location
     */
    public boolean prioritize(E obj) {

        Node<E> nodetesting;
        nodetesting = first;
        E testing = nodetesting.data;
        Node<E> nodeInsertAfter = null;
        boolean done = false;
        int full_times_through_loop = 0;
        boolean lessthannext = false;


//if the node following the one presently testing is not null and obj is still not in its correct spot the following is done.
        while (nodetesting.next!=null && !done) {

// if the emergency level of the nodetesting is less than that of obj (ex: 5 and 6)it goes to the next node and updates the nodeInsertAfter
// to be the node that was just tested.
            if (Integer.parseInt(testing.toString().substring(0, 1)) < Integer.parseInt(obj.toString().substring(0, 1))) {
                nodeInsertAfter = nodetesting;
                nodetesting = nodetesting.next;
                testing = nodetesting.data;
                full_times_through_loop++;
            }
// if the emergency level of the nodetesting is not less than the emergency level of obj then:
// if the program has not yet done a full loop and the emergency level of nodetesting is not equal to that of obj then this is the front of the
//queue and obj is inserted as the new beginning of the queue.    ex: 6 and 5
// if it didn't yet do a full loop or the two numbers are equal then if the numbers are equal keep moving further
// down the queue until the two numbers are not equal and then insert obj before the number to which it is not equal
// if the two numbers do not satisfy any of the above situations, then insert a node before the node testing.
            else {
                if((full_times_through_loop ==0) && (Integer.parseInt(testing.toString().substring(0, 1)) != Integer.parseInt(obj.toString().substring(0, 1))))
                {
                    Node<E> newfirst = new Node<>(obj, nodetesting);
                    first = newfirst;
                }
                  else
                       if(Integer.parseInt(testing.toString().substring(0, 1)) == Integer.parseInt(obj.toString().substring(0, 1))){
                            nodeInsertAfter = nodetesting;
                            nodetesting = nodetesting.next;
                            testing = nodetesting.data;
                            do {

                                if(Integer.parseInt(testing.toString().substring(0,1)) == Integer.parseInt(obj.toString().substring(0,1))){
                                    nodeInsertAfter = nodetesting;
                                    nodetesting = nodetesting.next;
                                    testing = nodetesting.data;
                                }
                                else
                                {lessthannext = true;}
                            }while(!lessthannext);
                    nodeInsertAfter.next = new Node<>(obj, nodetesting);

                    }
                    else
                    {nodeInsertAfter.next = new Node<>(obj, nodetesting);}

                done = true;
            }
        }

        // if the node after the one testing is null and nodetesting is larger than obj and the nodetesting is the first node in the queue
        // (which occurs if nodeInsertAfter is still null), insert obj as the new first
        // if the node after the one testing is null and nodetesting is larger than obj and nodetesting is not the first node in the queue
        // (nodeInsertAfter is not null) place the new node before the nodetesting
        // if the node after the one testing is null and nodetesting is smaller than obj insert obj after nodetesting

        // This block of code was done to avoid nullPointerException.

        if (nodetesting.next == null) {
            if ((Integer.parseInt(testing.toString().substring(0, 1)) > Integer.parseInt(obj.toString().substring(0, 1)) && (nodeInsertAfter == null))) {
                Node<E>newfirst = new Node<>(obj, nodetesting);
                first = newfirst;
            }
            else
                if  ((Integer.parseInt(testing.toString().substring(0, 1)) > Integer.parseInt(obj.toString().substring(0, 1)) && (nodeInsertAfter != null))){
                    nodeInsertAfter.next = new Node<>(obj, nodetesting);
                }
                else{
            nodetesting.next = new Node<>(obj, last);
        }
        }

        return true;
    }
}