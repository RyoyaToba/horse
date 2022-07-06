package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.HorseProfile;
import com.example.repository.HorseProfileRepository;

@Service
@Transactional
public class HorseProfileService {

	@Autowired
	private HorseProfileRepository repository;

	public List<HorseProfile> loadByName(String name) {
		return repository.loadByName(name);
	}

	public List<HorseProfile> loadById(Integer id) {
		return repository.loadById(id);
	}

	public List<HorseProfile> findByName(String name) {
		return repository.findByName(name);
	}

	public List<HorseProfile> findByHeadName(String name) {
		return repository.findByHeadName(name);
	}

	public HorseProfile save(HorseProfile profile) {
		return repository.save(profile);
	}

	public void deleteByName(String name) {
		repository.deleteByName(name);
	}

}
