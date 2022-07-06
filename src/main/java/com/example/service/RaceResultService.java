package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.RaceResult;
import com.example.repository.RaceResultRepository;

@Repository
@Transactional
public class RaceResultService {

	@Autowired
	private RaceResultRepository raceResultRepository;

	public List<RaceResult> findByName(String name) {
		return raceResultRepository.findByName(name);
	}

}
