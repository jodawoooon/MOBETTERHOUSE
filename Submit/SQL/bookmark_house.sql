CREATE TABLE `bookmark_house` (
  `USER_SEQ` int NOT NULL,
  `DEAL_NO` int NOT NULL,
  PRIMARY KEY (`USER_SEQ`,`DEAL_NO`),
  KEY `bookmark_housedeal_fk_idx` (`DEAL_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci