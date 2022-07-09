package com.example.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.HorseProfile;
import com.example.domain.RaceResult;
import com.example.form.ArticleForm;
import com.example.form.HorseProfileForm;
import com.example.repository.BordRepository;
import com.example.repository.RaceResultRepository;
import com.example.service.HorseProfileService;

@Controller
@RequestMapping("/horse")
public class HorseController {

	@Autowired
	private HorseProfileService horseProfileService;

	@Autowired
	private RaceResultRepository raceResultService;

	@Autowired
	private BordRepository bordService;

	@Autowired
	private ServletContext application;

	@Autowired
	private HorseProfileForm setUphorseProfileForm() {
		return new HorseProfileForm();
	};

	/**
	 * トップ画面へ遷移
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String index() {
//		throw new RuntimeErrorException(null, null);
		return "index";
	}

	@RequestMapping("/news")
	public String news() {
		return "news";
	}

	/**
	 * レース検索画面へ遷移
	 * 
	 * @return
	 */
	@RequestMapping("/race")
	public String race() {
		return "inputRace";
	}

	/**
	 * 馬検索画面へ遷移
	 * 
	 * @return
	 */
	@RequestMapping("/profile")
	public String profile() {
		return "horseProfile";
	}

	/**
	 * 掲示板画面表示
	 * 
	 * @return
	 */
	@RequestMapping("/bord")
	public String bord() {
		List<Article> articleList = bordService.findAll();
		application.setAttribute("articleList", articleList);
		return "bord";
	}


	/**
	 * 馬名曖昧検索
	 * 
	 * @param name2
	 * @param model
	 * @return
	 */
	@RequestMapping("/horse-profile")
	public String horseProfile(String name, Model model) {
		List<HorseProfile> horseProfiles = horseProfileService.findByName(name);
		model.addAttribute("profileList", horseProfiles);
		return "horseProfile";
	}

	@RequestMapping("/horse-detail")
	public String horseDetail(Integer id, Model model) {
		HorseProfile horseProfile = horseProfileService.loadById(id).get(0);
		model.addAttribute("horseProfile", horseProfile);
		return "horseDetail";
	}



	/**
	 * レース検索
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/execute4")
	public String execute4(String name, Model model) {
		List<RaceResult> raceResultList = raceResultService.findByName(name);
		model.addAttribute("raceResultList", raceResultList);
		return "inputRace";
	}

	/**
	 * 掲示板投稿
	 * 
	 * @param articleForm
	 * @return
	 */
	@RequestMapping("/articleInput")
	public String articleInput(ArticleForm articleForm) {
		Article article = new Article();
		BeanUtils.copyProperties(articleForm, article);
		bordService.insert(article);
		bord();
		return "bord";
	}

	/**
	 * 記事の削除
	 * 
	 * @param id
	 * @return 掲示板画面へ返します
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) {
		System.out.println(id);
		bordService.deleteById(id);
		bord();
		return "bord";
	}

}
