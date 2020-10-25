package com.idealista.application.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.idealista.infrastructure.api.dto.PublicAd;
import com.idealista.infrastructure.api.dto.QualityAd;
import com.idealista.infrastructure.persistence.AdVO;

public interface AdsService {

	public Boolean calculateAllScores();
	
	public List <AdVO> getAllAds();

	public List<PublicAd> getAdsForPublicListing();

	public List<QualityAd> getAdsForQualityListing();

}
