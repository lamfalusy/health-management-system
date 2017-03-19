package hu.lamsoft.hms.common.restapi.security.jwt;

import lombok.Data;

@Data
public class AccountCredentials {

    private String username;
    private String password;
	
}
