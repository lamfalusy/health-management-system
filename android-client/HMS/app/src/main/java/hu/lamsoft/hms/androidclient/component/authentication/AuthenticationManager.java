package hu.lamsoft.hms.androidclient.component.authentication;

import org.springframework.http.HttpAuthentication;

import hu.lamsoft.hms.androidclient.restapi.customer.vo.LogedInCustomerVO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class AuthenticationManager {

    private LogedInCustomerVO logedInCustomerVO;

    public void login(LogedInCustomerVO logedInCustomerVO) {
        this.logedInCustomerVO = logedInCustomerVO;
    }

    public void logout() {
        logedInCustomerVO = null;
    }

    public boolean customerLogedIn() {
        return logedInCustomerVO != null;
    }

    public String getToken() {
        if(customerLogedIn()) {
            return logedInCustomerVO.getToken();
        } else {
            return null;
        }
    }

    public HttpAuthentication getHttpAuthentication() {
        return new HttpAuthentication() {
            @Override
            public String getHeaderValue() {
                return getToken();
            }
        };
    }

}
