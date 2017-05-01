package hu.lamsoft.hms.androidclient.restapi.customer.dto;

import java.util.Date;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerHistoricalDataValueDTO extends BaseDTO {

    private CustomerDTO customer;
    private CustomerHistoricalDataDTO customerHistoricalData;
    private Date validAt;
    private Long longValue;
    private String stringValue;
    private Double doubleValue;

}
