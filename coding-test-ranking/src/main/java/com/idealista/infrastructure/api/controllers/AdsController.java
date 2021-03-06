package com.idealista.infrastructure.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idealista.application.services.AdsService;
import com.idealista.infrastructure.api.dto.PublicAd;
import com.idealista.infrastructure.api.dto.QualityAd;

@RestController
@RequestMapping("/ads")
public class AdsController {

	@Autowired
	AdsService adsService;
	 
	@RequestMapping(value = "/quality-listing", method = RequestMethod.GET)
    public ResponseEntity<List<QualityAd>> qualityListing() throws Exception {
		List<QualityAd> result = adsService.getAdsForQualityListing();
   	 	return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/public-listing", method = RequestMethod.GET)
    public ResponseEntity<List<PublicAd>> publicListing() throws Exception {
    	List<PublicAd> result = adsService.getAdsForPublicListing();
    	 return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/calculate-scores", method = RequestMethod.POST)
    public  ResponseEntity<String> calculateScores() {	
    	if(adsService.calculateAllScores()) 
    		return ResponseEntity.ok().build();
    	else
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR: An error has occurred calculating scores");
    }   
}
