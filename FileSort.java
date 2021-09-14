package Simpligradedprojects;

public class FileSort {

	public void merge(String arr[], int lb1, int mid1, int ub1) {
						
					// Find sizes of two subarrays to be merged
					int n1 = mid1 - lb1 + 1;
					int n2 = ub1 - mid1;

					/* Create temp arrays */
					String L[] = new String [n1];
					String R[] = new String [n2];

					/*Copy data to temp arrays*/
					for (int i=0; i<n1; ++i)
						L[i] = arr[lb1 + i];
					for (int j=0; j<n2; ++j)
						R[j] = arr[mid1 + 1+ j];


					/* Merge the temp arrays */

					// Initial indexes of first and second subarrays
					int i = 0, j = 0;

					// Initial index of merged subarray 
					int k = lb1;
					while (i < n1 && j < n2)
					{
						if(L[i].compareToIgnoreCase(R[j])<=0)
							
						{
							arr[k] = L[i];
							i++;
						}
						else
						{
							arr[k] = R[j];
							j++;
						}
						k++;
					}

					/* Copy remaining elements of L[] if any */
					while (i < n1)
					{
						arr[k] = L[i];
						i++;
						k++;
					}

					/* Copy remaining elements of R[] if any */
					while (j < n2)
					{
						arr[k] = R[j];
						j++;
						k++;
					}
				}

		/* Method to print array of size n */
	public  void printArray(String arr[])
	 {
		 int n = arr.length;
		 for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
			//System.out.println();
	  }	
	
	public void mergesort(String[] array1,int lb2, int ub2){
	 if(lb2 < ub2)
	 {
		 int mid =(lb2+ub2)/2;
		
		 mergesort(array1,lb2,mid);
		 mergesort(array1,mid+1,ub2);
		 merge(array1,lb2,mid,ub2);		
		
	 }
	}
}