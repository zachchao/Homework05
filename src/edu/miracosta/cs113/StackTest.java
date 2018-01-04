package edu.miracosta.cs113;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class StackTest {
	/**
	 * Test the empty method
	 * Assumes the push works
	 */
	@Test
	public void emptyTest() {
		Stack<Integer> stack = new Stack<Integer>();
		assertEquals(true, stack.empty());
		stack.push(0);
		assertEquals(false, stack.empty());
	}
	
	/**
	 * Test the peek method
	 * Assumes the push works
	 */
	@Test
	public void peekTest() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		assertEquals(5, (int)(stack.peek()));
		//Makes sure the item was not removed
		assertEquals(5, (int)(stack.peek()));
		//Tests another insertion
		stack.push(7);
		assertEquals(7, (int)(stack.peek()));
	}
	
	/**
	 * Test the peek method when stack is empty
	 * Assumes the push works
	 */
	@Test(expected = EmptyStackException.class)
	public void peekOutOfBoundsTest() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.peek();
	}
	
	/**
	 * Tests both the pop and push methods
	 */
	@Test
	public void pushPopTest() {
		Stack<Integer> stack = new Stack<Integer>();
		//Add 0-9
		for(int i = 0; i < 10; i++) {
			stack.push(i);
		}
		//Assert correct removal
		for(int i = 9; i >= 0; i--) {
			assertEquals(i, (int)(stack.pop()));
		}
	}
	
	/**
	 * Test the pop method when stack is empty
	 */
	@Test(expected = EmptyStackException.class)
	public void popOutOfBoundsTest() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.pop();
	}
	
	/**
	 * Test the pop method for removing
	 * Assumes the push works and pop throws correct error
	 */
	@Test(expected = EmptyStackException.class)
	public void popRemovalTest() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.pop();
		stack.pop();
	}
}
