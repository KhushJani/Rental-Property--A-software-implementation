package application;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class RentUnitController implements Initializable
{
	@FXML TextField name;
	@FXML TextField email;
	@FXML RadioButton apartment;
	@FXML RadioButton condo;
	@FXML RadioButton house;
	@FXML TextField apartmentCity;
	@FXML TextField apartmentState;
	@FXML TextField apartmentPostalCode;
	@FXML TextField condoCity;
	@FXML TextField condoState;
	@FXML TextField condoPostalCode;
	@FXML TextField houseCity;
	@FXML TextField houseState;
	@FXML TextField housePostalCode;
	@FXML TextField apartmentNumber;
	@FXML TextField condoStreetNumber;
	@FXML TextField unitNumber;
	@FXML TextField houseStreetNumber;
	@FXML DatePicker startDate;
	@FXML DatePicker endDate;
	@FXML Button button_rentUnit;
	@FXML Label label_error;
	@FXML Label label_leaseDetails;
	@FXML Pane pane_apartment;
	@FXML Pane pane_condo;
	@FXML Pane pane_house;
	@FXML Pane pane_lease;
	
	static PropertyFieldsBean propertyFieldBean = new PropertyFieldsBean();
	
	public void getSelectedPropertyType(ActionEvent ae)
	{
		
		if(apartment.isSelected())
		{
			pane_apartment.setVisible(true);
			pane_condo.setVisible(false);
			pane_house.setVisible(false);
			
			button_rentUnit.setDisable(false);
			label_leaseDetails.setLayoutY(342);
			pane_lease.setLayoutY(370);
			button_rentUnit.setLayoutY(470);
			button_rentUnit.setVisible(true);
			
			propertyFieldBean.propertyType = 1;
		}
		else if(condo.isSelected())
		{
			pane_condo.setVisible(true);
			pane_apartment.setVisible(false);
			pane_house.setVisible(false);
			
			pane_condo.setLayoutY(206);
			button_rentUnit.setDisable(false);
			label_leaseDetails.setLayoutY(342);
			pane_lease.setLayoutY(370);
			button_rentUnit.setLayoutY(470);
			button_rentUnit.setVisible(true);

			propertyFieldBean.propertyType = 2;
		}
		else if(house.isSelected())
		{
			pane_house.setVisible(true);
			pane_apartment.setVisible(false);
			pane_condo.setVisible(false);
			
			pane_house.setLayoutY(206);
			button_rentUnit.setDisable(false);
			label_leaseDetails.setLayoutY(342);
			pane_lease.setLayoutY(370);
			button_rentUnit.setLayoutY(470);
			button_rentUnit.setVisible(true);

			propertyFieldBean.propertyType = 3;
		}
	}
	
	public void rentUnit(ActionEvent ae)
	{
		System.out.println("rentUnit called");
		if(propertyFieldBean.propertyType == 0)
		{
			button_rentUnit.setDisable(true);
		}
		
		if(propertyFieldBean.propertyType == 1)
		{
			if(validateData() == 1)
			{
				label_error.setTextFill(Color.color(1, 0, 0));
				label_error.setVisible(true);
				return;
			}
			label_error.setVisible(false);
 
			propertyFieldBean.name = name.getText();
			propertyFieldBean.email = email.getText();
			propertyFieldBean.city = apartmentCity.getText();
			propertyFieldBean.state = apartmentState.getText();
			propertyFieldBean.postalCode = apartmentPostalCode.getText();
			propertyFieldBean.apartmentNumber = apartmentNumber.getText();
			propertyFieldBean.startDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("Start Date : " + propertyFieldBean.startDate);
			propertyFieldBean.endDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("End Date : " + propertyFieldBean.endDate);
			
			Thread thread = new Thread(new Runnable()
			{
				public void run()
				{
					propertyFieldBean.serverResponse = propertyFieldBean.controller.rentAUnitController(propertyFieldBean.name, propertyFieldBean.email, propertyFieldBean.propertyType, propertyFieldBean.city, propertyFieldBean.state, propertyFieldBean.postalCode, propertyFieldBean.startDate, propertyFieldBean.endDate, propertyFieldBean.apartmentNumber);
					System.out.println(propertyFieldBean.serverResponse);
				}	
			});
			thread.start();
			try
			{
			Thread.sleep(100);
			}
			catch(Exception e)
			{
				
			}
			label_error.setText(propertyFieldBean.serverResponse);
			label_error.setTextFill(Color.color(0, 0, 1));
			label_error.setVisible(true);
			clearFields();
			
		}
		else if(propertyFieldBean.propertyType == 2)
		{
			System.out.println("Entered propertytype 2");
			if(validateData() == 1)
			{
				label_error.setTextFill(Color.color(1, 0, 0));
				label_error.setVisible(true);
				return;
			}
			label_error.setVisible(false);
			propertyFieldBean.interestedProperties = new ArrayList<>();

			
			
			propertyFieldBean.name = name.getText();
			propertyFieldBean.email = email.getText();
			propertyFieldBean.city = condoCity.getText();
			propertyFieldBean.state = condoState.getText();
			propertyFieldBean.postalCode = condoPostalCode.getText();
			propertyFieldBean.condoStreetNumber =condoStreetNumber.getText();
			propertyFieldBean.unitNumber =unitNumber.getText();
			
			propertyFieldBean.startDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("Start Date : " + propertyFieldBean.startDate);
			propertyFieldBean.endDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("End Date : " + propertyFieldBean.endDate);
			
			Thread thread = new Thread(new Runnable()
			{
				public void run()
				{
					propertyFieldBean.serverResponse = propertyFieldBean.controller.rentAUnitController(propertyFieldBean.name, propertyFieldBean.email, propertyFieldBean.propertyType, propertyFieldBean.city, propertyFieldBean.state, propertyFieldBean.postalCode, propertyFieldBean.startDate, propertyFieldBean.endDate, propertyFieldBean.condoStreetNumber+"",propertyFieldBean.unitNumber+"");
					System.out.println(propertyFieldBean.serverResponse);
				}	
			});
			thread.start();
			try
			{
			Thread.sleep(100);
			}
			catch(Exception e)
			{
				
			}
			label_error.setText(propertyFieldBean.serverResponse);
			label_error.setTextFill(Color.color(0, 0, 1));
			label_error.setVisible(true);
			
			clearFields();

		}
		else if(propertyFieldBean.propertyType == 3)
		{
			System.out.println("Entered propertytype 3");
			if(validateData() == 1)
			{
				label_error.setTextFill(Color.color(1, 0, 0));
				label_error.setVisible(true);
				return;
			}
			label_error.setVisible(false);
			propertyFieldBean.interestedProperties = new ArrayList<>();

			
			
			propertyFieldBean.name = name.getText();
			propertyFieldBean.email = email.getText();
			propertyFieldBean.city = houseCity.getText();
			propertyFieldBean.state = houseState.getText();
			propertyFieldBean.postalCode = housePostalCode.getText();
			propertyFieldBean.houseStreetNumber =houseStreetNumber.getText();
			
			propertyFieldBean.startDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("Start Date : " + propertyFieldBean.startDate);
			propertyFieldBean.endDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("End Date : " + propertyFieldBean.endDate);
			
			Thread thread = new Thread(new Runnable()
			{
				public void run()
				{
					propertyFieldBean.serverResponse = propertyFieldBean.controller.rentAUnitController(propertyFieldBean.name, propertyFieldBean.email, propertyFieldBean.propertyType, propertyFieldBean.city, propertyFieldBean.state, propertyFieldBean.postalCode, propertyFieldBean.startDate, propertyFieldBean.endDate, propertyFieldBean.houseStreetNumber+"");
					System.out.println(propertyFieldBean.serverResponse);
				}	
			});
			thread.start();
			try
			{
			Thread.sleep(100);
			}
			catch(Exception e)
			{
				
			}
			label_error.setText(propertyFieldBean.serverResponse);
			label_error.setTextFill(Color.color(0, 0, 1));
			label_error.setVisible(true);
			
			clearFields();

		

		}
	}
	
	public int validateData()
	{

		if(name.getText().trim().equals(""))
		{
			label_error.setText("Please Fill The Name Field");
			return 1;
		}
		if(email.getText().trim().equals(""))
		{
			label_error.setText("Please Fill The Email Field");
			return 1;
		}
		
		
		if(propertyFieldBean.propertyType == 1)
		{
			if(apartmentCity.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(apartmentState.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(apartmentPostalCode.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(apartmentNumber.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}

		}
		else if(propertyFieldBean.propertyType == 2)
		{
			if(condoCity.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(condoState.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(condoPostalCode.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(condoStreetNumber.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(unitNumber.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
		}
		else if(propertyFieldBean.propertyType == 3)
		{
			if(houseCity.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(houseState.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(housePostalCode.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
			if(houseStreetNumber.getText().trim().equals(""))
			{
				label_error.setText("Please Fill All The Fields");
				return 1;
			}
		}
		
		if(propertyFieldBean.propertyType == 1)
		{
			if(apartmentNumber.getText().trim().matches("[a-z]") || apartmentNumber.getText().trim().matches("[A-Z]"))
			{
				//			rent.setStyle("-fx-border-color : red;-fx-border-width : 2px");
				label_error.setText("Only Numbers Allowed In Fields : Rent, Apartment Number, Number Of Bedrooms, Number Of Bathrooms, Square Footage, Street Number, Unit Number");
				return 1;
			}

		}
		else if(propertyFieldBean.propertyType == 2)
		{
			if(condoStreetNumber.getText().trim().matches("[a-z]") || condoStreetNumber.getText().trim().matches("[A-Z]"))
			{
				//			rent.setStyle("-fx-border-color : red;-fx-border-width : 2px");
				label_error.setText("Only Numbers Allowed In Fields : Rent, Apartment Number, Number Of Bedrooms, Number Of Bathrooms, Square Footage, Street Number, Unit Number");
				return 1;
			}

			if(unitNumber.getText().trim().matches("[a-z]") || unitNumber.getText().trim().matches("[A-Z]"))
			{
				//			rent.setStyle("-fx-border-color : red;-fx-border-width : 2px");
				label_error.setText("Only Numbers Allowed In Fields : Rent, Apartment Number, Number Of Bedrooms, Number Of Bathrooms, Square Footage, Street Number, Unit Number");
				return 1;
			}

		}
		else if(propertyFieldBean.propertyType == 3)
		{
			if(houseStreetNumber.getText().trim().matches("[a-z]") || houseStreetNumber.getText().trim().matches("[A-Z]"))
			{
				//			rent.setStyle("-fx-border-color : red;-fx-border-width : 2px");
				label_error.setText("Only Numbers Allowed In Fields : Rent, Apartment Number, Number Of Bedrooms, Number Of Bathrooms, Square Footage, Street Number, Unit Number");
				return 1;
			}
		}
		
			
//		if(startDate.getValue().)
//		{
//			label_error.setText("Please Fill The PostalCode Field");
//			return 1;
//		}
//		if(postalCode.getText().trim().equals(""))
//		{
//			label_error.setText("Please Fill The PostalCode Field");
//			return 1;
//		}
		
		label_error.setText("");
		return 0;

	}
	
	
	public void clearFields()
	{
		name.clear();
		email.clear();
		apartmentCity.clear();
		apartmentState.clear();
		apartmentPostalCode.clear();
		condoCity.clear();
		condoState.clear();
		condoPostalCode.clear();
		houseCity.clear();
		houseState.clear();
		housePostalCode.clear();
		apartmentNumber.clear();
		condoStreetNumber.clear();
		unitNumber.clear();
		houseStreetNumber.clear();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stub
		pane_apartment.setVisible(false);
		pane_condo.setVisible(false);
		pane_house.setVisible(false);
		button_rentUnit.setVisible(false);
	}

}
