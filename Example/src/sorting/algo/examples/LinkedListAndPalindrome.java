package sorting.algo.examples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class LinkedListAndPalindrome {
	
	/**
	 * Find if a linked list (full of string)  is palindrome
	 * 
	 * 
	 */
	public boolean findPalindromeInLinkedList(LinkedList<String>ll){
		Stack<Character> stack=new Stack<Character>() ;
		
		boolean isPalindrome=true;
		ListIterator<String> it = ll.listIterator();
		
		while(it.hasNext()){ //Store all the character in a stack
			String tmp =it.next();
			char[] charArray = tmp.toCharArray();
			for(int j=0;j<charArray.length;j++){
				stack.push((Character)charArray[j]);
			}
		}

		int n =stack.size(),i=1;
		int mid= n/2+1; 

		// set Iterator as descending
		//Iterator<String> it2 = ll.descendingIterator();
		ListIterator<String> it2 = ll.listIterator();
		
		while(it2.hasNext()){ //now get the character from the rear of the list and pop from the
			// stack and compare . if true than  palindrome, otherwise not.
			String tmp =it2.next();
			char[] charArray = tmp.toCharArray();
			if(i<mid)
			{
					//for(int j=charArray.length-1;j>=0;j--){
					for(int j=0;j<charArray.length;j++){	
						char c = charArray[j];
						char countC= stack.pop();
						if(c!=countC){
							isPalindrome=false;
							i=mid;
							break;
						}
						i++;
					}
					
			}else
				break;
		}
		
		return isPalindrome;
	}

}
