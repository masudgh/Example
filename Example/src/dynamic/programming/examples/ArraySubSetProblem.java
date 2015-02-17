package dynamic.programming.examples;

import org.junit.Test;

public class ArraySubSetProblem {

	/* ARRAY SUB-SET PROBLEM for ANY combination of item
	 * 
	 * 
	 */
	private int [] Arr;
	int sum;
	
	
	public int[] getArr() {
		return Arr;
	}

	public int getSum() {
		return sum;
	}

	public void setArr(int[] arr) {
		Arr = arr;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int[] subsetSumDyn(){
		if(Arr.length==0)
			return null;
		else
			return doSubsetSumDyn();
	}
	
	private int [] doSubsetSumDyn()
	{
		int len = Arr.length;
		int [] [] ResultTable = new int [len+1][sum+1];
	    int i,j;

	    for(j=0; j<=sum; j++)
	        ResultTable[0][j] = 0;
	    
	    for(i=0; i<=len; i++)
	        ResultTable[i][0] = 1;

	    for(i=1; i<=len; i++)
	    {
	        for(j=1; j<=sum; j++)
	        {
	            int index = j - Arr[i-1];
	            if(index >=0){
	            	int a = ResultTable[i-1][j];
	            	int b = ResultTable[i-1][index];
	            	int c = a|b;
	            	ResultTable[i][j] = c; //ResultTable[i-1][j] | ResultTable[i-1][index];
	                
	            } else{
	                int a = ResultTable[i-1][j];
	            	ResultTable[i][j] = a;//ResultTable[i-1][j];
	            }
	        }
	    }
	    
	    for ( j = sum; j > 0; j--) {
			    for (i = len; i > 0; i--) {
			    	int a=ResultTable[i][j];
			    	while (ResultTable[i][j] == 0) {
				    	if (j >= Arr[i]) {
				    		j = j - Arr[i];
				    		System.out.println("[" + j + "," + (sum-j) + "]" + "--->" + sum);
				    		//System.out.println("[" + j + "," + i + "]" + "--->" + Arr[i]);
				    	}
			
				    	while (j > 0 && i > 0 && ResultTable[j][i] != 0) {
				    		i--;
				    	}
			    }
		    }
	    }
	    
	    return null;
	}
}
