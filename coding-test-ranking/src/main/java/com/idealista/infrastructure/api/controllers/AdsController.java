package com.idealista.infrastructure.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idealista.application.services.AdsService;
import com.idealista.infrastructure.api.dto.PublicAd;
import com.idealista.infrastructure.api.dto.QualityAd;
import com.idealista.infrastructure.persistence.AdVO;
import com.idealista.infrastructure.persistence.InMemoryPersistence;;

@RestController
@RequestMapping("/ads")
public class AdsController {

	@Autowired
	AdsService adsService;
	
	@Autowired
	InMemoryPersistence repo;
	
    
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String getToken() {
        //TODO rellena el cuerpo del método
        return "Aqui ira el token";
    }
	
	//TODO añade url del endpoint
    public ResponseEntity<List<QualityAd>> qualityListing() {
        //TODO rellena el cuerpo del método
        return ResponseEntity.notFound().build();
    }

    //TODO añade url del endpoint
    public ResponseEntity<List<PublicAd>> publicListing() {
        //TODO rellena el cuerpo del método
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/calculate-scores", method = RequestMethod.POST)
    public  List<AdVO> calculateScores() {
    	return adsService.calculateAllScores();	
    } 
    
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public List<AdVO> test() {
    	return repo.getAds();
    	
    }  
}
