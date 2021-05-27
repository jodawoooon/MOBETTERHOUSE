CREATE TABLE `houseinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `dong` varchar(30) NOT NULL,
  `AptName` varchar(50) NOT NULL,
  `code` varchar(30) NOT NULL,
  `buildYear` varchar(30) DEFAULT NULL,
  `jibun` varchar(30) DEFAULT NULL,
  `lat` varchar(30) DEFAULT NULL,
  `lng` varchar(30) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `house_info_gugun_fk_idx` (`code`),
  KEY `house_name_idx` (`AptName`),
  CONSTRAINT `house_info_gugun_fk` FOREIGN KEY (`code`) REFERENCES `gugun_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5990 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci