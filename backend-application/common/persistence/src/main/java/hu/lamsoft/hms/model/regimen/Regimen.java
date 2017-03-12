package hu.lamsoft.hms.model.regimen;

import java.util.List;

import hu.lamsoft.hms.model.nutritionist.Nutritionist;

public class Regimen {

	private String name;
	private String description;
	private Nutritionist creator;
	private List<RegimenWeek> weeks;
	
}
