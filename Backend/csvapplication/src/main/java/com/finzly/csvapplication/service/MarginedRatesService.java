package com.finzly.csvapplication.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finzly.csvapplication.dao.MarginedRatesRepository;
import com.finzly.csvapplication.model.MarginedRates;
import com.finzly.csvapplication.util.CSVHelper;

@Service
public class MarginedRatesService {
	
	 @Autowired
	 MarginedRatesRepository marginedRatesRepository;
	 


	  public void save(MultipartFile file) throws NumberFormatException, ParseException {
	    try {
	      List<MarginedRates> marginedRates = CSVHelper.csvToMarginedRate(file.getInputStream());
	      marginedRatesRepository.saveAll(marginedRates);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
	
}
