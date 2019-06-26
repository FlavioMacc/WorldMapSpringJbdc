package it.objectmethod.worldspring.controll;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import it.objectmethod.worldspring.dao.imp.NationDaoImpSpring;
import it.objectmethod.worldspring.domain.Nation;

@Controller
public class NationController {

	@Autowired
	private NationDaoImpSpring nationalDaoImpSpring;

	@GetMapping("/nationjdbc")
	public String snowNations(ModelMap model, @PathParam("continent") String continent,HttpSession session) {
		List<Nation> nations = null;
		
		if(continent == null)
			continent=(String)session.getAttribute("continent");
		else
			session.setAttribute("continent", continent);
		
		nations = nationalDaoImpSpring.getAllContinentNations(continent);
		
		model.addAttribute("continent", continent);
		model.addAttribute("result", nations);

		return "Nation";
	}
	
	@GetMapping("/viewNationForUpdateCity")
	public String getAllNations(ModelMap model,@PathParam("countryCode") String countryCode) {
		
		List<Nation> nations = null;
		Nation nation = null;
		
		System.out.println(countryCode);
		
		nation=nationalDaoImpSpring.reserchNationForCode(countryCode);
		nations=nationalDaoImpSpring.getAllNationLessOneCountry(countryCode);
		
		model.addAttribute("nameNation", nation.getName());
		model.addAttribute("result", nations);
		
		return "insertModifyPageCity";
	}

}
