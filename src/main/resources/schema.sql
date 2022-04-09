CREATE TABLE if not exists `student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) NOT NULL UNIQUE ,
  `user_name` varchar(255),
  `email` varchar(255) UNIQUE ,
  `password` varchar(255),
  `first_name` varchar(255),
  `last_name` varchar(255),
  `session` varchar(255),
  `blood_group` varchar(255),

  primary key (id)
);