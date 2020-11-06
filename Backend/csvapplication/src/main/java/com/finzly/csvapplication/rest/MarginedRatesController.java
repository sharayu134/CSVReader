package com.finzly.csvapplication.rest;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.finzly.csvapplication.service.MarginedRatesService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MarginedRatesController{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private MarginedRatesService marginedRatesService;
	
	@PostMapping("/MarginedRates")
	public void add(@RequestParam("file") MultipartFile file) {
		logger.debug("inside post");
		
		try {
			marginedRatesService.save(file);
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
