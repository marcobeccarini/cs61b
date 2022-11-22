package deque;

public class LinkedListDeque<template> {

    int RFACTOR = 2;
    private class Node<template>{
        private template item;
        private Node next;
        private Node prev;

        private Node(template i, Node previousNode, Node nextNode){
            item = i;
            prev = previousNode;
            next = nextNode;
        }

    }

    private Node sentinel;
    private Node current;
    private int size;

    public void LinkedListDeque(){
        sentinel = new Node(0, null, null);
        current = sentinel;
        size = 0;
    }

    public void addFirst(template x){
        Node last = sentinel.prev;
        Node newNode = new Node(x, sentinel, null);
        sentinel.next = newNode;

        
    }

    public void addLast(template x){
        sentinel.prev = new Node<>(x, sentinel.next, sentinel.prev);
        size = size + 1;
    }

    public boolean isEmpty(){
        return 0 == size;
    }

    public int size(){
        return size;
    }

    public void printDeque(){

        Node current = sentinel.next;
        int count = 0;

        while (current.next != sentinel.next){
            System.out.print(current.item + " ");
        }
        System.out.println();
    }

    public template get(int index) {

        Node current = sentinel.next;
        int count = 0;

        while (current.next != sentinel.next){
            if (count == index){
                return (template) current.item;
            }
            count ++;
            current = current.next;
        }

        System.out.println("Index is out of bounds for list");
        return null;
    }


    public void remove(template x){
        sentinel.prev = null;
        size = size - 1;
    }





}
