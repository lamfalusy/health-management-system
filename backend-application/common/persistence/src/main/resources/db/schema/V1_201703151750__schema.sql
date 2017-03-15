
-- -----------------------------------------------------
-- Table `HMS`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`customer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(256) NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `birthday` DATE NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`nutritionist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`nutritionist` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_fk` BIGINT NOT NULL,
  `introduction` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `nutritionist_to_customer_fk_idx` (`customer_fk` ASC),
  CONSTRAINT `nutritionist_to_customer_fk`
    FOREIGN KEY (`customer_fk`)
    REFERENCES `HMS`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`blog_entry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`blog_entry` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `writer_fk` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `preface` LONGTEXT NOT NULL,
  `content` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `blog_entry_to_nutritionist_fk_idx` (`writer_fk` ASC),
  CONSTRAINT `blog_entry_to_nutritionist_fk`
    FOREIGN KEY (`writer_fk`)
    REFERENCES `HMS`.`nutritionist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`blog_entry_key_word`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`blog_entry_key_word` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `blog_entry_fk` BIGINT NOT NULL,
  `key_word` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `blog_entry_key_word_to_blog_entry_fk_idx` (`blog_entry_fk` ASC),
  CONSTRAINT `blog_entry_key_word_to_blog_entry_fk`
    FOREIGN KEY (`blog_entry_fk`)
    REFERENCES `HMS`.`blog_entry` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`unit` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `short_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`customer_historical_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`customer_historical_data` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `unit_fk` BIGINT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_historical_data_to_unit_fk_idx` (`unit_fk` ASC),
  CONSTRAINT `customer_historical_data_to_unit_fk`
    FOREIGN KEY (`unit_fk`)
    REFERENCES `HMS`.`unit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`customer_historical_data_value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`customer_historical_data_value` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_fk` BIGINT NOT NULL,
  `customer_historical_data_fk` BIGINT NOT NULL,
  `valid_at` TIMESTAMP NOT NULL,
  `long_value` BIGINT NULL,
  `string_value` VARCHAR(45) NULL,
  `double_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_historical_data_value_to_customer_fk_idx` (`customer_fk` ASC),
  INDEX `customer_historical_data_value_to_chd_fk_idx` (`customer_historical_data_fk` ASC),
  CONSTRAINT `customer_historical_data_value_to_customer_fk`
    FOREIGN KEY (`customer_fk`)
    REFERENCES `HMS`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customer_historical_data_value_to_chd_fk`
    FOREIGN KEY (`customer_historical_data_fk`)
    REFERENCES `HMS`.`customer_historical_data` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`quantity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`quantity` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `unit_fk` BIGINT NOT NULL,
  `long_value` BIGINT NULL,
  `string_value` VARCHAR(45) NULL,
  `double_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `quantity_to_unit_fk_idx` (`unit_fk` ASC),
  CONSTRAINT `quantity_to_unit_fk`
    FOREIGN KEY (`unit_fk`)
    REFERENCES `HMS`.`unit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`recipe` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `story` LONGTEXT NOT NULL,
  `description` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`food` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `energy_in_kcal` BIGINT NULL,
  `energy_in_kj` BIGINT NULL,
  `water_in_g` BIGINT NULL,
  `protein_in_g` BIGINT NULL,
  `carbohydrates_in_g` BIGINT NULL,
  `sugar_in_g` BIGINT NULL,
  `fat_in_g` BIGINT NULL,
  `saturated_fat_in_g` BIGINT NULL,
  `monounsaturated_fat_in_g` BIGINT NULL,
  `polyunsaturated_fat_in_g` BIGINT NULL,
  `cholesterol_in_mg` BIGINT NULL,
  `fiber_in_g` BIGINT NULL,
  `emotional` BIGINT NULL,
  `healthy` BIGINT NULL,
  `recipe_fk` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `energy_in_kcal_quantity_fk_idx` (`energy_in_kcal` ASC),
  INDEX `energy_in_kj_quantity_fk_idx` (`energy_in_kj` ASC),
  INDEX `water_quantity_fk_idx` (`water_in_g` ASC),
  INDEX `protein_quantity_fk_idx` (`protein_in_g` ASC),
  INDEX `carbohydrates_quantity_fk_idx` (`carbohydrates_in_g` ASC),
  INDEX `sugars_quantity_fk_idx` (`sugar_in_g` ASC),
  INDEX `fat_quantity_fk_idx` (`fat_in_g` ASC),
  INDEX `saturated_fat_quantity_fk_idx` (`saturated_fat_in_g` ASC),
  INDEX `monounsaturated_fat_quantity_fk_idx` (`monounsaturated_fat_in_g` ASC),
  INDEX `polyunsaturated_fat_quantity_fk_idx` (`polyunsaturated_fat_in_g` ASC),
  INDEX `cholesterol_quantity_fk_idx` (`cholesterol_in_mg` ASC),
  INDEX `fiber_quantity_fk_idx` (`fiber_in_g` ASC),
  INDEX `emotional_quantity_fk_idx` (`emotional` ASC),
  INDEX `healthy_quantity_fk_idx` (`healthy` ASC),
  INDEX `food_to_recipe_fk_idx` (`recipe_fk` ASC),
  CONSTRAINT `energy_in_kcal_quantity_fk`
    FOREIGN KEY (`energy_in_kcal`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `energy_in_kj_quantity_fk`
    FOREIGN KEY (`energy_in_kj`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `water_quantity_fk`
    FOREIGN KEY (`water_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `protein_quantity_fk`
    FOREIGN KEY (`protein_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `carbohydrates_quantity_fk`
    FOREIGN KEY (`carbohydrates_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sugars_quantity_fk`
    FOREIGN KEY (`sugar_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fat_quantity_fk`
    FOREIGN KEY (`fat_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `saturated_fat_quantity_fk`
    FOREIGN KEY (`saturated_fat_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `monounsaturated_fat_quantity_fk`
    FOREIGN KEY (`monounsaturated_fat_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `polyunsaturated_fat_quantity_fk`
    FOREIGN KEY (`polyunsaturated_fat_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cholesterol_quantity_fk`
    FOREIGN KEY (`cholesterol_in_mg`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fiber_quantity_fk`
    FOREIGN KEY (`fiber_in_g`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `emotional_quantity_fk`
    FOREIGN KEY (`emotional`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `healthy_quantity_fk`
    FOREIGN KEY (`healthy`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `food_to_recipe_fk`
    FOREIGN KEY (`recipe_fk`)
    REFERENCES `HMS`.`recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`customer_meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`customer_meal` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_fk` BIGINT NOT NULL,
  `quantity_fk` BIGINT NOT NULL,
  `food_fk` BIGINT NOT NULL,
  `time_of_meal` TIMESTAMP NOT NULL,
  `meal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_meal_to_customer_fk_idx` (`customer_fk` ASC),
  INDEX `customer_meal_to_quantity_fk_idx` (`quantity_fk` ASC),
  INDEX `customer_meal_to_food_fk_idx` (`food_fk` ASC),
  CONSTRAINT `customer_meal_to_customer_fk`
    FOREIGN KEY (`customer_fk`)
    REFERENCES `HMS`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customer_meal_to_quantity_fk`
    FOREIGN KEY (`quantity_fk`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customer_meal_to_food_fk`
    FOREIGN KEY (`food_fk`)
    REFERENCES `HMS`.`food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`recipe_component`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`recipe_component` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `recipe_fk` BIGINT NOT NULL,
  `food_fk` BIGINT NOT NULL,
  `quantity_fk` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `recipe_component_to_recipe_fk_idx` (`recipe_fk` ASC),
  INDEX `recipe_component_to_food_fk_idx` (`food_fk` ASC),
  INDEX `recipe_component_to_quantity_fk_idx` (`quantity_fk` ASC),
  CONSTRAINT `recipe_component_to_recipe_fk`
    FOREIGN KEY (`recipe_fk`)
    REFERENCES `HMS`.`recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `recipe_component_to_food_fk`
    FOREIGN KEY (`food_fk`)
    REFERENCES `HMS`.`food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `recipe_component_to_quantity_fk`
    FOREIGN KEY (`quantity_fk`)
    REFERENCES `HMS`.`quantity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`regimen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`regimen` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `creator_fk` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `regimen_to_nutritionist_fk_idx` (`creator_fk` ASC),
  CONSTRAINT `regimen_to_nutritionist_fk`
    FOREIGN KEY (`creator_fk`)
    REFERENCES `HMS`.`nutritionist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`regimen_day`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`regimen_day` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`regimen_day_meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`regimen_day_meal` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `regimen_day_fk` BIGINT NOT NULL,
  `meal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `regimen_day_meal_to_regimen_day_idx` (`regimen_day_fk` ASC),
  CONSTRAINT `regimen_day_meal_to_regimen_day`
    FOREIGN KEY (`regimen_day_fk`)
    REFERENCES `HMS`.`regimen_day` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`regimen_day_meal_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`regimen_day_meal_item` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `regimen_day_meal_fk` BIGINT NOT NULL,
  `food_fk` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `regimen_day_meal_item_to_regimen_day_meal_fk_idx` (`regimen_day_meal_fk` ASC),
  INDEX `regimen_day_meal_item_to_food_idx` (`food_fk` ASC),
  CONSTRAINT `regimen_day_meal_item_to_regimen_day_meal_fk`
    FOREIGN KEY (`regimen_day_meal_fk`)
    REFERENCES `HMS`.`regimen_day_meal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `regimen_day_meal_item_to_food`
    FOREIGN KEY (`food_fk`)
    REFERENCES `HMS`.`food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`regimen_week`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`regimen_week` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `regimen_fk` BIGINT NOT NULL,
  `order_number` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `regimen_week_to_regimen_idx` (`regimen_fk` ASC),
  CONSTRAINT `regimen_week_to_regimen`
    FOREIGN KEY (`regimen_fk`)
    REFERENCES `HMS`.`regimen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`regimen_day_to_week`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`regimen_day_to_week` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `regimen_day_fk` BIGINT NOT NULL,
  `regimen_week_fk` BIGINT NOT NULL,
  `day_of_week` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `regimen_day_to_week_to_regimen_day_fk_idx` (`regimen_day_fk` ASC),
  INDEX `regimen_day_to_week_to_regimen_week_idx` (`regimen_week_fk` ASC),
  CONSTRAINT `regimen_day_to_week_to_regimen_day_fk`
    FOREIGN KEY (`regimen_day_fk`)
    REFERENCES `HMS`.`regimen_day` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `regimen_day_to_week_to_regimen_week`
    FOREIGN KEY (`regimen_week_fk`)
    REFERENCES `HMS`.`regimen_week` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `HMS`.`regimen_for_customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HMS`.`regimen_for_customer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_fk` BIGINT NOT NULL,
  `regimen_fk` BIGINT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `regimen_for_customer_to_customer_fk_idx` (`customer_fk` ASC),
  INDEX `regimen_for_customer_to_regimen_fk_idx` (`regimen_fk` ASC),
  CONSTRAINT `regimen_for_customer_to_customer_fk`
    FOREIGN KEY (`customer_fk`)
    REFERENCES `HMS`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `regimen_for_customer_to_regimen_fk`
    FOREIGN KEY (`regimen_fk`)
    REFERENCES `HMS`.`regimen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
