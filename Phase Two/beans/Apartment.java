/**
 *
 */

package beans;

import rentals.RentalProperty;

public class Apartment extends RentalProperty 
{
	public String apartmentNumber;
	public int numberOfBedrooms;
	public int numberOfBathrooms;
	public int squareFootage;

    //Constructor
    public Apartment(String address, String city, String state, String postalCode, double rent, String apartmentNumber, int numberOfBedrooms, int numberOfBathrooms, int squareFootage)
    {
        super(address, city, state, postalCode, rent);
        this.apartmentNumber = apartmentNumber;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.squareFootage = squareFootage;
    }

    @Override
    public void displayDetails() {

    }

}

