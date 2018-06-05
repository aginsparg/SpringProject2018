package edu.luc.cs271.linkedstack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.Map;

public class TestLevelIllness {

    private LevelIllness fixture;
Map<String, String> testing;
    @Before
    public void setUp() {
        fixture = new LevelIllness();
        testing = fixture.fillMap();
    }

    @After
    public void tearDown() {
        fixture = null;
    }

 @Test
    public void testMapFillingUp(){

     assertEquals("1 Brought in Ambulance", testing.get("0"));
     assertEquals("1 Heart Failure", testing.get("11"));
     assertEquals("1 Heart Attack", testing.get("12"));
     assertEquals("2 Heart Palpitations - long duration", testing.get("13Y"));
     assertEquals("3 Heart Palpitations - short duration", testing.get("13N"));
     assertEquals("1 Unconscious", testing.get("2Y"));
     assertEquals("2 Losing Conscious - long duration", testing.get("2NY"));
     assertEquals("3 Losing conscious - short duration", testing.get("2NN"));
     assertEquals("1 3rd degree burn - all body", testing.get("33Y"));
     assertEquals("2 3rd degree burn - part body", testing.get("33N"));
     assertEquals("2 2nd degree burn - all body", testing.get("32Y"));
     assertEquals("3 2nd degree burn - face", testing.get("32NY"));
     assertEquals("4 2nd degree burn - part body - not face", testing.get("32NN"));
     assertEquals("4 1st degree burn - all body", testing.get("31Y"));
     assertEquals("5 1st degree burn - part body", testing.get("31N"));

     assertEquals(38, testing.size());
 }
}
