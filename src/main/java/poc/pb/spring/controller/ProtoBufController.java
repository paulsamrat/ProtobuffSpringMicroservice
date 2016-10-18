package poc.pb.spring.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.pb.prtoco.src.EmployeeProto;
import com.poc.pb.prtoco.src.EmployeeProto.Employee;

@Controller("ProtoBufController")
@RequestMapping(value=ProtoBufController.URL)
public class ProtoBufController {

	public static final String URL = "/ProtoBufController";
	
	@POST
	@Consumes("application/x-protobuf")
	@RequestMapping(value="/createEmployee")
	public String createEmployee(@RequestBody Employee employee){
		System.out.println( " printing the deserialized protobuf employee message " + employee.toString());
		return "success";
	}
	
	  
	@GET
	@RequestMapping(value="/getEmployee")
	public @ResponseBody Employee getEmployee(){
		//return new ResponseEntity<EmployeeProto.Employee>(
				//Employee.newBuilder().setId(1).setFirstName("samrat").setSecondName("paul").build(), HttpStatus.OK);
		return Employee.newBuilder().setId(1).setFirstName("samrat").setSecondName("paul").build();
	}
}
