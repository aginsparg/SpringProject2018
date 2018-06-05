package edu.luc.cs271.linkedstack;

/**
 * A node in a linked list.
 *
 * @param <E> the element type of the node
 */
class Node<E> {

  /** The data value stored in this node. */
  public E data;

  /** The successor node of this node. */
  public Node<E> next;

  /** Creates a node from the given data value and existing successor node. */
  public Node(final E data, final Node<E> next) {
    if (data == null) throw new IllegalArgumentException("data is null");
    this.data = data;
    this.next = next;
  }

  /** Creates a node without successor from the given data value. */
  public Node(final E data) {
    this(data, null);
  }

  /** Returns a string representation of the node suitable for debugging. */
  public String toString() {
    return "Node@" + hashCode() + "(" + data +
        (next != null ? ", Node@" + next.hashCode() + ")" : ")");
  }
}
