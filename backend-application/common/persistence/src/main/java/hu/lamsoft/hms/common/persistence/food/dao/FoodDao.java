package hu.lamsoft.hms.common.persistence.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.food.entity.Food;

@Repository
public interface FoodDao extends JpaRepository<Food, Long> {

}
