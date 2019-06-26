package it.objectmethod.worldspring.dao.imp;

import java.util.List;

import it.objectmethod.worldspring.domain.Nation;

public interface INationDao {

	public List<Nation> getAllNations(String continent);
	
	public List<String> getAllContinents();

}
