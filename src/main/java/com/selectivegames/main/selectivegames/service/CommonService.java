package com.selectivegames.main.selectivegames.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CommonService {
	@Autowired
	private ObjectMapper objectMapper;

	private static Logger logger = LoggerFactory.getLogger(CommonService.class);

	@Value("${country.code}")
	private String CountryCode;

	public String objToJson(Object obj) {
		String objJackson = "";
		try {
			objJackson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.debug("failed conversion: Pfra object to Json", e);
		}
		return objJackson;
	}

	public Long parseMSIDN(Long ani) {
		return Long.parseLong(Long.toString(ani).substring(CountryCode.length()));
	}
}
