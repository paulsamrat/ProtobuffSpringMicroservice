package poc.pb.spring.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

import com.poc.pb.prtoco.src.EmployeeProto.Employee;

public class TestHTTPClient {
	
	private static final String PROTOBUF_POST_URL = "http://localhost:8080/pocpbspringmicroservice/ProtoBufController/createEmployee";
	
	
	private static Employee employee;
	
	private static HttpURLConnection urlc;
	
	@BeforeClass
	public static void setUpProtoBufEntity(){
		try {
			employee = Employee.newBuilder().setId(1).setFirstName("samrat").setSecondName("paul").build();
			URL url = new URL(PROTOBUF_POST_URL);
			urlc = (HttpURLConnection) url.openConnection();
			urlc.setDoInput(true);
			urlc.setDoOutput(true);
			urlc.setRequestMethod("POST");
			//urlc.setRequestProperty("Accept", "application/x-protobuf");
			urlc.setRequestProperty("Content-Type", "application/x-protobuf");
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	@Test
	public void testProtocolBufferIPC(){
		try {
			employee.writeTo(urlc.getOutputStream());
			urlc.getInputStream();
		}catch(IOException ioe){
			ioe.printStackTrace();
		
		}catch(Exception e){
				e.printStackTrace();
		}
		
		
	}
}
