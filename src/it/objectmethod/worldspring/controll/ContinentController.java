package it.objectmethod.worldspring.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.worldspring.dao.imp.NationDaoImpSpring;

@Controller
public class ContinentController {

	@Autowired
	private NationDaoImpSpring nationDaoImpSpring;

	@RequestMapping(value = { "/", "continent" })
	public String snowContinents(ModelMap model) {
		List<String> continents = nationDaoImpSpring.getAllContinents();
		model.addAttribute("result", continents);

		return "Continent";
	}

}
