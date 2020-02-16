package com.company.linked_list;

import java.util.Optional;

public class Node<T> {
    private Node<T> next;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public Optional<Node<T>> next() {
        return Optional.ofNullable(next);
    }

    public void assignNext(Node<T> next) {
        this.next = next;
    }
}
