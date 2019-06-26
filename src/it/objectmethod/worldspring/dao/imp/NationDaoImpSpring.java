package it.objectmethod.worldspring.dao.imp;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import it.objectmethod.worldspring.domain.Nation;

@Component
public class NationDaoImpSpring extends NamedParameterJdbcDaoSupport implements INationDao{
	
	@Override
	public List<Nation> getAllNations(String continent)
	{
		List<Nation> nations=null;
		String sql = "SELECT DISTINCT Code,Name,Continent,Population FROM country WHERE Continent = :continent ORDER BY Name ASC";
		
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("continent", continent);

		BeanPropertyRowMapper<Nation> rm = new BeanPropertyRowMapper<Nation>(Nation.class);
		nations = getNamedParameterJdbcTemplate().query(sql, params, rm);
		
		return nations;
	}
	
	@Override
	public List<String> getAllContinents()
	{
		List<String> continents=null;
		String sql = "SELECT DISTINCT Continent FROM country";

		continents = getJdbcTemplate().queryForList(sql,String.class);
		
		return continents;
	}

	

}
