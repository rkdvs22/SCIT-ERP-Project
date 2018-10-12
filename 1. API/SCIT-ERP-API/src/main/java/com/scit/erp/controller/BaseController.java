package com.scit.erp.controller;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.scit.erp.common.TokenManager;

public class BaseController {

	protected <T> T mappingModel(Object jsondata, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper();
		
		T resultObject = null;
        try {
        		if(jsondata instanceof HashMap) {
        			resultObject = mapper.readValue(mapper.writeValueAsString(jsondata), valueType);	
        		} else {
        			resultObject = mapper.readValue((String)jsondata, valueType);
        		}
        		
        } catch (IOException e) {
            e.printStackTrace();
        }
		return resultObject;	
	}
	
	protected String retreiveEmpcdFromToken(String token) {
		return TokenManager.retreiveToken(token);
	}
}
