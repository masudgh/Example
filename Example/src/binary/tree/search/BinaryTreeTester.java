package binary.tree.search;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTester {
	
	private BinarySearchTree bst;
	@Before
	public void init(){
		//int[] arr ={3,4,5,1,-5,10,7,9};
		int[] arr ={11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31};
		bst =new BinarySearchTree();
		for(int i=0;i<arr.length;i++){
			bst.insert(arr[i]);
		}
	}
	@After
	public void tearDown(){
		bst =null;
	}

	@Test
	public void printTree(){
		bst.printTree();
	}
	
	@Test
	public void removeElement(){
		bst.remove(5);
		bst.printTree();
		
	}
	
	@Test
	public void findElement(){
		int ele=(Integer) bst.find(130);
		System.out.println("Element :"+ele);
		ele=(Integer) bst.find(5);
		System.out.println("Element :"+ele);
		
	}
	
	@Test
	public void usingTreeSet(){
		TreeSet<Integer> ts =new TreeSet<Integer>();
		int[] arr ={11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31};
		for(int i=0;i<arr.length;i++){
			ts.add(arr[i]);
		}
		System.out.println("Elements:" +ts.toString());
		
	}
	
	@Test
	//O(n) time and O(n) space
	/*
	 * Given an array with different numbers and a number of C,so how to find all the combinations which the sum is C.
	 * .like..array={1,2,3,4},C=3,,return is 2,which contains two combinations{{1,2},{3}}.
	 * 	
	 * Same Question in different format
	 * You have a binary search tree and you have to return the two nodes such that there sum i equal to ‘K’. 
	 * pseudo code is to be given. O(n)time & O(n) sppace is easy but challenge O(n) time & O(1) space.

	 */
	public void findPairWhichSumIsGiven(){
		int givenSum=15;
		//int[] arr ={11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31};
		System.out.println("Sorted Elements:" +bst.toString());
		
		int[] sortedArr= bst.toArray();
		//while
		int start = 0;
		int end =sortedArr.length-1;
		boolean pairFound = false;
		while(start!=end){
			int tmpVal = sortedArr[start]+sortedArr[end];
			if(tmpVal==givenSum){
				pairFound=true;
				System.out.println("Matched Pair Elements:" +sortedArr[start]+" "+sortedArr[end]);
			}
			if(tmpVal>givenSum){
				end--;
			}else
				start++;
		}
	}
	
	@Test
	//O(n) time and O(1) space
	/* ARRAY SUB-SET PROBLEM for a combination of two item only
	 * Given an array with different numbers and a number of C,so how to find all the combinations which the sum is C.
	 * .like..array={1,2,3,4},C=3,,return is 2,which contains two combinations{{1,2},{3}}.
	 * 
	 * Same Question in different format
	 * You have a binary search tree and you have to return the two nodes such that there sum i equal to ‘K’. 
	 * pseudo code is to be given. O(n)time & O(n) sppace is easy but challenge O(n) time & O(1) space.
	 */
	public void findPairWhichSumIsGivenUsingTreeSet(){
		int givenSum=15;
		int[] arr ={11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31};
		//int givenSum=4;
		//int [] arr ={13, 21, 11, 14, 4, 5};
				
		TreeSet<Integer> ts =new TreeSet<Integer>();
		
		for(int i=0;i<arr.length;i++){
			ts.add(arr[i]);
		}
		System.out.println("Sorted Elements:" +ts.toString());
		
		Iterator<Integer> itStart = ts.iterator();
		Iterator<Integer> itEnd = ts.descendingIterator();
		int startVal = 0;
		if(itStart.hasNext())
			startVal= (int)itStart.next();
		
		int endVal = 0;
		if(itEnd.hasNext())
			endVal= (int)itEnd.next();
		
		while(startVal!=endVal){
			if(startVal+endVal==givenSum){
				System.out.println("Matched Pair Elements:" +startVal+" "+endVal);
			}
			if(startVal+endVal>givenSum){
				if(itEnd.hasNext()) 
					endVal= (int)itEnd.next();
			}else{
				if(itStart.hasNext()) 
					startVal= (int)itStart.next();
			}
		}
		
	}
	
	
	
	
}
