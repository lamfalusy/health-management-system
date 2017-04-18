package hu.lamsoft.hms.androidclient.restapi.customer.vo;

import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import lombok.Data;

/**
 * Created by admin on 2017. 04. 15..
 */
@Data
public class LogedInCustomerVO {

    private CustomerDTO customerDTO;
    private String token;

}
