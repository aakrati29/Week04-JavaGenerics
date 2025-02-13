package com.example.day02collection.listinterface.findthenthelementfromend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class SearchElementFromEndTest {

    @Test
    public void testSearchElementFromEnd_ValidInput() {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('A');
        ll.add('B');
        ll.add('C');
        ll.add('D');
        ll.add('E');

        assertEquals('C', SearchElementFromEnd.searchElementFromEnd(ll, 3));
    }

    @Test
    public void testSearchElementFromEnd_NotEnoughElements() {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('A');
        ll.add('B');

        assertNull(SearchElementFromEnd.searchElementFromEnd(ll, 3));
    }

    @Test
    public void testSearchElementFromEnd_EmptyList() {
        LinkedList<Character> ll = new LinkedList<>();

        assertNull(SearchElementFromEnd.searchElementFromEnd(ll, 1));
    }

    @Test
    public void testSearchElementFromEnd_NIsZero() {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('A');
        ll.add('B');
        ll.add('C');

        assertNull(SearchElementFromEnd.searchElementFromEnd(ll, 'A'));
    }
}

