package edu.luc.cs271.linkedstack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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
    try {
      fixture.poll();
      fail("java.util.NoSuchElementException expected");
    } catch (final NoSuchElementException ex) {
      // exception occurred => all good
    }
    try {
      fixture.peek();
      fail("java.util.NoSuchElementException expected");
    } catch (final NoSuchElementException ex) {
      // exception occurred => all good
    }
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
}
