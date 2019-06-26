package it.objectmethod.worldspring.dao;

import java.util.List;

import it.objectmethod.worldspring.domain.City;

public interface ICityDao {

	public List<City> getAllCitys();
	
	public List<City> getAllNationCitys(String nation, String order);

	public void insertCity(String cityName, String nation);

	public void deleteCity(int id);

	public void modifyCity(String cityName, String nation, int idCity);

}
