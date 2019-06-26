package it.objectmethod.worldspring.dao.imp;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import it.objectmethod.worldspring.dao.INationDao;
import it.objectmethod.worldspring.domain.Nation;

@Component
public class NationDaoImpSpring extends NamedParameterJdbcDaoSupport implements INationDao {

	
	@Override
	public List<Nation> getAllNation() {
		List<Nation> nations = null;
		
		try {
			
			String sql = "SELECT Code code,Name name,Continent continent,Population popolation FROM country ORDER BY Name ASC";
			MapSqlParameterSource params = new MapSqlParameterSource();
			BeanPropertyRowMapper<Nation> rm = new BeanPropertyRowMapper<Nation>(Nation.class);
			nations = getNamedParameterJdbcTemplate().query(sql, params, rm);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return nations;
	}
	
	@Override
	public List<Nation> getAllNationLessOneCountry(String countryCode) {
		List<Nation> nations = null;
		
		try {
			
			String sql = "SELECT Code code,Name name,Continent continent,Population popolation FROM country WHERE Code != :countryCode ORDER BY Name ASC";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("countryCode", countryCode);
			BeanPropertyRowMapper<Nation> rm = new BeanPropertyRowMapper<Nation>(Nation.class);
			nations = getNamedParameterJdbcTemplate().query(sql, params, rm);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return nations;
	}
	
	@Override
	public List<Nation> getAllContinentNations(String continent) {
		List<Nation> nations = null;
		String sql = "SELECT Code code,Name name,Continent continent,Population popolation FROM country WHERE Continent = :continent ORDER BY Name ASC";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("continent", continent);

		BeanPropertyRowMapper<Nation> rm = new BeanPropertyRowMapper<Nation>(Nation.class);
		nations = getNamedParameterJdbcTemplate().query(sql, params, rm);

		return nations;
	}

	@Override
	public List<String> getAllContinents() {
		List<String> continents = null;
		String sql = "SELECT DISTINCT Continent FROM country";

		continents = getJdbcTemplate().queryForList(sql, String.class);

		return continents;
	}
	
	@Override
	public Nation reserchNationForCode(String countryCode)
	{
		Nation nation=null;
		String sql = "SELECT Code code,Name name,Continent continent,Population popolation FROM country WHERE Code = :countryCode ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("countryCode", countryCode);
		BeanPropertyRowMapper<Nation> rm = new BeanPropertyRowMapper<Nation>(Nation.class);
		nation = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		
		return nation;
	}

}
