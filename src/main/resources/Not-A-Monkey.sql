CREATE TABLE `User` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(512),
  `password` varchar(128)
);

CREATE TABLE `Routine` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(512),
  `browser_id` int,
  `user_id` int
);

CREATE TABLE `Browser` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(1024),
  `driver_path` varchar(1024),
  `browser_type` varchar(128)
);

CREATE TABLE `Action` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(512),
  `routine_id` int
);

CREATE TABLE `Action_Argument` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `type` varchar(512),
  `value` varchar(1024),
  `action_id` int
);

ALTER TABLE `Routine` ADD FOREIGN KEY (`browser_id`) REFERENCES `Browser` (`id`);

ALTER TABLE `Routine` ADD FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);

ALTER TABLE `Action_Argument` ADD FOREIGN KEY (`action_id`) REFERENCES `Action` (`id`);

ALTER TABLE `Action` ADD FOREIGN KEY (`routine_id`) REFERENCES `Routine` (`id`);
