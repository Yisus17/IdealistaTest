package com.idealista.application.services.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.idealista.application.services.AdsService;
import com.idealista.infrastructure.persistence.AdVO;
import com.idealista.infrastructure.persistence.InMemoryPersistence;
import com.idealista.infrastructure.persistence.PictureVO;

@Service
public class AdsServiceImpl implements AdsService{


	@Value("${config.variables.important-words}")
	private String [] importantWords;


	@Autowired
	InMemoryPersistence inMemoryPersistence;

	@Override
	public void calculateAllScores() {

		List<AdVO> currentAds = inMemoryPersistence.getAds();

		for (AdVO adVO : currentAds) {

			//Score by pictures
			Integer score = 0;
			if(adVO.getPictures().isEmpty()) {
				score+=-10;
			}else {
				score+=getScoreByPicturesQuality(adVO.getPictures());
			}

			//Score by description
			score += getScoreForDescription(adVO.getDescription(), adVO.getTypology());

			//Score by complete ad
			Integer scoreAux = getScoreByCompleteAd(adVO);
			score += scoreAux;
			System.out.println(score);

		}


	}

	//
	private Integer getScoreByPicturesQuality(List<Integer> pictures) {
		Integer picturesScore = 0;

		for (Integer idPicture : pictures) {
			PictureVO currentPicture = inMemoryPersistence.getPictureById(idPicture);
			if(currentPicture.getQuality().equals("SD")) {
				picturesScore+=10;
			}else if(currentPicture.getQuality().equals("HD")) {
				picturesScore+=20;
			}
		}

		return picturesScore;
	}


	private Integer getScoreForDescription(String description, String typology) {
		Integer score = 0;

		if(description.trim().length()>1) {
			score+=5;
		}

		//Init our word list filtering special chars and blank spaces
		description = description.replaceAll("[^a-zA-ZáéíóúüñÁÉÍÓÚÑ0-9]", " "); 
		String [] wordsArray = description.split("\\s");
		List<String> wordsTemp = Arrays.asList(wordsArray);

		List<String> words = wordsTemp.stream()	
				.filter(word -> !"".equals(word))
				.map(String::toLowerCase)
				.collect(Collectors.toList());


		//Scoring by word quantity and tipology
		Integer wordQuantity = words.size();
		if(typology.toUpperCase().equals("FLAT")) {
			if(wordQuantity >=20 && wordQuantity <=49 ) {
				score += 10;
			}else if(wordQuantity >=50) {
				score+= 30;
			}
		}else if(typology.toUpperCase().equals("CHALET")) {
			if(wordQuantity >=50) {
				score += 20;
			}
		}

		//Looking for specific words
		for (String importantWord : importantWords) {
			importantWord = importantWord.toLowerCase();
			if(words.contains(importantWord)) {
				score+=5;
			}
		}

		return score;
	}


	private Integer getScoreByCompleteAd(AdVO adVO) {

		//Picture check
		if(adVO.getPictures().isEmpty()) {
			return 0;
		}
		
		
		switch (adVO.getTypology()) {
		case "CHALET":
			if(adVO.getHouseSize() != null) {
				if(adVO.getHouseSize()<=0) {
					return 0;
				}
			}else {
				return 0;
			}
			
			if(adVO.getGardenSize() != null) {
				if(adVO.getGardenSize()<=0) {
					return 0;
				}
			}else {
				return 0;
			}
			break;
		case "FLAT":
			if(adVO.getHouseSize() != null) {
				if(adVO.getHouseSize()<=0) {
					return 0;
				}
			}else {
				return 0;
			}
			break;
		}




		return 40;
	}

}
