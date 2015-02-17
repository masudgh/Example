package dynamic.programming.examples;

import java.util.ArrayList;
import java.util.List;

/*Def:Maximum Integer Knapsack (max-knapsack)
* We have n objects and a knapsack.
* The i-th object has positive weight wi and positive value vi.
* The knapsack capacity is C.
* We wish to select a set of objects to put in the knapsack so that the total values
* is maximum and without breaking the knapsack.

 * 
 * 
 * 
 * The knapsack problem or rucksack problem is a problem in combinatorial optimization: Given a set of items, 
 * each with a mass and a value, determine the number of each item to include in a collection so that the total weight is less 
 * than or equal to a given limit and the total value is as large as possible.
 * he most common problem being solved is the 0-1 knapsack problem, which restricts the number xi of copies of each kind of item to zero or one.

* Mathematically the 0-1-knapsack problem can be formulated as:
* Let there be n items, z_1 to z_n where z_i has a value v_i and weight w_i. x_i is the number of copies of the item z_i, 
* which, mentioned above, must be zero or one. The maximum weight that we can carry in the bag is W. It is common to assume 
* that all values and weights are nonnegative. To simplify the representation, we also assume that the items are listed in 
* increasing order of weight.
* Maximize \qquad \sum_{i=1}^n v_ix_i subject to \qquad \sum_{i=1}^n w_ix_i \leqslant W, \quad \quad x_i \in \{0,1\}
 */
public class KnapsackProblem {
	
	private int []itemWeight;
	private int []ItemValues;
	private int maxWeight;
	
	
	
	public KnapsackProblem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int[] getItemWeight() {
		return itemWeight;
	}


	public int[] getItemValues() {
		return ItemValues;
	}


	public int getMaxWeight() {
		return maxWeight;
	}


	public void setItemWeight(int[] itemWeight) {
		this.itemWeight = itemWeight;
	}


	public void setItemValues(int[] itemValues) {
		ItemValues = itemValues;
	}


	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}


	public List<Integer> knapsackAlgorithm01(){
		if(itemWeight.length>0 && ItemValues.length>0 && maxWeight >=0)
			return applyKnapsackAlgorithm01();
		else
			return null;
	}
	
	
	private List<Integer> applyKnapsackAlgorithm01(){
		int W= maxWeight;
		int n = ItemValues.length;
		
		int[][] knapsackTable= new int [n+1][W+1];
		List<Integer>knapsackItems = new ArrayList<Integer>();
		for (int w=0;w<=W;w++){
			knapsackTable[0][w] = 0;
		}
				
		for (int i = 1;i<=n;i++){
			knapsackTable[i][0] = 0;
		}
				
		for (int i = 1 ; i<=n;i++){  //Generate knapsackTable table
				for(int w = 1;w<=W;w++){
					if ( itemWeight[i-1]<= w ){// item i can be part of the solution
						if (ItemValues[i-1] + knapsackTable[i-1][w-itemWeight[i-1]] > knapsackTable[i-1][w])
							knapsackTable[i][w] = ItemValues[i-1] + knapsackTable[i-1][w-itemWeight[i-1]];
						else
							knapsackTable[i][w] =  knapsackTable[i-1][w];
					}else{
						knapsackTable[i][w] = knapsackTable[i-1][w]; // wi > w
					}
				}
		}
		int j=n;
		int k=W;

		while(j>0 && k>0){
			if(knapsackTable[j][k]!= knapsackTable[j-1][k]){
				knapsackItems.add(j);
				
				k=k-itemWeight[j-1];
				j--;
				
			}else
				j--;
		}
		return knapsackItems;
	}

}
