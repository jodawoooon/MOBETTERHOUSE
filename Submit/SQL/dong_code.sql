CREATE TABLE `dong_code` (
  `code` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `city_code` varchar(2) DEFAULT NULL,
  `city_name` varchar(20) NOT NULL,
  `gugun_code` varchar(5) DEFAULT NULL,
  `gugun_name` varchar(20) NOT NULL,
  PRIMARY KEY (`code`),
  KEY `dong_gugun_fk_idx` (`gugun_code`),
  KEY `dong_sido_fk_idx` (`city_code`),
  CONSTRAINT `dong_gugun_fk` FOREIGN KEY (`gugun_code`) REFERENCES `gugun_code` (`code`),
  CONSTRAINT `dong_sido_fk` FOREIGN KEY (`city_code`) REFERENCES `sido_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci