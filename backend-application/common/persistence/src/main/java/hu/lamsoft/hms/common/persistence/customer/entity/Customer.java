package hu.lamsoft.hms.common.persistence.customer.entity;

import java.util.Date;

import javax.persistence.Entity;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Customer extends BaseEntity {

	private String email;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String password;

}
