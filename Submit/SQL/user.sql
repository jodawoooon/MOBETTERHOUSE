CREATE TABLE `user` (
  `user_seq` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_profile_image_url` varchar(100) DEFAULT NULL,
  `user_register_date` date DEFAULT NULL,
  `user_rank` varchar(3) DEFAULT '1',
  `user_message` varchar(45) DEFAULT '안녕하세요.',
  PRIMARY KEY (`user_seq`),
  UNIQUE KEY `user_email_UNIQUE` (`user_email`),
  KEY `rank_code_fk_idx` (`user_rank`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci