package co.com.capgemini.bank.core.commons.utilities;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * Clase : JWTToken.java
 * Comentario : Clase que genera el token que será utilizado por los demás servicios
 */

public class JwtToken {

	public String getJWTToken(String username) {
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(PrintMessage.ROLE_USER);
		
		String token = Jwts
				.builder()
				.setId(PrintMessage.SOFTTEKJWT)
				.setSubject(username)
				.claim(PrintMessage.AUTHORITIES, grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, PrintMessage.SECRET.getBytes()).compact();

		return PrintMessage.BEARER + token;
	}
}
