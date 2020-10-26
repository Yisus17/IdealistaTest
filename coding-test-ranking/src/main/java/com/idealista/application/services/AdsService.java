package com.idealista.application.services;

/** Business logic about ads managment
 * @author Jesús Arévalo
 * @version 1.0
 * @since 1.0
*/

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
