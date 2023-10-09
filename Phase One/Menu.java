import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

// Menu class to present all functions in Menu Format.

public class Menu {

	public static void main(String areg[])
	{
		try
		{
			// Declaring required variables
			
			int userChoice =0;
			int chequeNum = 1;
			int empID = 1;
			
			// We used an 'ArrayList' with name 'payList' to store all the Employees and 
			// Bills added in the system.
			ArrayList <Cheque> payList = new ArrayList<Cheque>();
			
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Hello, welcome into the system");
			
			// Executing Loop until user Exits(Choose 4 in menu) Manually from system
			
			while(userChoice != 4)
			{
				userChoice = 0;
				System.out.println("Please Enter your choice : ");
				System.out.println("1. Add an Employee");
				System.out.println("2. Add a bill");
				System.out.println("3. Issue Cheques");
				System.out.println("4. Exit");
				System.out.println("Waiting for your response ... :");


				userChoice = input.nextInt();
				input.nextLine();

				
				switch(userChoice)
				{
				case 1:
					System.out.print("Is this a full-time or part-time employee? (F/P): ");
					String type = input.nextLine().toUpperCase();
					
					if (type.equals("F")) 
					{
						
// We added a line of code that uses Static method 'addFullTimeEmployee()' to create new 
// Full Time Employee and store it in an ArrayList 'payList'.
						
						FullTimeEmployee.addFullTimeEmployee(payList,empID);
						System.out.println("*****Employee Details added Successfully*****");
						empID++;
						
						
					}
					else if(type.equals("P"))
					{
						
// We added a line of code that uses Static method 'addPartTimeEmployee()' to create new 
// Part Time Employee and store it in an ArrayList 'payList'.
						
						PartTimeEmployee.addPartTimeEmployee(payList,empID);
						System.out.println("*****Employee Details added Successfully*****");
						empID++;
						
						
					}
					else 
					{
						System.out.println("! Invalid Option");
					}
					break;
					
					
				case 2:
					
// We added a line of code that uses Static method 'addBill()' to create new Bill
// and store it in an ArrayList 'payList'.
					
					Bill.addBill(payList);
					System.out.println("Bill Details added Successfully");
					break;
					
					
				case 3:
					
// We added code that uses an overridden method 'issueCheque()' to issue all Cheques for
// for Full Time Employee Salary, Part Time Employee Salary and Bills by performing runtime 
// polymorphism.
					
					for (Cheque payable : payList) {
						payable.issueCheque(chequeNum);
						chequeNum++;
					}
					break;
					
					
				case 4:
					
					System.out.println("Thanks for Using the System.Good Bye!");
					break;
					
				default:
					System.out.println("You Entered Invalid choice");
					break;
				}

			}

		}
		catch(Exception e)
		{
			
// If user Enter any invalid character then Exception handling is done, System displays 
// defined error and Exits the System.
			
			System.out.println("Invalid Operation Performed or Invalid Character used");
			System.out.println("Exiting the System !");
		}

	}

}
