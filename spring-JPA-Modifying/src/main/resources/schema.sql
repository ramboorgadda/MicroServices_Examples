CREATE TABLE IF NOT EXISTS `users` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `age` int  NOT NULL
);