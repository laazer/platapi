package com.laazer.common.tests;

import static org.junit.Assert.*;
import com.laazer.common.Box;
import org.junit.Test;

/**
 * Created by jacob on 11/3/14.
 */
public class BoxSpec {

    Box<String> stringBox;
    Box<String> stringBox2;
    Box<String> stringBox3;
    Box<Integer> integerBox;
    Box<Integer> integerBox2;
    Box<Integer> integerBox3;
    Box<String>  empty1;
    Box<Integer> empty2;

    public void init() {
        stringBox = Box.fill("abc");
        stringBox2 = Box.fill("abc");
        stringBox3 = Box.fill("random");
        integerBox = Box.fill(1);
        integerBox2 = Box.fill(1);
        integerBox3 = Box.fill(3);
        empty1 = Box.EMPTY;
        empty2 = Box.EMPTY;
    }

    @Test
    public void testEquals() {
        init();
        assertTrue(empty1.equals(empty2));
        assertTrue(empty2.equals(empty1));
        assertTrue(stringBox.equals(stringBox2));
        assertTrue(!stringBox.equals(stringBox3));
        assertTrue(integerBox.equals(integerBox2));
        assertTrue(!integerBox.equals(integerBox3));
    }

    @Test
    public void testToString() {
        init();
        assertTrue(empty1.toString().equals("Box[]"));
        assertTrue(stringBox.toString().equals("Box[abc]"));
    }

}
