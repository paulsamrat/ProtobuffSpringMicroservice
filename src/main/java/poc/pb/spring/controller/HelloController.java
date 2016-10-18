package poc.pb.spring.controller;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="HelloController")
@RequestMapping(value=HelloController.URL)
public class HelloController {
   static final String URL = "/SayWelcome";
   
   //default view
   //@RequestMapping(value="")
   //public String defaultView(ModelMap map){
	   //System.out.println(" default view fired");
	   //return "hello";
   //}
   @GET
   @RequestMapping(value="/welcome")
   public String printWelcome(@RequestParam(value="name" , required=true) String name, ModelMap modelMap){
	   modelMap.put("message", " hello!" + name);
	   return "hello";
   }
   @GET
   @RequestMapping(value="/hello")
	public String showMessage(
			@RequestParam(value = "name", required = true) String name, ModelMap modelMap) {
		System.out.println("in controller");

		//ModelAndView mv = new ModelAndView("hello");
		//mv.addObject("message", "message");
		//mv.addObject("name", name);
		return "hello";
   }
}
