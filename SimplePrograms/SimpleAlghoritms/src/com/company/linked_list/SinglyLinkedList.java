package com.company.linked_list;

import java.util.Optional;

public class SinglyLinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList() {
    }

    public void add(T value) {
        if(this.head == null) {
            this.head = new Node<>(value);
        } else {
            Node<T> lastNode = getLastNode();
            lastNode.assignNext(new Node<>(value));
        }
    }

    public T get(int index) {
        Node<T> node = this.head;

        for(int  i = 0; i < index; i++) {
            if(node.next().isPresent()) {
                node = node.next().get();
            } else {
                throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
            }
        }

        return node.value();
    }
//removes first occurence of specified object
    public void remove(T value) {
        Node<T> node = this.head;
        if(value.equals(node.value())) {

            this.head = null;
            if(node.next().isPresent()) {
                this.head = node.next().get();
            }

            return;
        }
        //A -> B -> C -> D -> E
        Node<T> previous;
        while (node.next().isPresent()) {
            previous = node;
            node = node.next().get();
            if(value.equals(node.value())) {
                if(node.next().isEmpty()) {
                    previous.assignNext(null);
                } else {
                    previous.assignNext(node.next().get());
                }
            }
        }
    }

    private Node<T> getLastNode() {
        Node<T> lastNode = this.head;

        while (lastNode.next().isPresent()) {
            lastNode = lastNode.next().get();
        }

        return lastNode;
    }

}
