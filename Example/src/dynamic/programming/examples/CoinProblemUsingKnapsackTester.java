package dynamic.programming.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoinProblemUsingKnapsackTester {
	int [] valItems = new int [] {3,4,5,6};
	int [] weightItems = new int [] {2,3,4,5};
	KnapsackProblem kp;
	
	@Before
	public void init (){
		kp =new KnapsackProblem();
		kp.setItemValues(valItems);
		kp.setItemWeight(weightItems);
		kp.setMaxWeight(5);
	}
	
	
	@After
	public void tearDown(){
		kp=null;
	}
	
	@Test
	public void test1(){
		List<Integer> knapsackItems = new ArrayList<Integer>( kp.knapsackAlgorithm01());
		int knapsack=0;
		Iterator<Integer> it = knapsackItems.iterator();
		while(it.hasNext())
			knapsack +=valItems[it.next()-1];
		
		System.out.println( " knapsack : "+knapsack);
		System.out.println( " Items : "+knapsackItems.toString());
	}

}
