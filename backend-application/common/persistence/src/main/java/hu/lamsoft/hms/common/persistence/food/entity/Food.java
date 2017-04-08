package hu.lamsoft.hms.common.persistence.food.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.unit.entity.Quantity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Food extends BaseEntity {

    private String name;
    @OneToOne
	@JoinColumn(name = "energy_in_kcal")
    private Quantity energyInKcal;
    @OneToOne
	@JoinColumn(name = "energy_in_kj")
    private Quantity energyInKj;
    @OneToOne
	@JoinColumn(name = "water_in_g")
    private Quantity waterInG;
    @OneToOne
	@JoinColumn(name = "protein_in_g")
    private Quantity proteinInG;
    @OneToOne
	@JoinColumn(name = "carbohydrates_in_g")
    private Quantity carbohydratesInG;
    @OneToOne
	@JoinColumn(name = "sugar_in_g")
    private Quantity sugarInG;
    @OneToOne
	@JoinColumn(name = "fat_in_g")
    private Quantity fatInG;
    @OneToOne
	@JoinColumn(name = "saturated_fat_in_g")
    private Quantity saturatedFatInG;
    @OneToOne
	@JoinColumn(name = "monounsaturated_fat_in_g")
    private Quantity monounsaturatedFatInG;
    @OneToOne
	@JoinColumn(name = "polyunsaturated_fat_in_g")
    private Quantity polyunsaturatedFatInG;
    @OneToOne
	@JoinColumn(name = "cholesterol_in_mg")
    private Quantity cholesterolInMg;
    @OneToOne
	@JoinColumn(name = "fiber_in_g")
    private Quantity fiberInG;
    @OneToOne
	@JoinColumn(name = "emotional")
    private Quantity emotional;
    @OneToOne
	@JoinColumn(name = "healthy")
    private Quantity healthy;
    @OneToOne
	@JoinColumn(name = "recipe_fk")
    private Recipe recipe;
    
}
