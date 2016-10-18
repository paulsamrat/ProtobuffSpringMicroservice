package poc.pb.spring.client;

import java.nio.charset.Charset;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.poc.pb.prtoco.src.EmployeeProto.Employee;

public class TestRestClient {
	
	private static final String PROTOBUF_POST_URL = "http://localhost:8080/pocpbspringmicroservice/ProtoBufController/createEmployee";
	
	private static final String PROTOBUF_GET_URL = "http://localhost:8080/pocpbspringmicroservice/ProtoBufController/getEmployee";

	private static RestTemplate restTemplate;
	
	private static Employee employee;
	
	@BeforeClass
	public static void setUpProtoBufEntity(){
		employee = Employee.newBuilder().setId(1).setFirstName("samrat").setSecondName("paul").build();
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new ProtobufHttpMessageConverter());
	}
	
	@Test
	public void testProtocolBufferIPCPost(){
		try {
			HttpHeaders headers=  new HttpHeaders();
			headers.setContentType(new MediaType("application", "x-protobuf", Charset.forName("UTF-8")));
			HttpEntity<Object> entity = new HttpEntity<Object>(employee,headers);
			ResponseEntity<String> response = restTemplate.postForEntity(PROTOBUF_POST_URL, entity,String.class);
			System.out.println(response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	@Test
	public void testProtocolBufferIPCGet(){
		try {
			Employee response = restTemplate.getForObject(PROTOBUF_GET_URL, Employee.class);
			System.out.println(response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
