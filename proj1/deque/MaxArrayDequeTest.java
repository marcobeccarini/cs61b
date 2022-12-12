package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void maxTest() {

        Comparator<String> compStrLen = new MaxArrayDeque.strLenComp();
        MaxArrayDeque<String> ad1 = new MaxArrayDeque<>(compStrLen);

        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());

        ad1.addFirst("a");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("lld1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("abc");
        assertEquals(2, ad1.size());

        ad1.addLast("abcde");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();


        assertEquals("abcde", ad1.max());

    }


    @Test
    public void maxTest2(){

        Comparator<String> compStrName = new MaxArrayDeque.letterComp();
        MaxArrayDeque<String> ad1 = new MaxArrayDeque<>(compStrName);

        ad1.addLast("f");
        ad1.addLast("bc");
        ad1.addFirst("dog");

        assertEquals("f", ad1.max(compStrName));

    }


}
