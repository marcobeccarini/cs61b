package deque;

import java.util.Comparator;

public class MaxArrayDeque<template> extends ArrayDeque<template> {

    private Comparator<template> comparator;

    public MaxArrayDeque(Comparator<template> c){
        super();
        comparator = c;
    }

    public template max(){
        return max(comparator);
    }

    public template max(Comparator<template> comparator){
        if(this.isEmpty()){
            return null;
        }

        template max = get(0);
        for(int i = 0; i < this.size(); i++ )
        {
            template current = get(i);
            if(comparator.compare(current, max) > 0){
                max = current;
            }
        }

        return max;
    }

    public static class strLenComp implements Comparator<String>{
        public int compare(String str1, String str2){
            return str1.length()-str2.length();
        }
    }

    public static class letterComp implements Comparator<String>{
        public int compare(String str1, String str2){
            return str1.compareTo(str2);
        }
    }

}
