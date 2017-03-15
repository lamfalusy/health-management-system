package hu.lamsoft.hms.common.persistence.nutritionist.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class BlogEntryKeyWord extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "blog_entry_fk")
	private BlogEntry blogEntry;
	private String keyWord;
	
}
