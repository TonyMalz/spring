package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping()
	@ResponseBody
	public String index() {

		return "Hello <b>World</b>! <br/> Current time: " + String.valueOf(new java.util.Date());
	}

}
