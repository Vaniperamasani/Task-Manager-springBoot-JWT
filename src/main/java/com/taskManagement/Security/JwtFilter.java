package com.taskManagement.Security;

import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Collections;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public  class JwtFilter extends OncePerRequestFilter{
	
	private final String SECRET =
			"mysecretkeymysecretkeymysecretkey123456789";
	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain chain)
	        throws ServletException, IOException {

	    String path = request.getRequestURI();

	    // ✅ VERY IMPORTANT
	    // Skip login/register APIs
	    if (path.startsWith("/auth")) {
	        chain.doFilter(request, response);
	        return;
	    }

	    String header = request.getHeader("Authorization");

	    // ❌ No token
	    if (header == null || !header.startsWith("Bearer ")) {
	        response.sendError(401, "Token Missing");
	        return;
	    }

	    String token = header.substring(7);

	    try {

	    	Claims claims = Jwts.parserBuilder()
	    	        .setSigningKey(JwtUtil.getKey())
	    	        .build()
	    	        .parseClaimsJws(token)
	    	        .getBody();
	    	
	    	String username = claims.getSubject();

	    	UsernamePasswordAuthenticationToken auth =
	    	        new UsernamePasswordAuthenticationToken(
	    	                username,
	    	                null,
	    	                Collections.emptyList()
	    	        );

	    	SecurityContextHolder.getContext().setAuthentication(auth);

	    } catch (Exception e) {
	        response.sendError(401, "Invalid Token");
	        return;
	    }

	    chain.doFilter(request, response);
	}
	}
	

		
	


