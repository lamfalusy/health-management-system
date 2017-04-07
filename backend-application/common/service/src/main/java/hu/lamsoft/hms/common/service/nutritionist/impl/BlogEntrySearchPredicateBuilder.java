package hu.lamsoft.hms.common.service.nutritionist.impl;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.persistence.nutritionist.entity.QBlogEntry;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.search.impl.AbstractSearchPredicateBuilder;

public class BlogEntrySearchPredicateBuilder extends AbstractSearchPredicateBuilder<BlogEntrySearchVO> {

	@Override
	public Predicate build(BlogEntrySearchVO blogEntrySearch) {
		BooleanBuilder builder = new BooleanBuilder();
		addLikePredicate(builder, blogEntrySearch.getWriterName(), QBlogEntry.blogEntry.writer.customer.firstname.concat(" ").concat(QBlogEntry.blogEntry.writer.customer.lastname));
		addLikePredicate(builder, blogEntrySearch.getTitle(), QBlogEntry.blogEntry.title);
		addLikePredicate(builder, blogEntrySearch.getPreface(), QBlogEntry.blogEntry.preface);
		addLikePredicate(builder, blogEntrySearch.getContent(), QBlogEntry.blogEntry.content);
		addInPredicate(builder, blogEntrySearch.getKeyWords(), QBlogEntry.blogEntry.keyWords.any().keyWord);
		return builder;
	}

}
