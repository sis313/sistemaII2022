-- Table: city
INSERT INTO city (name) VALUES ("La Paz");
INSERT INTO city (name) VALUES ("Oruro");
INSERT INTO city (name) VALUES ("Potosi");
INSERT INTO city (name) VALUES ("Cochabamba");
INSERT INTO city (name) VALUES ("Chuquisaca");
INSERT INTO city (name) VALUES ("Tarija");
INSERT INTO city (name) VALUES ("Pando");
INSERT INTO city (name) VALUES ("Beni");
INSERT INTO city (name) VALUES ("Santa Cruz");

-- Table: municipalities
INSERT INTO municipalities (name, id_city) VALUES ("Municipio La Paz", 1);
INSERT INTO municipalities (name, id_city) VALUES ("Municipio Oruro", 2);
INSERT INTO municipalities (name, id_city) VALUES ("Municipio Potosi", 3);
INSERT INTO municipalities (name, id_city) VALUES ("Municipio Cochabamba", 4);
INSERT INTO municipalities (name, id_city) VALUES ("Municipio Chuquisaca", 5);
INSERT INTO municipalities (name, id_city) VALUES ("Municipio Tarija", 6);
INSERT INTO municipalities (name, id_city) VALUES ("Municipio Pando", 7);
INSERT INTO municipalities (name, id_city) VALUES ("Municipio Beni", 8);
INSERT INTO municipalities (name, id_city) VALUES ("Municipio Santa Cruz", 9);

-- Table: zone
INSERT INTO zone (name, id_municipalities) VALUES ("Zona La Paz", 1);
INSERT INTO zone (name, id_municipalities) VALUES ("Zona Oruro", 2);
INSERT INTO zone (name, id_municipalities) VALUES ("Zona Potosi", 3);
INSERT INTO zone (name, id_municipalities) VALUES ("Zona Cochabamba", 4);
INSERT INTO zone (name, id_municipalities) VALUES ("Zona Chuquisaca", 5);
INSERT INTO zone (name, id_municipalities) VALUES ("Zona Tarija", 6);
INSERT INTO zone (name, id_municipalities) VALUES ("Zona Pando", 7);
INSERT INTO zone (name, id_municipalities) VALUES ("Zona Beni", 8);
INSERT INTO zone (name, id_municipalities) VALUES ("Zona Santa Cruz", 9);

-- Table: type_user
INSERT INTO type_user (name) VALUES ("Servicio");

-- Table: user
INSERT INTO user (name, email, nickname, password, id_type_user, create_date, update_date, status) VALUES ("Carlos", "Carlos@email.com", "CarlosNickname", "carlospassword", 1, "2022-01-01", "2022-01-01", 1);
INSERT INTO user (name, email, nickname, password, id_type_user, create_date, update_date, status) VALUES ("Mauro", "Mauro@email.com", "MauroNickname", "mauropassword", 1, "2022-01-01", "2022-01-01", 1);
INSERT INTO user (name, email, nickname, password, id_type_user, create_date, update_date, status) VALUES ("Jhoan", "Jhoan@email.com", "JhoanNickname", "jhoanpassword", 1, "2022-01-01", "2022-01-01", 1);

-- Table: type_business
INSERT INTO type_business (name) VALUES ("Ferreteria");
INSERT INTO type_business (name) VALUES ("Farmacia");
INSERT INTO type_business (name) VALUES ("Restaurante");

-- Table: business
INSERT INTO business (name, description, id_type_business, id_user, create_date, update_date, status) VALUES ("Ferreteria Carlos", "Venta de articulos de ferreteria", 1, 1, "2022-01-01", "2022-01-01", 1);
INSERT INTO business (name, description, id_type_business, id_user, create_date, update_date, status) VALUES ("Farmacia Mauro", "Venta de articulos de farmacia", 2, 2, "2022-01-01", "2022-01-01", 1);
INSERT INTO business (name, description, id_type_business, id_user, create_date, update_date, status) VALUES ("Restaurante Jhoan", "Venta de articulos de restaurante", 3, 3, "2022-01-01", "2022-01-01", 1);

-- Table: location
INSERT INTO location (latitude, longitude) VALUES (-16.523213, -68.112195);
INSERT INTO location (latitude, longitude) VALUES (-17.971374, -67.099815);
INSERT INTO location (latitude, longitude) VALUES (-19.575825, -65.752777);
INSERT INTO location (latitude, longitude) VALUES (-17.371433, -66.143968);
INSERT INTO location (latitude, longitude) VALUES (-19.033954, -65.266659);
INSERT INTO location (latitude, longitude) VALUES (-21.533436, -64.732056);
INSERT INTO location (latitude, longitude) VALUES (-11.039146, -68.784033);
INSERT INTO location (latitude, longitude) VALUES (-14.830150, -64.909743);
INSERT INTO location (latitude, longitude) VALUES (-17.695537, -63.151217);

-- Table: branch
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. La Paz Carlos 1", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 1, 1, 1, "2022-01-01", "2022-01-01", 1);
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. Oruro Carlos 2", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 2, 2, 1, "2022-01-01", "2022-01-01", 1);
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. Potosi Carlos 3", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 3, 3, 1, "2022-01-01", "2022-01-01", 1);
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. Cochabamba Mauro 1", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 4, 4, 2, "2022-01-01", "2022-01-01", 1);
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. Chuquisaca Mauro 2", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 5, 5, 2, "2022-01-01", "2022-01-01", 1);
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. Tarija Mauro 3", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 6, 6, 2, "2022-01-01", "2022-01-01", 1);
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. Pando Jhoan 1", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 7, 7, 3, "2022-01-01", "2022-01-01", 1);
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. Beni Jhoan 2", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 8, 8, 3, "2022-01-01", "2022-01-01", 1);
INSERT INTO branch (address, open_hour, close_hour, attention_days, image, id_zone, id_location, id_business, create_date, update_date, status) VALUES ("Av. Santa Cruz Jhoan 3", "08:00:00", "18:00:00", "Lunes", "aW1hZ2UgZmlsZQ==", 9, 9, 3, "2022-01-01", "2022-01-01", 1);

-- Table: comment
INSERT INTO comment (message, id_user, id_business, status) VALUES ("Ferreteria bueno", 1, 1, 1);
INSERT INTO comment (message, id_user, id_business, status) VALUES ("Farmacia bueno", 2, 2, 1);
INSERT INTO comment (message, id_user, id_business, status) VALUES ("Restaurante bueno", 3, 3, 1);

-- Table: rating
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 1, 1);
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 2, 1);
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 3, 1);
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 4, 2);
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 5, 2);
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 6, 2);
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 7, 3);
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 8, 3);
INSERT INTO rating (score, favorite_status, id_branch, id_user) VALUES (5, 1, 9, 3);



