package edu.luc.cs271.linkedstack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TestLinkedQueue {

  private MyQueue<String> fixture;

  @Before
  public void setUp() {
    fixture = new LinkedQueue<>();
  }

  @After
  public void tearDown() {
    fixture = null;
  }


  @Test
  public void testInitial() {
    assertTrue(fixture.isEmpty());
assertNull(fixture.poll());
assertNull(fixture.peek());
  }

  @Test
  public void testAfterOffer() {
    final String value = "hello";
    fixture.offer(value);
    assertFalse(fixture.isEmpty());
    assertEquals(value, fixture.peek());
  }

  @Test
  public void testOfferThenPoll() {
    final String value = "hello";
    fixture.offer(value);
    assertEquals(value, fixture.poll());
    assertTrue(fixture.isEmpty());
  }

  @Test
  public void testOffer2ThenPop2() {
    final String value1 = "4 hello";
    final String value2 = "5 world";
    fixture.offer(value1);
    fixture.offer(value2);
    assertEquals(value1, fixture.poll());
    assertEquals(value2, fixture.poll());
    assertTrue(fixture.isEmpty());
  }

  @Test
  public void testAsListEmpty() {
    assertEquals(0, fixture.asList().size());
  }

  @Test
  public void testAsListNonempty() {
    final String value1 = "4 hello";
    final String value2 = "5 world";
    fixture.offer(value1);
    fixture.offer(value2);
    final List<String> list = fixture.asList();
    assertEquals(2, list.size());
    assertEquals(Arrays.asList(value1, value2), list);
   final List<String> list2 = fixture.asList();
   assertEquals(2, list2.size());
  }

  @Test
    public void testPrioritize(){

      final String value1 = "5 world";
      final String value2 = "6 sing";
      final String value3 = "4 hello";
      final String value4 = "5 worldafter";
      final String value5 = "1 first";

      fixture.offer(value1);
      fixture.offer(value2);
      fixture.offer(value3);
      fixture.offer(value4);
      fixture.offer(value5);

      final List<String> list = fixture.asList();
      assertEquals(Arrays.asList(value5, value3, value1, value4, value2), list);

  }

  @Test
  public void testPrioritizeII(){

    final String value1 = "5 world";
    final String value4 = "5 worldafter";

    fixture.offer(value1);
    fixture.offer(value4);

    final List<String> list = fixture.asList();
    assertEquals(Arrays.asList(value1, value4), list);
  }

  @Test
  public void testPrioritizeIII(){

    final String value1 = "5 world";
    final String value2 = "6 sing";
    final String value4 = "5 worldafter";

    fixture.offer(value1);
    fixture.offer(value2);
    fixture.offer(value4);

    assertEquals(value1, fixture.poll());
    assertEquals(value4, fixture.poll());
    assertEquals(value2, fixture.poll());

  }

  @Test
  public void testPrioritizeIV(){

    final String value1 = "3 heart";
    final String value2 = "1 ambulance1";
    final String value3 = "2 numb";
    final String value4 = "5 cut";
    final String value5 = "4 ill";
    final String value6 = "2 3 burn";
    final String value7 = "1 unconscious";
    final String value8 = "4 2 burn";
    final String value9 = "3 conscious short";
    final String value10 = "1 ambulance2";


    fixture.offer(value1);
    fixture.offer(value2);
    fixture.offer(value3);
    fixture.offer(value4);
    fixture.offer(value5);
    fixture.offer(value6);
    fixture.offer(value7);
    fixture.offer(value8);
    fixture.offer(value9);
    fixture.offer(value10);

    final List<String> list = fixture.asList();
    assertEquals(Arrays.asList(value2, value7, value10, value3, value6, value1, value9, value5, value8, value4), list);

  }


  @Test
  public void testPrioritizeV(){

    final String value1 = "3 heart";
    final String value2 = "1 ambulance1";
    final String value3 = "2 numb";
    final String value4 = "5 cut";
    final String value5 = "4 ill";
    final String value6 = "2 3 burn";
    final String value7 = "1 unconscious";
    final String value8 = "4 2 burn";
    final String value9 = "3 conscious short";
    final String value10 = "1 ambulance2";


    fixture.offer(value1);
    fixture.offer(value2);
    fixture.offer(value3);
    fixture.offer(value4);
    fixture.offer(value5);
    fixture.offer(value6);
    fixture.offer(value7);
    fixture.offer(value8);
    fixture.offer(value9);
    fixture.offer(value10);

    final List<String> list = fixture.asList();
    assertEquals(Arrays.asList(value2, value7, value10, value3, value6, value1, value9, value5, value8, value4/* value7, value10, value3, value6, value1, value9, value5, value8, value4*/), list);

  }
}
