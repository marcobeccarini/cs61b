package deque;

public class LinkedListDeque<template>  implements Deque<template>{

    public class Node<template>{
        private template item;
        private Node next;
        private Node prev;

        public Node(template i, Node previousNode, Node nextNode){
            item = i;
            prev = previousNode;
            next = nextNode;
        }

    }


    private Node sentinel;
    private Node current;
    private int size;

    public LinkedListDeque()
    {
        Node newNode = new Node(0, null, null);
        sentinel = newNode;
        sentinel.next = newNode;
        sentinel.prev = newNode;
        current = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(template x){
        Node newNode = new Node(x, sentinel, sentinel.next);
        if(current == sentinel)
        {
            sentinel.prev = newNode;
       }
        sentinel.next.prev = newNode;
        current = newNode;
        sentinel.next = newNode;
        size = size + 1;
        
    }
    @Override
    public void addLast(template x){
        Node newNode = new Node(x, sentinel.prev, sentinel);
        if (current == sentinel){
            sentinel.next = newNode;
        }
        sentinel.prev.next = newNode;
        current = newNode;
        sentinel.prev = current;
        size = size + 1;

    }
    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){

        Node current = sentinel.next;
        while (current != sentinel)
        {
            System.out.print(current.item + " ");
            current = current.next;

        }
        System.out.println();
    }

    @Override
    public template get(int index) {

        Node current = sentinel.next;
        int count = 0;

        while (current != sentinel){
            if (count == index){
                return (template) current.item;
            }
            count ++;
            current = current.next;
        }

        System.out.println("Index is out of bounds for list");
        return null;
    }

    public template getRecursive(int index, int posRec) {

        if(posRec >= size){
            System.out.println("Index is out of bounds for list");
            return null;
        }

        if(posRec == index){
            return this.get(index);
        }

        return getRecursive(index, posRec +1);

    }

    @Override
    public template removeFirst()
    {
        if(sentinel.next == sentinel){
            return null;
        }
        template value = (template) sentinel.next.item;
        current = sentinel.next.next;
        sentinel.next.prev = null; //not necessary
        sentinel.next.next = null; //not necessary
        current.prev = sentinel;
        sentinel.next = current;
        size = size - 1;
        return value;
    }

    @Override
    public template removeLast()
    {
        if (sentinel.prev == sentinel){
            return null;
        }
        template value = (template) sentinel.prev.item;
        current = sentinel.prev.prev;
        sentinel.prev.prev = null; //not necessary
        sentinel.prev.next = null; //not necessary
        current.next = sentinel;
        sentinel.prev = current;
        size -= 1;
        return value;
    }

    public interface Iterator<template> {
        boolean hasNext();
        template next();
    }

    public Iterator<template> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<template>{
        private int pos;
        public LinkedListIterator(){
            pos = 0;
        }

        public boolean hasNext(){
            return pos<size;
        }

        public template next(){
            template returnItem = get(pos);
            pos = pos +1;
            return returnItem;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (other.getClass() != this.getClass()) {
            return false;
        }

        if(other instanceof LinkedListDeque){
            LinkedListDeque<template> ll = (LinkedListDeque<template>) other;

            if(this.size() != ll.size()){
                return false;
            }

            Iterator it = this.iterator();
            Iterator itO = ll.iterator();
            while (it.hasNext())
            {
                if (!it.next().equals(itO.next()))
                {
                    return false;
                }
            }
        }

        else return false;

        return true;
    }

}
