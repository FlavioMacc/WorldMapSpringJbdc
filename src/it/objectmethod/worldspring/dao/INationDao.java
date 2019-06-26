package it.objectmethod.worldspring.dao;

import java.util.List;

import it.objectmethod.worldspring.domain.Nation;

public interface INationDao {
	
	public List<Nation> getAllNation();

	public List<Nation> getAllContinentNations(String continent);

	public List<String> getAllContinents();
	
	public Nation reserchNationForCode(String countryCode);
	
	public List<Nation> getAllNationLessOneCountry(String countryCode);

}
