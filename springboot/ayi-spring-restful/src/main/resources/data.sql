
-- CLIENT
INSERT INTO `spring_final_ayidb`.`client` (`id_client`, `document_number`, `lastname`, `name`)
SELECT 1, '30123456', 'Binaghi','Gimena'
WHERE NOT EXISTS (SELECT * FROM `client` WHERE id_client = 1);
INSERT INTO `spring_final_ayidb`.`client` (`id_client`, `document_number`, `lastname`, `name`)
SELECT 2, '30123455', 'Martinez','Juana'
WHERE NOT EXISTS (SELECT * FROM `client` WHERE id_client = 2);
INSERT INTO `spring_final_ayidb`.`client` (`id_client`, `document_number`, `lastname`, `name`)
SELECT 3, '32123055', 'Rabez','Dario'
WHERE NOT EXISTS (SELECT * FROM `client` WHERE id_client = 3);
INSERT INTO `spring_final_ayidb`.`client` (`id_client`, `document_number`, `lastname`, `name`)
SELECT 4, '45103455', 'Broggi','Pablo'
WHERE NOT EXISTS (SELECT * FROM `client` WHERE id_client = 4);
INSERT INTO `spring_final_ayidb`.`client` (`id_client`, `document_number`, `lastname`, `name`)
SELECT 5, '27123455', 'Rodriguez','Ana'
WHERE NOT EXISTS (SELECT * FROM `client` WHERE id_client = 5);

-- CLIENT DETAIL
INSERT INTO `spring_final_ayidb`.`client_detail` (`id_client_detail`, `acumulated_points`, `prime`, `id_client`)
SELECT 1, 10, true, 1
WHERE NOT EXISTS (SELECT * FROM `client_detail` WHERE id_client_detail = 1);
INSERT INTO `spring_final_ayidb`.`client_detail` (`id_client_detail`, `acumulated_points`, `prime`, `id_client`)
SELECT 2, 20, true, 2
WHERE NOT EXISTS (SELECT * FROM `client_detail` WHERE id_client_detail = 2);
INSERT INTO `spring_final_ayidb`.`client_detail` (`id_client_detail`, `acumulated_points`, `prime`, `id_client`)
SELECT 3, 0, false, 3
WHERE NOT EXISTS (SELECT * FROM `client_detail` WHERE id_client_detail = 3);
INSERT INTO `spring_final_ayidb`.`client_detail` (`id_client_detail`, `acumulated_points`, `prime`, `id_client`)
SELECT 4, 0, false, 4
WHERE NOT EXISTS (SELECT * FROM `client_detail` WHERE id_client_detail = 4);
INSERT INTO `spring_final_ayidb`.`client_detail` (`id_client_detail`, `acumulated_points`, `prime`, `id_client`)
SELECT 5, 15, true, 5
WHERE NOT EXISTS (SELECT * FROM `client_detail` WHERE id_client_detail = 5);

-- ADDRESS
INSERT INTO `spring_final_ayidb`.`address` (`id_address`, `city`, `country`, `district`, `floor`, `postal_code`, `street`, `street_number`, `client_id`)
SELECT 1, 'Rosario', 'Argentina', 'Santa Fe', 3, 5561, 'Belgrano', '12', 1
WHERE NOT EXISTS (SELECT * FROM `address` WHERE id_address = 1);
INSERT INTO `spring_final_ayidb`.`address` (`id_address`, `city`, `country`, `district`, `floor`, `postal_code`, `street`, `street_number`, `client_id`)
SELECT 2, 'Las Toscas', 'Argentina', 'Santa Fe', 0, 3586, 'San Martin', '125', 2
WHERE NOT EXISTS (SELECT * FROM `address` WHERE id_address = 2);
INSERT INTO `spring_final_ayidb`.`address` (`id_address`, `city`, `country`, `district`, `floor`, `postal_code`, `street`, `street_number`, `client_id`)
SELECT 3, 'Resistencia', 'Argentina', 'Chaco', 1, 3206, '9 de Julio', '1208', 3
WHERE NOT EXISTS (SELECT * FROM `address` WHERE id_address = 3);
INSERT INTO `spring_final_ayidb`.`address` (`id_address`, `city`, `country`, `district`, `floor`, `postal_code`, `street`, `street_number`, `client_id`)
SELECT 4, 'Corrientes', 'Argentina', 'Corrientes', 0, 1253, '25 de Mayo', '2500', 4
WHERE NOT EXISTS (SELECT * FROM `address` WHERE id_address = 4);
INSERT INTO `spring_final_ayidb`.`address` (`id_address`, `city`, `country`, `district`, `floor`, `postal_code`, `street`, `street_number`, `client_id`)
SELECT 5, 'Villa Ocampo', 'Argentina', 'Santa Fe', 1, 899, '25 de Mayo', '3587', 5
WHERE NOT EXISTS (SELECT * FROM `address` WHERE id_address = 5);

-- INVOICE
INSERT INTO `spring_final_ayidb`.`invoice` (`id_invoice`, `description`, `total`, `client_id`)
SELECT 1, 'TV Smart Samsung',10.0, 1
WHERE NOT EXISTS (SELECT * FROM `invoice` WHERE id_invoice = 1);
INSERT INTO `spring_final_ayidb`.`invoice` (`id_invoice`, `description`, `total`, `client_id`)
SELECT 2, 'Heladera Electrolux',2.0, 2
WHERE NOT EXISTS (SELECT * FROM `invoice` WHERE id_invoice = 2);
INSERT INTO `spring_final_ayidb`.`invoice` (`id_invoice`, `description`, `total`, `client_id`)
SELECT 3, 'Lavarropa Philips',5.0, 3
WHERE NOT EXISTS (SELECT * FROM `invoice` WHERE id_invoice = 3);
INSERT INTO `spring_final_ayidb`.`invoice` (`id_invoice`, `description`, `total`, `client_id`)
SELECT 4, 'Pava eléctrica Juliana',17.0, 4
WHERE NOT EXISTS (SELECT * FROM `invoice` WHERE id_invoice = 4);
INSERT INTO `spring_final_ayidb`.`invoice` (`id_invoice`, `description`, `total`, `client_id`)
SELECT 5, 'Secarropa Kohinoor',12.0, 5
WHERE NOT EXISTS (SELECT * FROM `invoice` WHERE id_invoice = 5);
