package sorting.algo.examples;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class LinkedListAndPalindromeTester {
	
	private LinkedListAndPalindrome testObj;
	@Before
	public void init(){
		this.testObj = new LinkedListAndPalindrome();
		
	}
	
	@Test
	public void testEvenList(){
		  LinkedList<String> ll = new LinkedList<String>();
	      // add elements to the linked list
	      ll.add("a");
	      ll.add("bcd");
	      ll.add("ef");
	      ll.add("g");//mid
	      ll.add("f");
	      ll.add("ed");
	      ll.add("c");
	      ll.add("ba");
	      printLL(ll);
	      boolean flag= testObj.findPalindromeInLinkedList(ll);
	      assertEquals(flag,true);
	}
	
	@Test
	public void testOddList(){
		  LinkedList<String> ll = new LinkedList<String>();
	      // add elements to the linked list
	      ll.add("a");
	      ll.add("bc");
	      ll.add("d");
	      ll.add("ef");
	      ll.add("g"); //mid
	      ll.add("f");
	      ll.add("ed");
	      ll.add("c");
	      ll.add("ba");
	      printLL(ll);
	      boolean flag= testObj.findPalindromeInLinkedList(ll);
	      assertEquals(flag,true);
	}

	
	@Test
	public void testOddList2(){
		  LinkedList<String> ll = new LinkedList<String>();
	      // add elements to the linked list
	      ll.add("adaaaa");
	      ll.add("bc");
	      ll.add("d");
	      ll.add("ef");
	      ll.add("g"); //mid
	      ll.add("f");
	      ll.add("ed");
	      ll.add("c");
	      ll.add("bawwww");
	      printLL(ll);
	      boolean flag= testObj.findPalindromeInLinkedList(ll);
	      assertEquals(flag,false);
	}

	
	public void printLL(LinkedList<String>ll){
		 System.out.println("Normal traversal");
		    for(Iterator<String> i = ll.iterator(); i.hasNext();) {
		        System.out.println(i.next());
		    }
	}
}
