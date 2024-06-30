package de.unibayreuth.se.teaching.list.data.persistence;

import org.springframework.stereotype.Component;


/**
 * Wrapper for our doubly linked list implementation to make it available as a Spring component while allowing its
 * implementation as a singleton.
 */
@Component
public class DoublyLinkedListComponent {
    private final DoublyLinkedList list = new DoublyLinkedList();

    public void append(DoublyLinkedList.Element e, boolean elementValidation) {
        list.append(e, elementValidation);
    }

    public void append(DoublyLinkedList.Element e) {
        list.append(e);
    }

    public void append(double value) {
        list.append(value);
    }

    public void append(DoublyLinkedListComponent list) {
        list.append(list);
    }

    public void append(double[] values) {
        list.append(values);
    }

    public double[] asArray() {
        return list.asArray();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(DoublyLinkedList.Element e) {
        list.insert(e);
    }

    public void insert(double value) {
        list.insert(value);
    }

    public int getLength() {
        return list.getLength();
    }
}
