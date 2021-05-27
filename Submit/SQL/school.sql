CREATE TABLE `school` (
  `school_type` varchar(45) DEFAULT NULL,
  `school_name` varchar(45) NOT NULL,
  `school_zip_code` varchar(45) DEFAULT NULL,
  `school_address1` varchar(45) DEFAULT NULL,
  `school_address2` varchar(45) DEFAULT NULL,
  `school_phone` varchar(45) DEFAULT NULL,
  `school_web_add` varchar(100) DEFAULT NULL,
  `school_est_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`school_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci