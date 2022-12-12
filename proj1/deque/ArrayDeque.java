package deque;

import java.util.Iterator;

public class ArrayDeque<template> implements Deque<template>{

    private template[] items;
    private int size;
    private int RFACTOR = 2;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque()
    {
        size = 0;
       items = (template[]) new Object[8];
       nextFirst = 0;
       nextLast = nextFirst+1;
    }

    private void resize(int newSize)
    {
        template[] newItems = (template[]) new Object[newSize];
        if (newSize > items.length){
            System.arraycopy(items, nextFirst + 1, newItems, 0, size - nextFirst - 1);
            System.arraycopy(items, 0 , newItems, size - nextFirst - 1, nextFirst + 1);

        }
        else if(newSize < items.length){
            if(nextFirst+1 >= items.length){
                nextFirst = -1;
            }
            System.arraycopy(items, nextFirst + 1, newItems, 0, nextLast-nextFirst - 1);
            System.arraycopy(items, nextLast , newItems, nextLast - nextFirst - 1 , newSize - nextLast + nextFirst + 1);
        }
        nextFirst = newSize - 1;
        nextLast = size;
        items = newItems;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void addFirst(template x){
        if(size == items.length){
            resize(size * RFACTOR);
        }

        items[nextFirst] = x;
        size = size + 1;
        nextFirst = nextFirst - 1;

        if(nextFirst<0)
        {
            nextFirst = items.length - 1;
        }

    }

    @Override
    public void addLast(template x){
        if(size == items.length){
            resize(size * RFACTOR);
        }

        items[nextLast] = x;
        size = size + 1;
        nextLast = nextLast + 1;

        if(nextLast>=items.length)
        {
            nextLast = 0;
        }
    }

    @Override
    public template removeFirst(){

        if(size == 0){
            return null;
        }

        if(items.length > 16){
            double usageRatio = (double) size/items.length;
            if(usageRatio < 0.25) {
                resize(items.length / RFACTOR);
            }
        }

        template removedItem = this.get(0);
        this.set(0, null);
        nextFirst = nextFirst + 1;
        if(nextFirst >= items.length){
            nextFirst = nextFirst - items.length;
        }
        size = size -1;
        return removedItem;
    }

    @Override
    public template removeLast(){

        if(size == 0){
            return null;
        }

        if(items.length > 16){
            double usageRatio = (double)size/items.length;
            if(usageRatio < 0.25) {
                resize(items.length / RFACTOR);
            }
        }


        template removedItem = this.get(size-1);
        this.set(size-1, null);
        nextLast = nextLast-1;
        if(nextLast < 0){
            nextLast = items.length + nextLast;
        }
        size = size -1;
        return removedItem;
    }


    @Override
    public void printDeque(){
        int i;
        for(i = nextFirst + 1; i != nextLast; i++){
            if(i>=items.length){
                i=0;
            }
            System.out.print(items[i].toString() + " ");
        }
        System.out.println();

    }

    @Override
    public template get(int index){
        index = nextFirst + index + 1;
        if (index>=items.length){
            index = index - items.length;
        }
        return items[index];
    }

    public void set(int index, template value){
        index = nextFirst + index + 1;
        if (index>=items.length){
            index = index - items.length;
        }
        items[index] = value;
    }

    public interface Iterator<template> {
        boolean hasNext();
        template next();
    }

    public ArrayDeque.Iterator<template> iterator(){
        return new ArrayDeque.ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements ArrayDeque.Iterator<template> {
        private int pos;
        public ArrayDequeIterator(){
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

        if(other instanceof ArrayDeque){
            ArrayDeque<template> ll = (ArrayDeque<template>) other;

            if(this.size() != ll.size()){
                return false;
            }

            ArrayDeque.Iterator it = this.iterator();
            ArrayDeque.Iterator itO = ll.iterator();
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
