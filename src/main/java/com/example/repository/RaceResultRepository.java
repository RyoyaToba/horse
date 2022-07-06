package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.RaceResult;

@Repository
public class RaceResultRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<RaceResult> RACERESULT_ROW_MAPPER = (rs, i) -> {

		RaceResult raceResult = new RaceResult();
		raceResult.setId(rs.getInt("id"));
		raceResult.setRaceId(rs.getString("race_id"));
		raceResult.setRank(rs.getInt("rank"));
		raceResult.setWaku(rs.getInt("waku"));
		raceResult.setHorseNumber(rs.getInt("horse_number"));
		raceResult.setHorseName(rs.getString("horse_name"));
		raceResult.setGender(rs.getString("gender"));
		raceResult.setAge(rs.getInt("age"));
		raceResult.setJockeyName(rs.getString("jockey_name"));
		raceResult.setJockeyWeight(rs.getInt("jockey_weight"));
		raceResult.setRaceTime(rs.getString("race_time"));

		return raceResult;

	};

	public List<RaceResult> findByName(String name) {

		String sql = "SELECT * FROM race_result WHERE horse_name = :name";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
		List<RaceResult> raceResultList = template.query(sql, param, RACERESULT_ROW_MAPPER);
		return raceResultList;
	}

//	public List<RaceResult> find(String name, String gender) {
//
//		StringBuilder sql = new StringBuilder("SELECT * FROM race_result");
//
//		if (name != "") {
//			sql.append("WHERE horse_name = : name");
//		}
//		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
//		List<RaceResult> raceResultList = template.query(sql, param, RACERESULT_ROW_MAPPER);
//		return raceResultList;
//	}

}
