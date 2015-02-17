package sorting.algo.examples;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTester {
	
	private int[] arr;
	Sorting srt ; 
	
	@Before
	public void init(){
		srt =new Sorting();
		arr = new int [] {3,5,7,-1,10,100,0};
		srt.setArr(arr);
	}
	
	
	@After
	public void tearDown(){
		arr=null;
		srt=null;
	}
	
	private void preRunPrint(){
		int[] rawArr = new int[this.arr.length];
		srt.copyArr(rawArr);
		System.out.println("~~~~~BEFORE SORTING ~~~~~~~~~~~~~");
		srt.printArr(rawArr);
	}
	
	private void postRunPrint(int [] array){
		System.out.println("~~~~~AFTER SORT:~~~~~~~~~~~~~~~~~~");
		srt.printArr(array);
	}
	
	private void runSortAlgorithom(String sortType){
		this.preRunPrint();
		
		long startTime = System.nanoTime();
		int[] retArr= new int[this.arr.length];
		retArr=srt.getSortedArray(sortType);
		long stopTime = System.nanoTime();
	    double elapsedTime = (stopTime - startTime)/1e6;
	    System.out.println("Sort time taken by [ "+ sortType+" ] " + elapsedTime);
	    
	    this.postRunPrint(retArr);
	}
	
	//~~~~~~~~~~~~~~~QUICK SORT~~~~~~~~~~~~~~~	
	//
	// 	best= O(n log(n)) 	average=O(n log(n)) 	worst=O(n^2)
	//
	@Test
	public void quickSortTest (){
		runSortAlgorithom("quick");
	}

	
	//~~~~~~~~~~~~~~~~~MERGE SORT~~~~~~~~~~~~~~~~~~~~~~~~~	
	//
	// best=O(n log(n)) 	average=O(n log(n)) 	worst=O(n log(n))
	//
	@Test
	public void mergeSortTest (){
		runSortAlgorithom("merge");
	}
	
	//~~~~~~~~~~~~~~~~~SELECTION SORT~~~~~~~~~~~~~~~~~~~~~~~~~	
	//
	//  best O(n^2) 	avg O(n^2) 	worst O(n^2)
	//
	@Test
	public void selectionSortTest (){
		runSortAlgorithom("selection");
	}
	
	//~~~~~~~~~~~~~~~~~BUBBLE SORT~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	//  best O(n) 	avg O(n^2) 	worst O(n^2)    
	//
	@Test
	public void bubbleSortTest (){
		runSortAlgorithom("bubble");
	}
	
	//~~~~~~~~~~~~~~~~~HEAPSORT~~~~~~~~~~~~~~~~~~~~~~
    //
	// best=O(n log(n)) 	average=O(n log(n)) 	worst=O(n log(n))
	//
	@Test
	public void heapSortTest (){
		runSortAlgorithom("heap");
	}
}
