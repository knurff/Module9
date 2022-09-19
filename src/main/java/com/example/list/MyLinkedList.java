package com.example.list;

import java.util.Objects;

public class MyLinkedList<T> implements List<T> {

    private static final class Node<T> {
        private final T value;
        private Node<T> next;
        private Node<T> previous;

        private Node(T value) {
            this.value = value;
        }

        public static <T> Node<T> valueOf(T value) {
            return new Node<>(value);
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T element) {
        var newNode = Node.valueOf(element);

        if (size == 0) head = tail = newNode;
        else addAsTail(newNode);

        size++;
    }

    private void addAsTail(Node<T> newNode) {
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }

    @Override
    public T remove(int index) {
        T deletedElement;

        if (index == 0) {
            deletedElement = head.value;
            removeHead();
        } else if (index == size - 1) {
            deletedElement = tail.value;
            removeTail();
        } else {
            Node<T> previousNode = findNodeByIndex(index - 1);
            deletedElement = previousNode.next.value;
            previousNode.next = previousNode.next.next;
        }

        size--;
        return deletedElement;
    }

    private void removeTail() {
        tail = tail.previous;
        if (tail == null) head = null;
        else tail.next = null;
    }

    private void removeHead() {
        head = head.next;
        if (head == null) tail = null;
        else head.previous = null;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        var node = findNodeByIndex(index);
        return node.value;
    }

    private Node<T> findNodeByIndex(int index) {
        Objects.checkIndex(index, size);
        if (index == size - 1) return tail;
        else return nodeAt(index);
    }

    private Node<T> nodeAt(int index) {
        var currentNode = head;

        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;

        return currentNode;
    }
}
