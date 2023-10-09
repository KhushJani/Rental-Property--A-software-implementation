package JUnitPackage;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import database.Database;
import rentals.RentalProperty;
import rentals.Tenant;

public class TestTenant 
{
	//This method will execute before each test.
	@Before
	public void addTenant()
	{
		Tenant tenant = new Tenant();
		List<String[]> list = new ArrayList<>();
		String[] property = {"1","Montreal","Quebec","H8R2S1","1234"};
		list.add(property);
		tenant.addTenant("abc","abc@gmail.com",list);
		tenant.addTenant("pqr","pqr@gmail.com",list);
		tenant.addTenant("xyz","xyz@gmail.com",list);
	}

	// Tests the addition of the tenants to the system.
	@Test
	public void testAddTenant()
	{
		assertEquals("abc",((ArrayList<Tenant>)Database.mockObject.get(3)).get(0).getName());	
	}

	// Tests the display of the total tenants available to the system.
	@Test
	public void testDisplayTenant()
	{
		assertEquals(3, ((ArrayList<Tenant>)Database.mockObject.get(3)).size());
	}
}
