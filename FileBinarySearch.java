package Simpligradedprojects;

public class FileBinarySearch {	
	
	public  int BinarySearch(String[] array,String key1) {
		 int min = 0;
		 int max = array.length - 1;
		 int mid;
		 String key = key1;
		while (min <= max) {
			mid = (min + max) / 2;
			if (array[mid].compareTo(key) < 0)
			{
				min = mid + 1; 
			} 
			else if (array[mid].compareTo(key) > 0)
			{
				max = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}


			
				
			
		
	

