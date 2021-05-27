CREATE TABLE `board_file` (
  `FILE_ID` int NOT NULL AUTO_INCREMENT,
  `BOARD_ID` int NOT NULL,
  `FILE_NAME` varchar(500) NOT NULL,
  `FILE_SIZE` int NOT NULL,
  `FILE_CONTENT_TYPE` varchar(500) NOT NULL,
  `FILE_URL` varchar(500) NOT NULL,
  `REG_DT` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`FILE_ID`),
  KEY `BOARD_FILE_FK_idx` (`BOARD_ID`),
  CONSTRAINT `BOARD_FILE_FK` FOREIGN KEY (`BOARD_ID`) REFERENCES `board` (`BOARD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci