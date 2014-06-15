package com.laazer.common;

import java.util.Collection;

/**
 * 
 * @author laazer
 *
 * Used in other languages, a Box is a list containing 
 * a single element. Boxes are either full or empty
 * @param <T> type
 */
public abstract class Box <T> {
    public boolean isFull(){ return false;}
    public boolean isEmpty(){ return true;}
    public static Box EMPTY = Box.empty();
    public <B> Box<B> map(UniFunction<T, B> f){return Box.empty();}
    public T get() {
        if(this.isEmpty()) {
            throw new NullPointerException();
        }
        else return this.get();
    }
    /** trys to get whats in inside the box but if the box
     * is empty returns the default object
     * @param o default object
     */
    public Object getOrElse(Object o) {
        if(this.isFull()) return this.get();
        else return o;
    }
    /** trys to get whats in inside the box but if the box
     * is empty returns the default object. this will
     * never change the return type.
     * @param o default object
     */
    public T getOrElseKeepType(T t) {
        if(this.isFull()) return this.get();
        else return t;
    }
    private static Box empty() {
        return new Empty();
    }
    public static <K> Box<K> fill(K cat) {
       try { 
        return new Full<K>(cat);
       }
       catch(Exception e){return Box.EMPTY;}
    }
}

class Full<T> extends Box<T> {
    private T cat;
    public Full(T cat) {this.cat = cat;}
    public boolean isFull() {return true;}
    public <B> Box<B> map(UniFunction<T, B> f) {
        return new Full<B>(f.apply(this.cat));
    }
    public T get(){return this.cat;}
    
}

@SuppressWarnings("rawtypes")
final class Empty extends Box {
    public boolean equals(Object o) {
        if(o == null) return false;
        else return o instanceof Empty;
    }
    public int hashCode() {return 9001;}
}

