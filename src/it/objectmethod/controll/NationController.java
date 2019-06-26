package it.objectmethod.controll;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import it.objectmethod.worldspring.dao.imp.NationDaoImpSpring;
import it.objectmethod.worldspring.domain.Nation;;


@Controller
public class NationController {
	
	@Autowired
	private NationDaoImpSpring nationalDaoImpSpring;
	
	@GetMapping("/nationjdbc")
	public String snowNations(ModelMap model,@PathParam("continent") String continent)
	{
		List<Nation> nations = null;
		
		
		nations = nationalDaoImpSpring.getAllNations(continent);
		model.addAttribute("result", nations);
		
		return "Nation";
	}

}
