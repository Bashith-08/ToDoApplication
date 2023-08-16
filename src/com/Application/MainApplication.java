package com.Application;

import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

import com.DataBase.AuthenticationServices;
import com.Exceptions.SameIdException;
import com.ServiceOperations.ToDoClass;
import com.ServiceOperations.ToDoServices;

public class MainApplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		
		//Varibles for User Details
		String userId;
		String userPassword;
		String yourId;
		String yourPassword;
		
		// Varibles for User Services
		int id;
        String task;
        String category;
        int todoSwitch, authenticateSwitch, n,n1;
        HashMap<Integer, ToDoClass > hashMap = new HashMap<Integer, ToDoClass >();
        
		
        AuthenticationServices sp = new AuthenticationServices();
		do {
			System.out.println("*******************************************************");
			System.out.println("Welcome to the Online-To-DO-List Application :-) ");
			System.out.println("*******************************************************");
			System.out.println(" 1. New User? Sign Up\n 2. Already Registered? Login");
			System.out.println("-------------------------------------------------------");
			System.out.println("\n Enter operation to do : ");
			
			
			authenticateSwitch = input.nextInt();
			switch(authenticateSwitch)
			{
			
			case 1 :
                 //SignUP Page.....
				System.out.println("-------------------------------------------------------"); 
				System.out.println("Sign Up Page ");
				System.out.println("-------------------------------------------------------");
		         System.out.println("Enter User Id to Register - ");
		         userId = input.next();
		
		
	             System.out.println("Set Your Password - ");
	             userPassword = input.next();
	             

	             sp.setUserId(userId);
	             sp.setUserPassword(userPassword);
	             
	             sp.storeDetails(sp.getUserId(),sp.getUserPassword());
	             System.out.println("\n User added successfully..Thankyou for signing up...\n");
	             break;
	    
	    
			case 2 :
	    
	             //Login Page
				 System.out.println("-------------------------------------------------------");
	             System.out.println("Login Page ");
	             System.out.println("-------------------------------------------------------");
		         System.out.println("Enter your ID - ");
		         yourId = input.next();
		
	             System.out.println("Enter your Password - ");
	             yourPassword = input.next();
	    
	             int flag = sp.validateUser(yourId, yourPassword);
	    
	             if(flag == 1)
	            {
	        
                    System.out.println("\n Hola!!! "+yourId+" Welcome... :-) \n");
                    ToDoServices todoObj = new ToDoServices();
		          do
		         {
		           System.out.println("-------------------------");
		           System.out.println(" 1. Add Task\n 2. Remove Task\n 3. Update Task\n 4. Mark Task as Complete..\n 5. Display Completed Tasks..\n 6. Clear all Tasks");
		           System.out.println("-------------------------");
		           System.out.println("Enter the operation to do : ");
		
		
		            todoSwitch = input.nextInt();
		  switch(todoSwitch)
		{
		
		case 1:
			  System.out.println("Enter ID : ");
              id = input.nextInt();
              input.nextLine();
        
              if(hashMap.containsKey(id))
			  {
            	  throw new SameIdException("Id is already present...:-( ");
			  }
              else
              {
            	  
              System.out.println("Enter Task : ");
              task = input.nextLine();
        
              System.out.println("Enter Category : ");
              category = input.nextLine();
        
              
              hashMap = todoObj.addEntry(id, new ToDoClass(task, category));
              
              System.out.println("-------My To-Do-List-------");
        
              for(Map.Entry<Integer, ToDoClass> entry : hashMap.entrySet())
              {    
                int key=entry.getKey();  
                ToDoClass val =entry.getValue();  
                System.out.println(key +" | "+val.task+" | "+val.category);
              }
              

	          System.out.println("Task Added... || Tasks Left :- " + hashMap.size());
	          System.out.println("---------------------------------");
              }
		    break;
		 
		case 2:
			    
				if(hashMap.isEmpty())
				{
					System.out.println("Your List is Empty... Nothing is left to delete :-)");
				}
				
				else
				{
				
				System.out.println("Enter ID : ");
	            id = input.nextInt();
				if(hashMap.containsKey(id))
				{
				hashMap = todoObj.deleteEntry(id);
				System.out.println("-------My To-Do-List-------");	
				
				for(Map.Entry<Integer, ToDoClass> entry:hashMap.entrySet())
				{    
                 int key=entry.getKey();  
                 ToDoClass val=entry.getValue();  
                 System.out.println(key +" | "+val.task+" | "+val.category);
                }
			    
			    System.out.println("Task Deleted... || Tasks Left :- " + hashMap.size());
	            System.out.println("---------------------------------");
				}
				else
				{
					System.out.println("\n Choosen"+id+"Id is not present in the List");
				}
				}
		    
		    break;
		  case 3:
		         
				if(hashMap.isEmpty())
				{
					System.out.println("Your List is Empty... Nothing is left to update :-)");
				}
				else
				{
					System.out.println("Enter ID : ");
	                 id = input.nextInt();
	                 input.nextLine();
	                 
	                 if(hashMap.containsKey(id))
	 				{
	 				
	        
	                 System.out.println("Enter Title : ");
	                 task = input.nextLine();
	                 
	                 System.out.println("Enter Time : ");
	                 category = input.nextLine();
	        
					
					hashMap = todoObj.updateEntry(id, new ToDoClass(task, category));
					System.out.println("-------My To-Do-List-------");		
				for(Map.Entry<Integer, ToDoClass> entry:hashMap.entrySet())
				{    
                 int key=entry.getKey();  
                 ToDoClass val=entry.getValue();  
                 System.out.println(key +" | "+val.task+" | "+val.category);
                }
			    
			    System.out.println("Task Updated... || Tasks Left :- " + hashMap.size());
	            System.out.println("---------------------------------");
	 				}
	                 else
	 				{
	 					System.out.println("\n Choosen"+id+"Id is not present in the List");
	 				}
				}
			    break;
			    
		  case 4:
			    	
				if(hashMap.isEmpty())
				{
					System.out.println("Your List is Empty... Nothing is left to mark as complete :-)");
				}
				else
				{
					
					System.out.println("Enter ID : ");
	                id = input.nextInt();
					
					hashMap = todoObj.markAsComplete(id);
					System.out.println("-------My To-Do-List-------");	
				 for(Map.Entry<Integer, ToDoClass> entry:hashMap.entrySet())
				 {    
                   int key=entry.getKey();  
                   ToDoClass val=entry.getValue();  
                   System.out.println(key +" | "+val.task+" | "+val.category);
                 }
			    
			    System.out.println("Task Marked as complete... || Tasks Left :- " + hashMap.size());
	            System.out.println("---------------------------------");
			    
				}
		    
		    break;
		    
		  case 5:
			  
			  if(todoObj.displayCompletedTasks().isEmpty())
			  {
				System.out.println("You Don't have any completed task..");
			  }
			  else
			  {
			  
				  System.out.println("-------My Completed List-------");
		        for(Map.Entry<Integer, ToDoClass> entry:todoObj.displayCompletedTasks().entrySet())
			    {    
                 // int key=entry.getKey();  
                  ToDoClass val=entry.getValue();  
                  System.out.println(val.task+" | "+val.category);
               }
			    
			   System.out.println("All Completed Tasks... || Tasks Done :- " + todoObj.displayCompletedTasks().size());
	           System.out.println("---------------------------------");
			  }
		    break;
		    
          case 6:
        	  
        	  if(hashMap.isEmpty())
				{
					System.out.println("Your List is already Empty... Nothing is left to delete :-)");
				}
				
				else
				{
				
				
				hashMap = todoObj.clearAllTasks();
				System.out.println("-------My To-Do-List-------");	
				for(Map.Entry<Integer, ToDoClass> entry:hashMap.entrySet())
				{    
               int key=entry.getKey();  
               ToDoClass val=entry.getValue();  
               System.out.println(key +" | "+val.task+" | "+val.category);
              }
			    
			    System.out.println("All Tasks Cleared... || Tasks Left :- " + hashMap.size());
	            System.out.println("---------------------------------");
				}
        	  
				      	  
		  default:
		    System.out.println("Choose valid operation..");
		}
		System.out.println("Do you want to continue to add Tasks? If yes Press '1' else '0'. ");
		 n=input.nextInt();
		}while(n==1);
        
    }
	    
	else
	{
	   System.out.println("Invalid Credentials... :-(");
	}
   break;
   
   default :
	   System.out.println("Enter a Valide Input.... :-( ");
 }
		System.out.println("Press '1' to Continue.. Else Press '0'....");
        n1=input.nextInt();
}while(n1==1);
	    
	        
}

}
