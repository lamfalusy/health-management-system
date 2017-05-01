package hu.lamsoft.hms.androidclient.restapi.customer.dto;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.unit.dto.UnitDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerHistoricalDataDTO extends BaseDTO {

    private String code;
    private UnitDTO unit;

}
