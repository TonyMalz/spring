package mvc.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	JdbcTemplate db;

	@Autowired
	public MainController(DataSource ds) {
		db = new JdbcTemplate(ds);
	}

	@GetMapping()
	public String index(ModelMap m) {
		m.addAttribute("greet", "Hello Mysql!");
		int rowCount = db.queryForObject("select count(*) from movie", Integer.class);

		m.addAttribute("movie_count", rowCount);
		return "index";
	}

}
