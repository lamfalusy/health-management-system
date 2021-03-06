package hu.lamsoft.hms.regimen.persistence.regimen.dao;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.dao.BaseSearchDao;
import hu.lamsoft.hms.regimen.persistence.regimen.entity.Regimen;

@Repository
public interface RegimenDao extends BaseSearchDao<Regimen> {

}
