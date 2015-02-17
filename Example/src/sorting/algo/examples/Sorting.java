package sorting.algo.examples;

import java.util.Arrays;

public class Sorting {
	
	private int [] arr;
	
	public Sorting() {
		super();
	}

	public int[] getArr() {
		return arr;
	}


	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int [] getSortedArray(String sortType){
		int [] retArr = null;
		if(arr!=null)
		{
			retArr = new int[arr.length];
			this.copyArr(retArr);
			
			if(sortType=="quick"){
				int start = 0,end = arr.length-1;
				this.doQuickSort (retArr,start,end);
			}else if (sortType=="merge"){
				this.doMergeSort(retArr);
			}else if (sortType=="selection"){
				this.doSelectionSort(retArr);
			}else if (sortType=="bubble"){
				this.doBubbleSort(retArr);
			}else if (sortType=="heap"){
				this.doHeapSort(retArr);
			}
		}
		return retArr;
	}

	/**
	 * MERGE SORT
	 * best=O(n log(n)) 	average=O(n log(n)) 	worst=O(n log(n))	
	 * @param A
	 */
	private void doMergeSort(int[] A) {
        if (A.length > 1) {
            int q = A.length/2;

            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A,q,A.length);

            doMergeSort(leftArray);
            doMergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
    }

    static void merge(int[] a, int[] l, int[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;
    }
		
	    
	
    /**
     *   QUICK SORT
     *   best= O(n log(n)) 	average=O(n log(n)) 	worst=O(n^2)
     * @param array
     * @param start
     * @param end
     */
	private void  doQuickSort (int [] array, int start, int end){
		
		int i = start;                          // index of left-to-right scan
        int k = end;                            // index of right-to-left scan

        if (end - start >= 1)                   // check that there are at least two elements to sort
        {
            int pivot = array[start];       // set the pivot as the first element in the partition

            while (k > i)                   // while the scan indices from left and right have not met,
            {
                    while (array[i] <= pivot && i <= end && k > i)  // from the left, look for the first
                            i++;                                    // element greater than the pivot
                    while (array[k] > pivot && k >= start && k >= i) // from the right, look for the first
                        k--;                                        // element not greater than the pivot
                    if (k > i)                                       // if the left seekindex is still smaller than
                            swap(array, i, k);                      // the right index, swap the corresponding elements
                   // System.out.println(Arrays.toString(array));        
            }
            swap(array, start, k);          // after the indices have crossed, swap the last element in
                                            // the left partition with the pivot 
           // System.out.println(Arrays.toString(array));
          //  System.out.println("start:"+start+"k:"+k+"end:"+end);
            doQuickSort(array, start, k - 1); // quicksort the left partition
            doQuickSort(array, k + 1, end);   // quicksort the right partition
        }
    }
		


	
	
	/**
	 * SELECTION SORT
	 * best O(n^2) 	avg O(n^2) 	worst O(n^2)
	 * @param num
	 */
	 private void doSelectionSort ( int [ ] num )
     {
         int i, j, first, temp; 
         for ( i=num.length-1; i > 0; i-- ) 
         {
              first = 0;   //initialize to subscript of first element
              for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
              {
                   if( num[ j ] > num[ first ] )         
                     first = j;
              }
              swap(num, first, i);
          }           
      }
 
	 /**
	  *  BUBBLE SORT
	  *  best O(n) 	avg O(n^2) 	worst O(n^2) 
	  * @param num
	  */
	 private void doBubbleSort(int [] num){
	    	
    	 int j;
         boolean flag = true;   // set flag to true to begin first pass

         while ( flag )
         {
                flag= false;    //set flag to false awaiting a possible swap
                for( j=0;  j < num.length -1;  j++ )
                {
                       if ( num[ j ] > num[j+1] )   // change to > for ascending sort
                       {
                    	   swap(num, j,j+1);
                           flag = true;              //shows a swap occurred 
                      }
                }
          } 
    }


	/**
	 *    HEAPSORT 
	 *    best=O(n log(n)) 	average=O(n log(n)) 	worst=O(n log(n))
	 * @return
	 */
	public void doHeapSort (int [] array){
		
		int N = array.length-1;
	    heapify(array);        
	    for (int i = N; i > 0; i--)
	    {
	        swap(array,0, i);
	        N = N-1;
	        maxheap(array, 0);
	    }
	}
	
	/* Function to build a heap */   
	
	private  void heapify(int arr[])
	
	{
	    int N = arr.length-1;
	    for (int i = N/2; i >= 0; i--)
	        maxheap(arr, i);        
	}
	
	/* Function to swap largest element in heap */        
	
    private void maxheap(int arr[], int i)

    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        int N = arr.length-1;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 

        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    	 
	 

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * HELPER FUNTIONS
	 * 
	 */
	private void swap(int array[], int index1, int index2) 
	// pre: array is full and index1, index2 < array.length
	// post: the values at indices 1 and 2 have been swapped
	{
		int temp = array[index1];           // store the first value in a temp
		array[index1] = array[index2];      // copy the value of the second into the first
		array[index2] = temp;               // copy the value of the temp into the second
	}
	public void copyArr(int Array[]){
		for(int i =0;i<this.arr.length;i++)
			Array[i]= this.arr[i];
	}
	
	public void printArr(int [] array){
		String tmp="";
		for(int i=0;i<array.length;i++)
			tmp+=array[i]+" ";
		System.out.println(tmp);
	}
}
