package com.idealista.application.services;

import java.util.List;

import com.idealista.infrastructure.persistence.AdVO;

public interface AdsService {

	public List<AdVO> calculateAllScores();

}
