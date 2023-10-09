// This is a class inheriting abstract class 'Employee'.
// This class has 1 field : fixedSalary and 4 inherited fields : ID , firstName , lastName , age.
// This class extends method 'issueCheque' inherited from abstract Class 'Employee'.

import java.util.ArrayList;
import java.util.Scanner;

public class FullTimeEmployee extends Employee{

	protected double fixedSalary;

	//Constructor
	public FullTimeEmployee(String firstName, String lastName, int age, int ID, double fixedSalary) 
	{
		super(firstName, lastName, age, ID);
		this.fixedSalary = fixedSalary;
	}

	// @Overridden Methods 'issueCheque'.
	
	public void issueCheque(int chequeNum) {
		// System.out.println("Cheque #" + chequeNum + " for " + firstName + " " + lastName + " with ID " + ID + " for $" + fixedSalary + " issued.");

		System.out.println("*--------------------------------------------------------------*");
		System.out.println("| Cheque # : " + chequeNum + "                Name   : "+firstName);
		System.out.println("| Amount   : "+ fixedSalary+"$");
		System.out.println("*--------------------------------------------------------------*");
	}

// The 'addFullTimeEmployee()' method takes 2 agruments : ArrayList <Cheque> payList,int ID
// The 'addFullTimeEmployee()' method returns : void
// The 'addFullTimeEmployee()' method takes input from user , creates a FullTimeEmployee and
// add it to ArrayList 'payList'.
	
	static public void addFullTimeEmployee(ArrayList <Cheque> payList,int ID)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter first name: ");
		String firstName = input.nextLine();
		System.out.print("Enter last name: ");
		String lastName = input.nextLine();
		System.out.print("Enter age: ");
		int age = input.nextInt();
		input.nextLine();
		System.out.print("Enter fixed salary: ");
		double fixedSalary = input.nextDouble();
		payList.add(new FullTimeEmployee(firstName, lastName, age, ID, fixedSalary));

	}

}
