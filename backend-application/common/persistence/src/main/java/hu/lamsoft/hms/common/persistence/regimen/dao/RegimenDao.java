package hu.lamsoft.hms.common.persistence.regimen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.regimen.entity.Regimen;

@Repository
public interface RegimenDao extends JpaRepository<Regimen, Long> {

}
