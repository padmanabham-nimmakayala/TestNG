package dynamicdata;



import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class DynamicData {
	
	
	@Test
	public void data() {

		for(int i=0;i<10;i++) {
		String name= RandomStringUtils.randomAlphabetic(4, 15);
		String phonenumber=RandomStringUtils.randomNumeric(10);
		String PANno=RandomStringUtils.randomAlphanumeric(10);
		String aadhar=RandomStringUtils.randomNumeric(12);
		String email=name+"@gmail.com";
		
		System.out.println("Name:"+name+"  "+"phn no:"+phonenumber+"  "+"PAN:"+PANno+"  "+"aadhar:"+aadhar+"  "+"email:"+email);
		
		
	}
	}
}
