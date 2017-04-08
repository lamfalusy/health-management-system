package hu.lamsoft.hms.nutritionist.persistence.nutritionist.dao;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.dao.BaseSearchDao;
import hu.lamsoft.hms.nutritionist.persistence.nutritionist.entity.BlogEntry;

@Repository
public interface BlogEntryDao extends BaseSearchDao<BlogEntry> {

}
