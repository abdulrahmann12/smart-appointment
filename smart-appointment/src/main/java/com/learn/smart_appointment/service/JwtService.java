package com.learn.smart_appointment.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.learn.smart_appointment.config.Messages;
import com.learn.smart_appointment.exception.InvalidTokenException;
import com.learn.smart_appointment.entity.Token;
import com.learn.smart_appointment.entity.User;
import com.learn.smart_appointment.repository.TokenRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {

	private final TokenRepository tokenRepository;

	@Value("${secret}")
	private String secret;
	
	@Value("${expiration}")
	private Long expiration;
	
	@Value("${refreshExpiration}")
	private Long refreshExpiration;

	private Key getSignKey() {
	    return Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims,userDetails.getUsername(),expiration);
	}
	
	public String generateRefreshToken(UserDetails userDetails) {
	    Map<String, Object> claims = new HashMap<>();
	    return createToken(claims, userDetails.getUsername(), refreshExpiration);
	}
	
	private String createToken(Map<String, Object> claims, String subject,Long expirationTime) {
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+expirationTime))
	            .signWith(getSignKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public Boolean validateToken(String token,UserDetails userDetails) {
		String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpiration(token));
	}

	public String extractUsername(String token) {
		return extractClaims(token, Claims :: getSubject);
	}
	
	public <T> T extractClaims(String token , Function<Claims, T> claimsResolver) {	
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
	    try {
	        return Jwts
	                .parserBuilder()
	                .setSigningKey(getSignKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    } catch (Exception e) {
	        throw new InvalidTokenException(Messages.TOKEN_NOT_FOUND);
	    }
	}
		
	private boolean isTokenExpiration(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	private Date extractExpiration(String token) {
		return extractClaims(token, Claims :: getExpiration);

	}


	
	public void saveUserToken(User user, String jwtToken) {
	    Token token = Token.builder()
	            .user(user)
	            .token(jwtToken)
	            .expired(false)
	            .revoked(false)
	            .build();
	    tokenRepository.save(token);
	}
	
	@Transactional
	public void revokeAllUserTokens(User user) {
	    List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
	    validUserTokens.forEach(token -> {
	        token.setExpired(true);
	        token.setRevoked(true);
	    });
	    tokenRepository.saveAll(validUserTokens);
	}
	
}