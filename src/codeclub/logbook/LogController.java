package codeclub.logbook;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/log")
public class LogController {

	private String messages = "";
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView log(@RequestParam("message") String message) throws IOException {
		messages += message + "</br>";
		
		ModelAndView model = new ModelAndView("log");
		model.addObject("message", messages);
		
		return model;
	}

}
