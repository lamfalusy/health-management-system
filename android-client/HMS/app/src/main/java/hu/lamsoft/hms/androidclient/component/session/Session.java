package hu.lamsoft.hms.androidclient.component.session;

import hu.lamsoft.hms.androidclient.component.authentication.AuthenticationManager;

/**
 * Created by admin on 2017. 04. 15..
 */

public class Session {

    public static Session instance;

    static {
        instance = new Session();
    }

    private AuthenticationManager authenticationManager = new AuthenticationManager();

    private Session() {
        // Nothing to do here
    }

    public AuthenticationManager getAuthenticationManager() {
        return this.authenticationManager;
    }
}
