package it.objectmethod.controll;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.objectmethod.worldspring.dao.imp.NationDaoImpSpring;

@Controller
public class Controll {

	@Autowired
	private NationDaoImpSpring nationDaoImpSpring;

	@RequestMapping(value = { "/", "continent" })
	public String snowContinents(ModelMap model) {

		List<String> continents = nationDaoImpSpring.getAllContinents();
		// System.out.println(continents);
		model.addAttribute("result", continents);

		return "Continent";
	}

	@RequestMapping(value = { "insertCityPage", "updateCityPage" }, method = RequestMethod.GET)
	public String insertModifyPage(ModelMap model, @PathParam("idCity") String idCity) {

		String titlePage = null;
		String formAction = null;

		if (idCity.equals("")) {
			titlePage = "INSERIMENTO";
			formAction = "insertCity";

		} else {
			titlePage = "MODIFICA";
			formAction = "updateCity";
		}

		model.addAttribute("formAction", formAction);
		model.addAttribute("titlePage", titlePage);

		return "insertModifyCity";
	}

}
