CREATE TABLE `gugun_code` (
  `code` varchar(5) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sido_code` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `gugun_to_sido_fk_idx` (`sido_code`),
  CONSTRAINT `gugun_to_sido_fk` FOREIGN KEY (`sido_code`) REFERENCES `sido_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci