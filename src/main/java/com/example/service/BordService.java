package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.repository.BordRepository;

@Service
@Transactional
public class BordService {

	@Autowired
	private BordRepository bordRepository;

	public List<Article> findAll() {

		return bordRepository.findAll();
	}

	public void insert() {

		Article article = new Article();

		bordRepository.insert(article);

	}

	public void deleteById(Integer id) {

		bordRepository.deleteById(id);
	}

}
