package hu.lamsoft.hms.androidclient.component.authentication;

import org.springframework.http.HttpAuthentication;

import hu.lamsoft.hms.androidclient.component.session.Session;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.LogedInCustomerVO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class AuthenticationManager {

    private LogedInCustomerVO logedInCustomerVO;

    public void login(LogedInCustomerVO logedInCustomerVO) {
        this.logedInCustomerVO = logedInCustomerVO;
        Session.instance.getCustomerData().build();
    }

    public void setCustomer(CustomerDTO customerVO) {
        this.logedInCustomerVO.setCustomerDTO(customerVO);
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

    public CustomerDTO getCustomer() {
        if(customerLogedIn()) {
            return logedInCustomerVO.getCustomerDTO();
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
