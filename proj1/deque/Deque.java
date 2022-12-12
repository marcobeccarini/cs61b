package deque;

public interface Deque<template> {

    void addFirst(template item);
    void addLast(template item);
    default boolean isEmpty(){
        return size() == 0;
    }
    int size();
    void printDeque();
    template removeFirst();
    template removeLast();
    template get(int index);

}
