package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.HorseProfile;

@Repository
public class HorseProfileRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<HorseProfile> PROFILE_ROW_MAPPER = (rs, i) -> {

		HorseProfile profile = new HorseProfile();
		profile.setId(rs.getInt("id"));
		profile.setName(rs.getString("name"));
		profile.setBirthYear(rs.getString("birth_year"));
		profile.setGender(rs.getString("gender"));
		profile.setFather(rs.getString("father"));
		profile.setMother(rs.getString("mother"));
		return profile;
	};

	public List<HorseProfile> loadByName(String name) {
		String sql = "SELECT id, name, birth_year, gender, father, mother FROM horse_profile WHERE name = :name";

		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);

		List<HorseProfile> profileList = template.query(sql, param, PROFILE_ROW_MAPPER);

		return profileList;
	}

	public List<HorseProfile> loadById(Integer id) {
		String sql = "SELECT id, name, birth_year, gender, father, mother FROM horse_profile WHERE id = :id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		List<HorseProfile> profileList = template.query(sql, param, PROFILE_ROW_MAPPER);

		return profileList;
	}

	public List<HorseProfile> findByName(String name) {
		String sql = "SELECT id, name, birth_year, gender, father, mother"
				+ " FROM horse_profile WHERE name like :name ORDER BY id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");

		List<HorseProfile> profileList = template.query(sql, param, PROFILE_ROW_MAPPER);
		return profileList;
	}

	public List<HorseProfile> findByHeadName(String name) {
		String sql = "SELECT id, name, birth_year, gender, father, mother"
				+ " FROM horse_profile WHERE name like :name ORDER BY id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name + "%");

		List<HorseProfile> profileList = template.query(sql, param, PROFILE_ROW_MAPPER);
		return profileList;
	}

	public HorseProfile save(HorseProfile profile) {

		SqlParameterSource param = new BeanPropertySqlParameterSource(profile);

		if (profile.getName() == null) {
			String insertsql = "INSERT INTO horse_profile(name, birth_year, gender, father, mother)"
					+ " VALUES(:name, :age, :gender, :father, :mother)";
			template.update(insertsql, param);
		} else {
			String updatesql = "UPDATE horse_profile SET name = :name, birth_year = :birth_year, "
					+ " gender = :gender, father = :father, mother = :mother";
			template.update(updatesql, param);
		}

		return profile;
	}

	public void deleteByName(String name) {

		String deletesql = "DELETE FROM profile WHERE name = :name";

		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
		template.update(deletesql, param);
	}

}
