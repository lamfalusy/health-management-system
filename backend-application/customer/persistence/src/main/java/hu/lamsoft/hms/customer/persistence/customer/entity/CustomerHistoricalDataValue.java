package hu.lamsoft.hms.customer.persistence.customer.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerHistoricalDataValue extends BaseEntity {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_fk")
	private Customer customer;
	@OneToOne
	@JoinColumn(name = "customer_historical_data_fk")
	private CustomerHistoricalData customerHistoricalData;
	private Date validAt;
	private Long longValue;
	private String stringValue;
	private Double doubleValue;
	
}
