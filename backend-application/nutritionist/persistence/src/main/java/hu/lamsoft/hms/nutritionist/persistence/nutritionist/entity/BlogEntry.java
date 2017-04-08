package hu.lamsoft.hms.nutritionist.persistence.nutritionist.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class BlogEntry extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "writer_fk")
	private Nutritionist writer;
	private String title;
	@Lob
	private String preface;
	@Lob
	private String content;
	@OneToMany(mappedBy="blogEntry", fetch=FetchType.EAGER)
	private List<BlogEntryKeyWord> keyWords;
	
}
