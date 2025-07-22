INSERT INTO tasks (title, description, creation_date) VALUES
  ('Task1', 'Description1', NOW())      --today
 ,('Task2', 'Description2', NOW()+1)    --tomorrow
 ,('Task3', 'Description3', NOW()-1)    --yesterday
 ,('TaskEmpty', null, null)             --null values
 ,('TaskLong with very long title',
 'Description3 with very long description as you need to perform all of the expected actions',
 NOW()+3650)    --long values: long strings, in 10 years
 ;
SHOW TABLES;