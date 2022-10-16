-- INSERT USERS
INSERT INTO `biblioteca`.`users`(`id`, `address`, `dni`, `last_name`, `name`, `phone`)
SELECT 1,'San Martin 144','34888999','Martinez','Juana','3482141215'
WHERE NOT EXISTS (SELECT * FROM `users` WHERE id = 1);
INSERT INTO `biblioteca`.`users`(`id`, `address`, `dni`, `last_name`, `name`, `phone`)
SELECT 2,'9 de Julio 1099','45102336','Ramirez','Adrian','3482102030'
WHERE NOT EXISTS (SELECT * FROM `users` WHERE id = 2);

-- INSERT BOOKS
INSERT INTO `biblioteca`.`books`(`id`, `author`, `category`, `edition`, `idiom`, `stock`, `title`)
SELECT 1,'Garcia Marquez','Novela','2019','Español',5,'El amor en los tiempos del cólera'
WHERE NOT EXISTS (SELECT * FROM `books` WHERE id = 1);
INSERT INTO `biblioteca`.`books`(`id`, `author`, `category`, `edition`, `idiom`, `stock`, `title`)
SELECT 2,'Garcia Marquez','Novela','2001','Español',2,'Cien años de soledad'
WHERE NOT EXISTS (SELECT * FROM `books` WHERE id = 2);

-- INSERT LENDINGS
INSERT INTO `biblioteca`.`lendings`(`id`, `date_out`, `date_return`, `book_id`, `user_id`)
SELECT 1,'05-10-2022','16-10-2022',1,1
WHERE NOT EXISTS (SELECT * FROM `lendings` WHERE id = 1);
INSERT INTO `biblioteca`.`lendings`(`id`, `date_out`, `date_return`, `book_id`, `user_id`)
SELECT 2,'07-10-2022','17-10-2022',2,2
WHERE NOT EXISTS (SELECT * FROM `lendings` WHERE id = 2);
INSERT INTO `biblioteca`.`lendings`(`id`, `date_out`, `date_return`, `book_id`, `user_id`)
SELECT 3,'11-10-2022','15-10-2022',1,2
WHERE NOT EXISTS (SELECT * FROM `lendings` WHERE id = 3);
