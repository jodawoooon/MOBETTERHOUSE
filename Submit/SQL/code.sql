CREATE TABLE `code` (
  `group_code` varchar(3) NOT NULL,
  `code` varchar(3) NOT NULL,
  `code_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`group_code`,`code`),
  CONSTRAINT `code_group_code_fk` FOREIGN KEY (`group_code`) REFERENCES `group_code` (`group_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci