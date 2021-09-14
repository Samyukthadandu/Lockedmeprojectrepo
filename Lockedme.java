package Simpligradedprojects;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lockedme {
	
	public static void welcome() {
		System.out.println("#####################################################################");
		System.out.println("#                    WELCOME TO Lockedme.com                        #");
		System.out.println("#####################################################################");
		System.out.println("#                    Developer-SamyukthaDandu                       #");
		System.out.println("#####################################################################");
	}
	
	public static void menu() {
	
		System.out.println( "\n"+"============== Main Menu ==============="+"\n");
		
		System.out.println("1.Display all files ");
		System.out.println("2.Business Operations ");
		System.out.println("3.Exit ");
		System.out.println("========================================");
		
	}
	
	public static void businessoperationmenu() {
		
		 System.out.println( "\n"+"======= Business Operations Menu ======="+"\n");
			
			System.out.println("1.Create File ");
			System.out.println("2.Search File ");
			System.out.println("3.Delete File ");
			System.out.println("4.Write/Append File");
			System.out.println("5.Read File");		
			System.out.println("6.Back to Main Menu ");
			System.out.println("=========================================");
		
	}
	public static boolean checkDirectory() {
		 File directory = new File("C:\\Phase1-finalproj");	    
	         String[] files = directory.list();
	         return files.length == 0;    
	    	     
			}
	        
	

	public static void main(String[] args) throws Exception {
		
		 String fname="";
		 int choice=0;
		
         welcome();                         //Display welcome message and developer details
        
         FileOperations fo = new FileOperations();
         Scanner s = new Scanner(System.in);
         
                                            // do-while loop for Main Menu
         do {
        	 menu();                        //Displays Main Menu        	
             System.out.print( "\n"+"Select option and press enter : ");
             try {
             choice =s.nextInt();           //User Input for Main Menu        
            
                                            //Switch Case for the Main Menu 
         switch (choice)
         {
        	 case 1: 
        		boolean value =checkDirectory();
        		//System.out.println(value);
        		if(value == false) {
        		 fo.displayallfiles(); 
        		}else {
        			System.out.println("                              ");
        			System.out.println("The directory is empty.Please add new files");
        		}
        		 break;        		 
        	 case 2:
        		                            // do-while loop for Business Operations Menu
        		 do {
        		  businessoperationmenu();  //Displays Business Operations Menu
        		  System.out.print( "\n"+"Select option and press enter : ");
        		  try {                     // try-catch block to handle InputMismatchException for Main Menu user input
        	      choice =s.nextInt(); 
        		  
        	    	switch (choice)         //switch case for Business Operations Menu
        	    	{
       		       			   			
                     	case 1:	 
        		          System.out.print("\n"+"Enter file name to create"+ ".txt file: ");
     			          fname= s.next();
           		          fo.createfile(fname);
        		          break;
        	            case 2:
        	            	boolean value1 =checkDirectory();
        	        		//System.out.println(value);
        	        		if(value1 == false) {
        		                System.out.print("\n"+"Enter file name you want to search with extension: ");
     			                String key= s.next();
        		                fo.searchfile(key);
        	        		}else {
        	        			System.out.println("                       ");
        	        			System.out.println("The directory is empty.You cannot perform search operation");
        	        		}
        		          break;
        	            case 3:
        	            	boolean value2=checkDirectory();
        	            	if(value2 == false) {
        	                  boolean flag =false;
        		              System.out.print("\n"+"Enter file name you want to delete: ");
     			              fname= s.next();     	
     			              File f = new File("C:\\Phase1-finalproj");
     			              String[] array =f.list(); 
     			              for(String a:array) {
     			        	     if(fname.compareTo(a)==0) {
     			        		    fo.deletefile(fname);
     			        		    flag= true;
     			        	      }     			        	  
     			             }  
     			             if(flag==false) {
     			        	    System.out.print("\n"+"File does not exist/File is CASESENSITIVE/File extension missing");
     			        	    System.out.println("                                ");
     			             }  
        	            	 }else {
        	                    System.out.println("                                ");
        	            		System.out.println("The directory is empty.You cannot perform delete operation");
        	            	   }
        		            break;
        	            case 4:
        	           	  Scanner sc = new Scanner(System.in);
        	              System.out.print("\n"+"Enter the file name you want to write/append into: ");	
        	              fname= sc.nextLine();
        	              System.out.print("\n"+"Enter the text: ");
        	              String text="";        	            		  
        	              text+=sc.nextLine();        	         
        		          fo.writetofile(fname,text);
        		          break;
        	            case 5:
        	            	boolean value3=checkDirectory();
        	            	if(value3 == false) {
        	            	   boolean flag1=false;
        	                   File f1 = new File("C:\\Phase1-finalproj");
       			               String[] array1 =f1.list(); 
        	                   System.out.print("\n"+"Enter the file name to read the data: ");  
        	                   fname= s.next();
        	                   for(String a:array1) {
     			        	      if(fname.compareTo(a)==0) {
     			        		    flag1=true;
     			        	      }
        	                   }
        	                  if (flag1==true) {
        		                   fo.readfile(fname);
        	                  }else {
        	            	       System.out.println("                                   ");
        	            	       System.out.println("File does not exist/File is CASESENSITIVITY/File extension missing");
        	                   }
        	            	}else {
        	            	    System.out.println("                                ");
        	            		System.out.println("The directory is empty.You cannot perform any read operation");
        	            	}
        		            break;
        	            case 6:        		          
        		          break;	 
        	              default:
        	              System.out.println("                                ");
        		          System.out.println("Not a valid choice.Please try again");        		       		 
                     }
        	    	 
        		  }catch(InputMismatchException e) {
         			 
         			      s.next();
                  	      // System.out.println(e.getClass().getName()); 
         			      System.out.println("                    ");
                  	      System.out.println("Integer input expected");
         		  }
         	         }
        		    while(choice!=6);  //end of Business Operations Menu do -while loop
           		    break;
        	 case 3:         
        	   fo.exitapplication();         
        	   break;        	 
        	 default:
         		System.out.println("Not a valid choice.Please try again");
         		break;
        	 }
       
             }catch(InputMismatchException e) {            	         	    
                 s.next();
            	// System.out.println(e.getClass().getName());   
                 System.out.println("                    ");
            	 System.out.println("Integer input expected");
            	 }
                
             }
         
		 while(choice !=3);      // End of MainMenu do while loop   
            s.close();     
        
	}

}

