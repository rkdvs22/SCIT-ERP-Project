package com.scit.erp.common;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;
 
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class TokenManager {

	private static Key key;
	
	public static String createToken(String emp_cd) {
		
		if(key == null) generateKey();
		
		String compactJws = Jwts.builder()
                .setSubject(emp_cd)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

		return compactJws;
	}
	
	public static String retreiveToken(String token) {
		
		if(key == null) generateKey();
		
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();  
	    } catch(Exception e) {
	    		return null;
	    }		
	}
	
	private static void generateKey() {
		key = MacProvider.generateKey();
	}
	
}
