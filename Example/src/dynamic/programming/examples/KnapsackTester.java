package dynamic.programming.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KnapsackTester {
	
	KnapsackProblem kp;
	
	@Before
	public void init (){
		kp =new KnapsackProblem();
		
	}
	
	
	@After
	public void tearDown(){
		kp=null;
	}
	
	@Test
	public void test1(){
		int [] valItems = new int [] {4,5,7};
		int maxVal = 13;
		int [] weightItems = new int [] {2,5,7};
		kp.setItemValues(valItems);
		kp.setItemWeight(weightItems);
		kp.setMaxWeight(maxVal);
		
		List<Integer> knapsackItems = new ArrayList<Integer>( kp.knapsackAlgorithm01());
		int knapsack=0;
		Iterator<Integer> it = knapsackItems.iterator();
		while(it.hasNext())
			knapsack +=valItems[it.next()-1];
		
		System.out.println( " knapsack : "+knapsack);
		System.out.println( " Items : "+knapsackItems.toString());
	}
	
	
}
