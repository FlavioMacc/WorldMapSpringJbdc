package it.objectmethod.worldspring.dao.imp;

import java.util.List;

import it.objectmethod.worldspring.domain.City;

public interface ICityDao {
	
	public List<City> getAllCitys(String nation, String order);
	
	public void insertCity(String cityName, String nation);
	
	public void deleteCity(int id);
	
	public void modifyCity(String cityName, String nation, int idCity);

}
