// This is a class inheriting abstract class 'Employee'.
// This class has 3 field : echelon , hourlyRate , hoursWorked and 4 inherited fields : ID , firstName , lastName , age.
// This class extends method 'issueCheque' inherited from abstract Class 'Employee'.

import java.util.ArrayList;
import java.util.Scanner;

public class PartTimeEmployee extends Employee {

	public static final int ECHELON1_HOURLYRATE = 15;//Static Variable
	public static final int ECHELON2_HOURLYRATE = 20;
	public static final int ECHELON3_HOURLYRATE = 25;
	public static final int ECHELON4_HOURLYRATE = 30;
	public static final int ECHELON5_HOURLYRATE = 40;
	
	protected int echelon;
	protected double hourlyRate;
	protected int hoursWorked;

	//Constructor
	public PartTimeEmployee(String firstName, String lastName, int age, int ID, int echelon, double hourlyRate, int hoursWorked) {
		super(firstName, lastName, age, ID);
		this.echelon = echelon;
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	// @Overridden Methods 'issueCheque'.
	
	public void issueCheque(int chequeNum) {
		double salary = hourlyRate * hoursWorked;
		// System.out.println("Cheque #" + chequeNum + " for " + firstName + " " + lastName + " with ID " + ID + " for $" + salary + " issued.");
		System.out.println("*--------------------------------------------------------------*");
		System.out.println("| Cheque # : " + chequeNum + "                Name   : "+firstName);
		System.out.println("| Amount   : "+ salary+"$");
		System.out.println("*--------------------------------------------------------------*");

	}
	
// The 'addPartTimeEmployee()' method takes 2 agruments : ArrayList <Cheque> payList,int ID
// The 'addPartTimeEmployee()' method returns : void
// The 'addPartTimeEmployee()' method takes input from user , creates a PartTimeEmployee, find 
// hourlyRate based on echelon of Part Time Employee and add it to ArrayList 'payList'.

	static public void addPartTimeEmployee(ArrayList <Cheque> payList,int ID)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter first name: ");
		String firstName = input.nextLine();
		System.out.print("Enter last name: ");
		String lastName = input.nextLine();
		System.out.print("Enter age: ");
		int age = input.nextInt();

		input.nextLine();

		System.out.print("Enter echelon (1-5): ");
		int echelon = input.nextInt();
		double hourlyRate = 0;
		if (echelon == 1) {
			//hourlyRate = 15;
			hourlyRate = ECHELON1_HOURLYRATE;
		} else if (echelon == 2) {
			//hourlyRate = 20;
			hourlyRate = ECHELON2_HOURLYRATE;
		} else if (echelon == 3) {
			//hourlyRate = 25;
			hourlyRate = ECHELON3_HOURLYRATE;
		} else if (echelon == 4) {
			//hourlyRate = 30;
			hourlyRate = ECHELON4_HOURLYRATE;
		} else if (echelon == 5) {
			//hourlyRate = 40;
			hourlyRate = ECHELON5_HOURLYRATE;
		}
		System.out.print("Enter hours worked per month: ");
		int hoursWorked = input.nextInt();
		payList.add(new PartTimeEmployee(firstName, lastName, age, ID, echelon, hourlyRate, hoursWorked));

	}

}
