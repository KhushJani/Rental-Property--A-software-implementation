// This is a class inheriting 'Cheque' interface.
// This class has 3 fields : companyName , amount , dueDate.
// This class contains method 'issueCheque' inherited from interface 'Cheque'.
// This class implements method 'issueCheque' inherited from abstract Class 'Cheque'.
// The field 'dueDate' is Static field with its default value set to '02/28/2023'.



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bill implements Cheque{

	protected String companyName;
	protected double amount;
	protected String dueDate;

	//Constructor
	public Bill(String companyName, double amount, String dueDate) {
		this.companyName = companyName;
		this.amount = amount;
		this.dueDate = dueDate;
	}

	// @Overridden Methods 'issueCheque'.
	
	public void issueCheque(int chequeNum){
		try {
			Date date1 = new Date();
			SimpleDateFormat currentDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			String cD= currentDateFormat.format(date1);
			Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(dueDate);

			if((date1.after(date2)))
			{
				//System.out.println("Cheque #" + chequeNum + " for " + companyName + " for $" + amount + " issued.");
				System.out.println("*--------------------------------------------------------------*");
				System.out.println("| Cheque # : " + chequeNum + "                Company Name   : "+companyName);
				System.out.println("| Amount   : "+ amount+"$"+"	      Due Date	     : "+dueDate);
				System.out.println("*--------------------------------------------------------------*");
			}
		}
		catch(Exception e)
		{
			System.out.println("Date Error");
		}
	}

// The 'addBill()' static method takes 1 argument : ArrayList <Cheque> payList
// The 'addBill()' method returns : void
// The 'addBill()' method takes input from user , creates a Bill and
// add it to ArrayList 'payList'.

	public static void addBill(ArrayList <Cheque> payList)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name of company: ");
		String companyName = input.nextLine();
		System.out.print("Enter amount to be paid: ");
		double amount = input.nextDouble();
		input.nextLine();
		System.out.print("Enter due date (MM/DD/YYYY): ");
		String dueDate = input.nextLine();
		payList.add(new Bill(companyName, amount, dueDate));
	}

}
