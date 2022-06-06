package dynamicdata;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicData2  {

	@Test(dataProvider = "Data")
	public void test123(UserData user) {
	System.out.println("Name: " + user.getName() + ", Email: " + user.getEmail() + ", Phone: " + user.getPhone()
	+ ", PAN: " + user.getPan() + ", Aadhar: " + user.getAadhar());
	}

	@DataProvider
	public Object[][] Data() {

		List<UserData> data = new ArrayList<UserData>();

		for (int i = 0; i < 10; i++) {
			
				String name= RandomStringUtils.randomAlphabetic(4, 15);
				String phone=RandomStringUtils.randomNumeric(10);
				String pan=RandomStringUtils.randomAlphanumeric(10);
				String aadhar=RandomStringUtils.randomNumeric(12);
				String email=name+"@gmail.com";
				
				data.add(new UserData(name,email,phone,pan,aadhar));

		}
        
		Object[][] testdata = { { data.get(0) }, { data.get(1) }, { data.get(2) }, { data.get(3) }, { data.get(4) },
				{ data.get(5) }, { data.get(6) }, { data.get(7) }, { data.get(8) }, { data.get(9) } };

		return testdata;
	}
}
