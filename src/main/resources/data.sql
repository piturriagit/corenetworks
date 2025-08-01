INSERT INTO tasks (title, description, creation_date) VALUES
  ('Task1', 'Description1', NOW())      --today
 ,('Task2', 'Description2', NOW()+1)    --tomorrow
 ,('Task3', 'Description3', NOW()-1)    --yesterday
 ,('TaskEmpty', null, NOW())             --null values
 ,('TaskLong with very long title',
 'Description3 with very long description as you need to perform all of the expected actions',
 NOW()+3650)    --long values: long strings, in 10 years
 ,('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor i',
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor i', NOW())

 ;

--CREATE TABLE `tasksdb`.`users` (
--  `id` INT NOT NULL AUTO_INCREMENT,
--  `username` VARCHAR(45) NOT NULL,
--  `password` VARCHAR(45) NULL,
--  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
--  PRIMARY KEY (`id`));

  INSERT INTO users (username, password) VALUES
     ('admin' , '$2a$12$TiyjrVY6gZHKr7dUvgRF2u4Xdtm0hQiFmv5l/2OVJlmHNDLRxR3Fe') --a@123
    ,('user'  , '$2a$12$EQBZh8dzPqTvS2EvlEmYD.wmIJZCTEvAvunKmuT30OZWdGBXGE14K') --u@123
    ,('ana'   , '$2a$12$2iNWo1B7pgrJdIb7x.RT6Oz.6ot9PO7s49OFbkZrevBEJIX6l7pEu') --a@123
    ,('bea'   , '$2a$12$J.4eZljF6XHtsD.ZHmH/p.ftBhV/ZeKJW3.LmnvltLdR4v39P9Ui2') --b@123
    ,('carlos', '$2a$12$eXIEjFm9ixXYMJJmoOWusO1ck8Fao3cERNOdgqd31.Y0i4CXhzEZi') --c@123
    ,('test'  , '$2a$12$syzYVNnw8RybZLPHras5mupGLnPrqUqep7hKCOoPqsIGZkRsSD4bi') --test
    ;

SHOW TABLES;