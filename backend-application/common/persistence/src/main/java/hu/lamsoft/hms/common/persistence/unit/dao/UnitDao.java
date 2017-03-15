package hu.lamsoft.hms.common.persistence.unit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.unit.entity.Unit;

@Repository
public interface UnitDao extends JpaRepository<Unit, Long> {

}
