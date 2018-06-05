package edu.luc.cs271.linkedstack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestPatient {

    private Patient fixture;

    @Before
    public void setUp() {
        fixture = new Patient("Bob", 25);
    }

    @After
    public void tearDown() {
        fixture = null;
    }

    @Test
    public void testgetName(){

        assertEquals("Bob", fixture.getName());
    }

    @Test
    public void testgetAge(){
        assertEquals(25, fixture.getAge());
    }

}
