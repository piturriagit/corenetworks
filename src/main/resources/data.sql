INSERT INTO tasks (title, description, creation_date) VALUES
  ('Task1', 'Description1', NOW())      --today
 ,('Task2', 'Description2', NOW()+1)    --tomorrow
 ,('Task3', 'Description3', NOW()-1)    --yesterday
 ,('TaskEmpty', null, null)             --null values
 ,('TaskLong with very long title',
 'Description3 with very long description as you need to perform all of the expected actions',
 NOW()+3650)    --long values: long strings, in 10 years
 ;

--CREATE TABLE `tasksdb`.`users` (
--  `id` INT NOT NULL AUTO_INCREMENT,
--  `username` VARCHAR(45) NOT NULL,
--  `password` VARCHAR(45) NULL,
--  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
--  PRIMARY KEY (`id`));

 INSERT INTO users (username, password) VALUES
   ('admin', 'a@123')
  ,('user', 'u@123')
  ;

SHOW TABLES;