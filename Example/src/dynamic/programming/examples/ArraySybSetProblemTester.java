package dynamic.programming.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArraySybSetProblemTester {
	
	private ArraySubSetProblem arrProb;
	
	@Before
	public void init(){
		arrProb=new ArraySubSetProblem();
	}
	
	@After
	public void tearDown(){
		arrProb=null;
	}
	
	@Test
	public void test1(){
		//int [] arr= {3, 2, 11, 14, 4, 5};
		//int sum=5;
		int [] arr= {5, 2, 3, 14, 8, 10};
		int sum=10;
		
		
		arrProb.setArr(arr);
		arrProb.setSum(sum);
		int [] subSetArr= arrProb.subsetSumDyn();
	}

}
