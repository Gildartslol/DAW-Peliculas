package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerPrueba {
	@RequestMapping("/text")
	public ModelAndView text() {
		MyObject myObject = new MyObject("my name", "my description");
		return new ModelAndView("text_page").addObject("greetings", "Hello world!").addObject("myobj", myObject);
	}
	
	@RequestMapping("/")
	public ModelAndView empty() {
		
		return new ModelAndView("index");
	}
}