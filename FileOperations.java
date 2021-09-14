package Simpligradedprojects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class FileOperations {
	
	public	void displayallfiles() {
					
			FileSort fs = new FileSort();
		    File f = new File("C:\\Phase1-finalproj");
	        String[] s =f.list(); 	       
	        int length = s.length;
	        int lb=0;
	        int ub=length;	      
	        fs.mergesort(s,lb,ub-1);
	        System.out.println("                             ");
	        System.out.println("File names are being displayed in ascending order");
	        System.out.println("                             ");
	        fs.printArray(s); 
	       
	}
				
    public void createfile(String fname1) {
    	File f = new File("C:\\Phase1-finalproj\\",fname1);
		if(f.exists()) {
			System.out.println("                       ");
			System.out.println("File with this name already exists");
		}else {		
		try {
			f.createNewFile();
		} catch (Exception e) {		
			e.printStackTrace();
		}
		System.out.println("                  ");
		System.out.println("New File is created");
		}
	 }
    
    public void searchfile(String k) {    	
        
    	FileBinarySearch fb = new FileBinarySearch();
	    File f = new File("C:\\Phase1-finalproj");
        String[] s =f.list();
       // int size=s.length;
    	Arrays.sort(s);        //CASE SENSITIVITY added
    	for(String s1:s) {
	    	   System.out.println(s1);
	       }
    	int result= fb.BinarySearch(s,k);
    	if (result == -1) {
    		System.out.println("                             ");
            System.out.println("File does not exist/File is CASESENSITIVE/File extension missing");
            
            }
        else {
        	System.out.println("                             ");
            System.out.println("File found at index  " +result+" at location  C:\\Phase1-finalproj\\");}
		
	 }
    
    public void deletefile(String fname1)throws Exception {
    	 File file = new File("C:\\Phase1-finalproj\\",fname1);         
         if(file.delete())
         {
        	 System.out.println("                             ");
             System.out.println("File deleted successfully");
         }       
	}
    
    public void writetofile(String fname1,String text)throws Exception {
    	
    	  
    	  String fileName =String.format("C:\\Phase1-finalproj\\%s",fname1);		
    	  try{    
              FileOutputStream fout=new FileOutputStream(fileName,true); // the true parameter allows us to file to open in append mode
              text=text+" ";                 
              byte b[]=text.getBytes("UTF-8");                           //converting string into byte array    
              fout.write(b);    
              fout.close();    
              System.out.println("                             ");
              System.out.println("successfuly written in to the file");    
             }catch(Exception e){
            	 System.out.println(e);
            	 }    
    	
     
	}
    
    public void readfile(String fname1) throws IOException {
    	    String fileName =String.format("C:\\Phase1-finalproj\\%s",fname1);    	  
    	    FileReader f = new FileReader(fileName);
   	        BufferedReader br = new BufferedReader(f);
   	        String line =br.readLine();
   	        if (line==null) {                                       //Checking if file is empty
   	         System.out.println("                             ");
             System.out.println("File is empty!!! Cannot read");
             
   	        }else {
   	        System.out.println("                             ");
   	        while(line!=null) {    
   		        System.out.println(line);
   		        line=br.readLine();
   	         }
   	         System.out.println("                             ");
	         System.out.println("File reading is completed");   		
   	        }
   	         f.close();
   	        br.close();
	}
    
    public void exitapplication() {
    	    System.out.println("                               ");
    	    System.out.println("#####################################################################");
            System.out.println("#                 Thanks for using our Application                  #");
            System.out.println("#                             Good Day                              #");
            System.out.println("#####################################################################");
		
	}

}
