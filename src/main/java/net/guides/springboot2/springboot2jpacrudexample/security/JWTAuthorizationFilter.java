package net.guides.springboot2.springboot2jpacrudexample.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
	Environment environment;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,Environment environment)
	{ 
		super(authenticationManager);
		this.environment=environment;
	   
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 
		 String  authorizationHeader=request.getHeader(environment.getProperty("authorization.token.header.name"));

		 if(authorizationHeader==null || !authorizationHeader.startsWith(environment.getProperty("authorization.token.header.name.prefix")))
		 {
			 chain.doFilter(request, response);
			 return;
			 
		 }
		 UsernamePasswordAuthenticationToken  authentication=getAuthentication(request);

		 
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}
	protected  UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request)
	 {
		 
		 String  authorizationHeader=request.getHeader(environment.getProperty("authorization.token.header.name"));
		 
		  if(authorizationHeader==null)
		  {
			  
			  return null;
		  }
		  
		  String token=authorizationHeader.replace(environment.getProperty("authorization.token.header.name.prefix"), "");
		  
         String userId=Jwts.parser()
       		        .setSigningKey(environment.getProperty("token.secrete"))
       		        .parseClaimsJws(token)
       		        .getBody()
       		        .getSubject();
         
         return new UsernamePasswordAuthenticationToken(userId,null,new ArrayList<>());
		 
	 }
	  
}