package it.objectmethod.worldspring.controll;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.objectmethod.worldspring.dao.imp.CityDaoImpSpring;
import it.objectmethod.worldspring.domain.City;

@Controller
public class CityController {

	@Autowired
	private CityDaoImpSpring cityDaoImpSpring;

	@GetMapping("/cityJdbc")
	public String snowCitys(ModelMap model, @PathParam("nation") String nation, @PathParam("order") String order) {
		List<City> citys = null;
		
		if (order == null || order.equals("Z-a")) {
			model.addAttribute("order", "A-z");
			order = "ASC";

		} else {
			model.addAttribute("order", "Z-a");
			order = "DESC";
		}

		citys = cityDaoImpSpring.getAllNationCitys(nation, order);
		model.addAttribute("result", citys);

		return "/City";
	}

	@GetMapping("/insertCity")
	public String insertCity(ModelMap model, @PathParam("city") String city, @PathParam("nation") String nation) {
		cityDaoImpSpring.insertCity(city, nation);
		return "forward:/cityJdbc";
	}

	@GetMapping("/deleteCity")
	public String deleteCity(ModelMap model, @PathParam("idCity") String idCity) {
		cityDaoImpSpring.deleteCity(Integer.parseInt(idCity));
		return "forward:/cityJdbc";
	}

	@GetMapping("/updateCity")
	public String updateCity(ModelMap model, @PathParam("city") String city, @PathParam("idCity") String idCity,
			@PathParam("nation") String nation) {
		cityDaoImpSpring.modifyCity(city, nation, Integer.parseInt(idCity));
		return "forward:/cityJdbc";
	}

	@RequestMapping(value = { "insertCityPage", "updateCityPage" }, method = RequestMethod.GET)
	public String insertModifyPage(ModelMap model, @PathParam("idCity") String idCity,@PathParam("nation") String nation) {
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

		return "forward:/viewNationForUpdateCity?countryCode="+nation;
	}

}
