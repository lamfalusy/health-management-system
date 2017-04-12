package hu.lamsoft.hms.common.restapi.security.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationService.class);
	private static final long EXPIRATIONTIME = 1000 * 60 * 60 * 4; // 4 hour
    private static final String SECRET = "ThisIsASecret";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";
    
    public void addAuthentication(HttpServletResponse response, String username) {
        String JWT = Jwts.builder()
			.setSubject(username)
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
			.signWith(SignatureAlgorithm.HS512, SECRET)
			.compact();
        response.addHeader(HEADER_STRING,TOKEN_PREFIX + " " + JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if(StringUtils.isNotBlank(token)) {
        	try {
        		return getAuthenticatedUser(token);
        	} catch (Exception e) {
        		LOGGER.warn("Exception while get authentication.", e);
        	}
        }
        return null;
    }
	
    private AuthenticatedUser getAuthenticatedUser(String token) {
    	String username = Jwts.parser()
			.setSigningKey(SECRET)
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
        if(username != null) {
            return new AuthenticatedUser(username);
        } else {
        	return null;
        }
    }
    
}
