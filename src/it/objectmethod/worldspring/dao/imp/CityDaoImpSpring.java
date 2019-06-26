package it.objectmethod.worldspring.dao.imp;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import it.objectmethod.worldspring.dao.ICityDao;
import it.objectmethod.worldspring.domain.City;

@Component
public class CityDaoImpSpring extends NamedParameterJdbcDaoSupport implements ICityDao {

	@Override
	public List<City> getAllCitys() {
		List<City> citys = null;
		
		try {
			
			String sql = "SELECT DISTINCT ID idCity,Name name,CountryCode countryCode FROM city ORDER BY Name ASC";
			MapSqlParameterSource params = new MapSqlParameterSource();
			BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
			citys = getNamedParameterJdbcTemplate().query(sql, params, rm);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return citys;
	}
	
	@Override
	public List<City> getAllNationCitys(String nation, String order) {
		List<City> citys = null;

		try {
			String sql = "SELECT DISTINCT ID idCity,Name name,CountryCode countryCode FROM city WHERE CountryCode = :countryCode ORDER BY Name "
					+ order;

			MapSqlParameterSource params = new MapSqlParameterSource();

			params.addValue("countryCode", nation);

			BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
			citys = getNamedParameterJdbcTemplate().query(sql, params, rm);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return citys;
	}

	@Override
	public void insertCity(String cityName, String nation) {
		try {
			String sql = "INSERT INTO city(Name,CountryCode) VALUES ( :cityName , :nation )";
			MapSqlParameterSource params = new MapSqlParameterSource();

			params.addValue("cityName", cityName);
			params.addValue("nation", nation);

			getNamedParameterJdbcTemplate().update(sql, params);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCity(int id) {

		try {
			String sql = "DELETE FROM city WHERE ID = :id ";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", id);

			getNamedParameterJdbcTemplate().update(sql, params);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyCity(String cityName, String nation, int idCity) {
		try {
			String sql = "UPDATE city SET Name= :cityName , CountryCode = :nation WHERE ID = :id ";
			MapSqlParameterSource params = new MapSqlParameterSource();

			params.addValue("cityName", cityName);
			params.addValue("nation", nation);
			params.addValue("id", idCity);

			getNamedParameterJdbcTemplate().update(sql, params);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
