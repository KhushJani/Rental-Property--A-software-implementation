// This is an abstract class inheriting 'Cheque' interface.
// This abstract class has 4 fields : ID , firstName , lastName , age.
// This abstract class contains abstract method 'issueCheque' inherited from interface 'Cheque'.
// Abstract Method 'issueCheque' to be implemented in child classes.

abstract public class Employee implements Cheque{

	protected int ID = 0;
	protected String firstName;
	protected String lastName;
	protected int age;

	//Constructor
	Employee(String firstName,String lastName,int age, int ID)
	{
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;	
	}

//Abstract Method 'issueCheque' to be implemented in child classes.
	
	abstract public void issueCheque(int chequeNum);


}
