CREATE TABLE `customer` (
  `id` int NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `amg`.`vehicle` (
  `id` INT NOT NULL,
  `brand` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `model_year` YEAR(4) NULL,
  `vehicle_identification_number` VARCHAR(45) NULL,
  `price` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id`));