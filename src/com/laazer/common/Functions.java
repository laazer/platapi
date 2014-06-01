package com.laazer.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing common functions
 * @author Jacob
 *
 */
public class Functions {

    public static UniFunction<Object, String> toString = new ToString();
    private static class ToString implements UniFunction<Object, String> {
        @Override
        public String apply(Object value) {
            return value.toString();
        }
    }
    
    public static UniFunction<Object, Double> toDouble = new ToDouble();
    private static class ToDouble implements UniFunction<Object, Double> {
        @Override
        public Double apply(Object value) {
            return (Double) value;
        }
    }
    
    public static UniFunction<Object, Integer> toInt = new ToInt();
    private static class ToInt implements UniFunction<Object, Integer> {
        @Override
        public Integer apply(Object value) {
            return (Integer) value;
        }
    }
    
    public static BinFunction<List, List, List> append = new Append();
    private static class Append<T> implements BinFunction<List<T>, List<T>, List<T>> {
        public List<T> apply(List<T> value1, List<T> value2) {
            List<T> result = new ArrayList<T>();
            result.addAll(value1); result.addAll(value2);
            return result;
        }
    }
    
}