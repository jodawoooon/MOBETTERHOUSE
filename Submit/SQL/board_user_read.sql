CREATE TABLE `board_user_read` (
  `board_id` int NOT NULL,
  `user_seq` int NOT NULL,
  PRIMARY KEY (`board_id`,`user_seq`),
  CONSTRAINT `read_board_fk` FOREIGN KEY (`board_id`) REFERENCES `board` (`BOARD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci