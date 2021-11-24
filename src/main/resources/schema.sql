CREATE TABLE if not exists `student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) NOT NULL UNIQUE ,
  `user_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL UNIQUE ,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `session` varchar(255) NOT NULL,
  `blood_group` varchar(255) NOT NULL,

  primary key (id)
);