INSERT INTO stores(name,internet_page, phone_number)
VALUES
('21 vek','21vek.by','+375293333333'),
('ozone','ozon.ru','+375294444444'),
('wildberries','wildberries.ru','+7777777'),
('lamoda','lamoda.ru','+8888888');

GO

INSERT INTO customers(first_name, last_name,address, email)
VALUES
('Ivan', 'Ivanov','Suvorova 1 , 1', 'ivanov@gmail.com'),
('Petr', 'Petrov','Solomovoy 2 , 2', 'petrov@gmail.com'),
('Sidor', 'Sidrov','Kupaly 3 , 3', 'sidorov@gmail.com'),
('Nestor', 'Nesterov', 'Repina 4 , 4', 'sterov@gmail.com'),
('Alina','Alinova','Gaya 5 , 5','alinova@gmail.com');

INSERT INTO categories(name, parent_id)
VALUES
('industrial', null ),
('nutrition', null ),

('technics', 1 ),
('clothes', 1 ),
('toys', 1 ),
('animal_feed', 2 ),
('baby_food', 2 ),
('food', 2 ),
('drinks', 2 ),

('type_of_control', 3 ),
('installation_type', 3 ),
('dimensions', 3 ),

('age_clothes', 4 ),
('season', 4 ),
('class_of_price', 4 ),

('age_toys', 5 ),
('material', 5 ),
('development', 5 ),

('type_of_meat', 6 ),
('type_of_animal', 6 ),
('age_of_animal', 6 ),

('type_of_mix', 7 ),
('type_of_instant', 7 ),
('age_in_month', 7 ),

('age_food', 8 ),
('health_or_not', 8 ),
('frozen_or_not', 8 ),

('type_alcohol', 9 ),
('volume', 9 ),
('made_in', 9 ),

('build_in', 10 ),
('free_standing', 10 ),

('sensor', 11 ),
('button', 11 ),
('small', 12 ),
('big', 12 ),

('children', 13 ),
('adult', 13 ),
('animal', 13 ),

('summer', 14 ),
('winter', 14 ),
('demi', 14 ),

('premium', 15 ),
('low_cost', 15 ),

('children', 16 ),
('animal', 16 ),

('wood', 17 ),
('plastic', 17 ),
('develop', 18 ),
('not_develop', 18 ),

('pig', 19 ),
('chicken', 19 ),

('dog', 20 ),
('cat', 20 ),

('young', 21 ),
('old', 21 ),

('milk', 22 ),
('not_milk', 22 ),

('instant', 23 ),
('not_instant', 23 ),

('before_year', 24 ),
('after_year', 24 ),

('food_child', 25 ),
('food_adult', 25 ),

('sport_food', 26 ),
('not_sport_food', 26 ),

('frozen', 27 ),
('not_frozen', 27 ),

('alcohol', 28 ),
('alcohol_free', 28 ),

('made_in', 29 ),
('made_out', 29 ),
('less_litre', 30 ),
('more_litre', 30 );


GO

INSERT INTO products(name, producer)
VALUES

('telephone', 'lg' ),
('telephone', 'apple' ),
('washer', 'lg'),
('washer', 'bosch' ),
('refrigerator', 'lg'),
('refrigerator', 'bosch' ),
('dishwasher', 'bosch'),
('dishwasher', 'lg'),

('jacket', 'zara'),
('jacket', 'hm'),
('shirt', 'collins'),
('shirt', 'zara'),
('trousers', 'hm'),
('trousers', 'collins'),
('shorts', 'hm'),
('shorts', 'zara'),

('cubes', 'play'),
('cubes', 'playgro'),
('car', 'child'),
('car', 'play'),
('constructor', 'gray'),
('constructor', 'playgro'),
('bone', 'grai'),
('bone', 'child'),

('canned_food', 'animal'),
('canned_food', 'pet'),
('dry_food', 'animal'),
('dry_food', 'pet'),
('bones', 'animal'),
('bones', 'pet'),

('baby_mix', 'baby'),
('baby_mix', 'bany'),
('canned_food', 'volcov'),
('canned_food', 'mmk'),
('puree', 'mmk'),
('puree', 'volcov'),
('cookies', 'volcov'),
('cookies', 'mmk'),

('dumplings', 'bela'),
('dumplings', 'mmk'),
('crispbread', 'bela'),
('crispbread', 'mmk'),
('cheese', 'bela'),
('cheese', 'mmk'),
('hot_dog', 'bela'),
('hot_dog', 'mmk'),

('beer', 'mmk'),
('beer', 'goat'),
('cocktail', 'aliv'),
('cocktail', 'mmk'),
('water', 'mmk'),
('water', 'goat'),
('vodka', 'aliv'),
('vodka', 'mmk');

GO

INSERT INTO product_shops(product_id, price, quantity,  store_id,description)
VALUES

(1, 250, 5, 1, 'special price'),
(1, 300, 5, 2, 'discount item'),
(2, 350, 5, 3, 'goods with gift'),
(2,450 , 5, 4, ''),

(3, 1050, 5,1 , 'regular price'),
(3, 750, 5, 2, 'available in credit'),
(4, 850, 5, 3, '2 for price 1'),
(4, 950, 5, 4, 'warranty from producer'),

(5, 1150, 5, 1, 'special price'),
(5, 1250, 5, 2, 'discount item'),
(6, 1050, 5,3 , 'goods with gift'),
(6,1600 , 5, 4, ''),

(7,1000 , 5,1 , 'regular price'),
(7, 1050, 5, 2, 'available in credit'),
(8, 950, 5,3 , '2 for price 1'),
(8, 960, 5, 4, 'warranty from producer'),

(9, 150, 5, 1, 'special price'),
(9, 250, 5, 2, 'discount item'),
(10, 350, 5,3 , 'goods with gift'),
(10, 450, 5, 4, ''),

(11,50 , 5,1 , 'regular price'),
(11, 60, 5, 2, 'warranty from producer'),
(12, 70, 5,3 , 'available in credit'),
(12,55 , 5, 4, '2 for price 1'),

(13, 150, 5,1 , 'special price'),
(13, 140, 5,2 , 'discount item'),
(14, 130, 5, 3, 'goods with gift'),
(14, 120, 5, 4, ''),

(15,50 , 5, 1, 'regular price'),
(15, 100, 5,2 , 'available in credit'),
(16, 90, 5,3 , '2 for price 1'),
(16, 80, 5,4 , 'warranty from producer'),

(17, 10, 5, 1, 'special price'),
(17,50 , 5,2 , 'discount item'),
(18,20 , 5,3 , 'goods with gift'),
(18, 25, 5,4 , ''),

(19, 250, 5, 1, 'regular price'),
(19,200 , 5,2 , 'available in credit'),
(20,20 , 5,3 , '2 for price 1'),
(20, 150, 5,4 , 'warranty from producer'),

(21, 20, 5, 1, 'special price'),
(21,10 , 5,2 , 'discount item'),
(22,15 , 5,3 , 'goods with gift'),
(22,16 , 5,4 , ''),

(23,1 , 5, 1, 'regular price'),
(23,2 , 5,2 , 'available in credit'),
(24, 3, 5,3 , '2 for price 1'),
(24, 4, 5,4 , 'warranty from producer'),

(25,4 , 5, 1, 'special price'),
(25,3 , 5,2 , 'discount item'),
(26, 2, 5,3 , 'goods with gift'),
(26, 1, 5,4 , ''),

(27,1 , 5, 1, 'regular price'),
(27,2 , 5,2 , 'available in credit'),
(28, 2, 5,3 , '2 for price 1'),
(28, 1, 5,4 , 'warranty from producer'),

(29, 1, 5,1, 'special price'),
(29,2 , 5,2, 'discount item'),
(30, 3, 5,3, 'goods with gift'),
(30,3 , 5,4, ''),

(31, 7, 5,1, 'regular price'),
(31, 6, 5,2, 'available in credit'),
(32,8 , 5,3, '2 for price 1'),
(32, 9, 5,4, 'warranty from producer'),

(33, 3, 5,1, 'special price'),
(33,2 , 5,2, 'discount item'),
(34, 4, 5,3, 'goods with gift'),
(34,5 , 5,4, ''),

(35, 1, 5,1, 'regular price'),
(35, 2, 5,2, '2 for price 1'),
(36, 2, 5,3, 'available in credit'),
(36, 1, 5,4, 'warranty from producer'),

(37, 5, 5,1, 'special price'),
(37, 4, 5,2, 'discount item'),
(38, 3, 5,3, 'goods with gift'),
(38, 2, 5,4, ''),

(39, 1, 5,1, 'regular price'),
(39, 5, 5,2, 'available in credit'),
(40, 4, 5,3, '2 for price 1'),
(40, 5, 5,4, 'warranty from producer'),

(41, 4, 5,1, 'special price'),
(41,1 , 5,2, 'discount item'),
(42, 2, 5,3, 'goods with gift'),
(42, 3, 5,4, ''),

(43, 4, 5,1, 'regular price'),
(43, 5, 5,2, 'available in credit'),
(44, 2, 5,3, '2 for price 1'),
(44, 1, 5,4, 'warranty from producer'),

(45, 1, 5,1, 'special price'),
(45, 2, 5,2, 'discount item'),
(46, 2, 5,3, 'goods with gift'),
(46,2 , 5,4, ''),

(47, 1, 5,1, 'regular price'),
(47, 1, 5,2, '2 for price 1'),
(48, 1, 5,3, 'available in credit'),
(48, 2, 5,4, 'warranty from producer'),

(49, 3, 5,1, 'special price'),
(49, 4, 5,2, 'discount item'),
(50, 1, 5,3, 'goods with gift'),
(50, 2, 5,4, ''),

(51, 10, 5,1, 'regular price'),
(51, 15, 5,2, 'available in credit'),
(52, 11, 5,3, '2 for price 1'),
(52,12 , 5,4, 'warranty from producer'),

(53, 10, 5,1, 'special price'),
(53, 15, 5,2, 'discount item'),
(54, 11, 5,3, 'goods with gift'),
(54, 12, 5,4, ''),

(1, 250, 5, 1, 'special price'),
(1, 300, 5, 2, 'discount item'),
(2, 350, 5, 3, 'goods with gift'),
(2,450 , 5, 4, ''),

(3, 1050, 5,1 , 'regular price'),
(3, 750, 5, 2, 'available in credit'),
(4, 850, 5, 3, '2 for price 1'),
(4, 950, 5, 4, 'warranty from producer'),

(5, 1150, 5, 1, 'special price'),
(5, 1250, 5, 2, 'discount item'),
(6, 1050, 5,3 , 'goods with gift'),
(6,1600 , 5, 4, ''),

(7,1000 , 5,1 , 'regular price'),
(7, 1050, 5, 2, 'available in credit'),
(8, 950, 5,3 , '2 for price 1'),
(8, 960, 5, 4, 'warranty from producer'),

(9, 150, 5, 1, 'special price'),
(9, 250, 5, 2, 'discount item'),
(10, 350, 5,3 , 'goods with gift'),
(10, 450, 5, 4, ''),

(11,50 , 5,1 , 'regular price'),
(11, 60, 5, 2, 'warranty from producer'),
(12, 70, 5,3 , 'available in credit'),
(12,55 , 5, 4, '2 for price 1'),

(13, 150, 5,1 , 'special price'),
(13, 140, 5,2 , 'discount item'),
(14, 130, 5, 3, 'goods with gift'),
(14, 120, 5, 4, ''),

(15,50 , 5, 1, 'regular price'),
(15, 100, 5,2 , 'available in credit'),
(16, 90, 5,3 , '2 for price 1'),
(16, 80, 5,4 , 'warranty from producer'),

(17, 10, 5, 1, 'special price'),
(17,50 , 5,2 , 'discount item'),
(18,20 , 5,3 , 'goods with gift'),
(18, 25, 5,4 , ''),

(19, 250, 5, 1, 'regular price'),
(19,200 , 5,2 , 'available in credit'),
(20,20 , 5,3 , '2 for price 1'),
(20, 150, 5,4 , 'warranty from producer'),

(21, 20, 5, 1, 'special price'),
(21,10 , 5,2 , 'discount item'),
(22,15 , 5,3 , 'goods with gift'),
(22,16 , 5,4 , ''),

(23,1 , 5, 1, 'regular price'),
(23,2 , 5,2 , 'available in credit'),
(24, 3, 5,3 , '2 for price 1'),
(24, 4, 5,4 , 'warranty from producer'),

(25,4 , 5, 1, 'special price'),
(25,3 , 5,2 , 'discount item'),
(26, 2, 5,3 , 'goods with gift'),
(26, 1, 5,4 , ''),

(27,1 , 5, 1, 'regular price'),
(27,2 , 5,2 , 'available in credit'),
(28, 2, 5,3 , '2 for price 1'),
(28, 1, 5,4 , 'warranty from producer'),

(29, 1, 5,1, 'special price'),
(29,2 , 5,2, 'discount item'),
(30, 3, 5,3, 'goods with gift'),
(30,3 , 5,4, ''),

(31, 7, 5,1, 'regular price'),
(31, 6, 5,2, 'available in credit'),
(32,8 , 5,3, '2 for price 1'),
(32, 9, 5,4, 'warranty from producer'),

(33, 3, 5,1, 'special price'),
(33,2 , 5,2, 'discount item'),
(34, 4, 5,3, 'goods with gift'),
(34,5 , 5,4, ''),

(35, 1, 5,1, 'regular price'),
(35, 2, 5,2, '2 for price 1'),
(36, 2, 5,3, 'available in credit'),
(36, 1, 5,4, 'warranty from producer'),

(37, 5, 5,1, 'special price'),
(37, 4, 5,2, 'discount item'),
(38, 3, 5,3, 'goods with gift'),
(38, 2, 5,4, ''),

(39, 1, 5,1, 'regular price'),
(39, 5, 5,2, 'available in credit'),
(40, 4, 5,3, '2 for price 1'),
(40, 5, 5,4, 'warranty from producer'),

(41, 4, 5,1, 'special price'),
(41,1 , 5,2, 'discount item'),
(42, 2, 5,3, 'goods with gift'),
(42, 3, 5,4, ''),

(43, 4, 5,1, 'regular price'),
(43, 5, 5,2, 'available in credit'),
(44, 2, 5,3, '2 for price 1'),
(44, 1, 5,4, 'warranty from producer'),

(45, 1, 5,1, 'special price'),
(45, 2, 5,2, 'discount item'),
(46, 2, 5,3, 'goods with gift'),
(46,2 , 5,4, ''),

(47, 1, 5,1, 'regular price'),
(47, 1, 5,2, '2 for price 1'),
(48, 1, 5,3, 'available in credit'),
(48, 2, 5,4, 'warranty from producer'),

(49, 3, 5,1, 'special price'),
(49, 4, 5,2, 'discount item'),
(50, 1, 5,3, 'goods with gift'),
(50, 2, 5,4, ''),

(51, 10, 5,1, 'regular price'),
(51, 15, 5,2, 'available in credit'),
(52, 11, 5,3, '2 for price 1'),
(52,12 , 5,4, 'warranty from producer'),

(53, 10, 5,1, 'special price'),
(53, 15, 5,2, 'discount item'),
(54, 11, 5,3, 'goods with gift'),
(54, 12, 5,4, ''),


(1, 250, 5, 1, 'special price'),
(1, 300, 5, 2, 'discount item'),
(2, 350, 5, 3, 'goods with gift'),
(2,450 , 5, 4, ''),

(3, 1050, 5,1 , 'regular price'),
(3, 750, 5, 2, 'available in credit'),
(4, 850, 5, 3, '2 for price 1'),
(4, 950, 5, 4, 'warranty from producer'),

(5, 1150, 5, 1, 'special price'),
(5, 1250, 5, 2, 'discount item'),
(6, 1050, 5,3 , 'goods with gift'),
(6,1600 , 5, 4, ''),

(7,1000 , 5,1 , 'regular price'),
(7, 1050, 5, 2, 'available in credit'),
(8, 950, 5,3 , '2 for price 1'),
(8, 960, 5, 4, 'warranty from producer'),

(9, 150, 5, 1, 'special price'),
(9, 250, 5, 2, 'discount item'),
(10, 350, 5,3 , 'goods with gift'),
(10, 450, 5, 4, ''),

(11,50 , 5,1 , 'regular price'),
(11, 60, 5, 2, 'warranty from producer'),
(12, 70, 5,3 , 'available in credit'),
(12,55 , 5, 4, '2 for price 1'),

(13, 150, 5,1 , 'special price'),
(13, 140, 5,2 , 'discount item'),
(14, 130, 5, 3, 'goods with gift'),
(14, 120, 5, 4, ''),

(15,50 , 5, 1, 'regular price'),
(15, 100, 5,2 , 'available in credit'),
(16, 90, 5,3 , '2 for price 1'),
(16, 80, 5,4 , 'warranty from producer'),

(17, 10, 5, 1, 'special price'),
(17,50 , 5,2 , 'discount item'),
(18,20 , 5,3 , 'goods with gift'),
(18, 25, 5,4 , ''),

(19, 250, 5, 1, 'regular price'),
(19,200 , 5,2 , 'available in credit'),
(20,20 , 5,3 , '2 for price 1'),
(20, 150, 5,4 , 'warranty from producer'),

(21, 20, 5, 1, 'special price'),
(21,10 , 5,2 , 'discount item'),
(22,15 , 5,3 , 'goods with gift'),
(22,16 , 5,4 , ''),

(23,1 , 5, 1, 'regular price'),
(23,2 , 5,2 , 'available in credit'),
(24, 3, 5,3 , '2 for price 1'),
(24, 4, 5,4 , 'warranty from producer'),

(25,4 , 5, 1, 'special price'),
(25,3 , 5,2 , 'discount item'),
(26, 2, 5,3 , 'goods with gift'),
(26, 1, 5,4 , ''),

(27,1 , 5, 1, 'regular price'),
(27,2 , 5,2 , 'available in credit'),
(28, 2, 5,3 , '2 for price 1'),
(28, 1, 5,4 , 'warranty from producer'),

(29, 1, 5,1, 'special price'),
(29,2 , 5,2, 'discount item'),
(30, 3, 5,3, 'goods with gift'),
(30,3 , 5,4, ''),

(31, 7, 5,1, 'regular price'),
(31, 6, 5,2, 'available in credit'),
(32,8 , 5,3, '2 for price 1'),
(32, 9, 5,4, 'warranty from producer'),

(33, 3, 5,1, 'special price'),
(33,2 , 5,2, 'discount item'),
(34, 4, 5,3, 'goods with gift'),
(34,5 , 5,4, ''),

(35, 1, 5,1, 'regular price'),
(35, 2, 5,2, '2 for price 1'),
(36, 2, 5,3, 'available in credit'),
(36, 1, 5,4, 'warranty from producer'),

(37, 5, 5,1, 'special price'),
(37, 4, 5,2, 'discount item'),
(38, 3, 5,3, 'goods with gift'),
(38, 2, 5,4, ''),

(39, 1, 5,1, 'regular price'),
(39, 5, 5,2, 'available in credit'),
(40, 4, 5,3, '2 for price 1'),
(40, 5, 5,4, 'warranty from producer'),

(41, 4, 5,1, 'special price'),
(41,1 , 5,2, 'discount item'),
(42, 2, 5,3, 'goods with gift'),
(42, 3, 5,4, ''),

(43, 4, 5,1, 'regular price'),
(43, 5, 5,2, 'available in credit'),
(44, 2, 5,3, '2 for price 1'),
(44, 1, 5,4, 'warranty from producer'),

(45, 1, 5,1, 'special price'),
(45, 2, 5,2, 'discount item'),
(46, 2, 5,3, 'goods with gift'),
(46,2 , 5,4, ''),

(47, 1, 5,1, 'regular price'),
(47, 1, 5,2, '2 for price 1'),
(48, 1, 5,3, 'available in credit'),
(48, 2, 5,4, 'warranty from producer'),

(49, 3, 5,1, 'special price'),
(49, 4, 5,2, 'discount item'),
(50, 1, 5,3, 'goods with gift'),
(50, 2, 5,4, ''),

(51, 10, 5,1, 'regular price'),
(51, 15, 5,2, 'available in credit'),
(52, 11, 5,3, '2 for price 1');

GO

INSERT INTO items(product_shop_id, quantity)
VALUES
( 1, 1),
( 2, 2),
( 3, 3),
( 11, 3),
( 12, 2),
( 13, 1),
( 21, 4),
( 22, 5),
( 23, 1),
( 31, 1),
( 32, 2),
( 33, 3),
( 41, 4),
( 42, 1),
( 43, 2),
( 51, 3),
( 52, 4),
( 53, 5),
( 61, 4),
( 62, 3),
( 63, 2),
( 71, 1),
( 72, 1),
( 73, 2),
( 81, 3),
( 82, 4),
( 83, 3),
( 91, 2),
( 92, 1),
( 93, 5);

GO

INSERT INTO orders(delivery_date, order_date, delivery_term, purchase_price, customer_id, status)
VALUES
('2021-01-05', '2021-01-06',1,10.9, 1, 'DELIVERED'),
('2021-02-05', '2021-02-07',2,11, 2, 'NOT_DELIVERED'),
('2021-03-05', '2021-03-08',3,15, 3, 'DELIVERED');

GO

INSERT INTO orders_items(order_id, item_id)
VALUES
(1,1),
(1,4),
(1,8),
(1,12),
(1,16),
(1,20),
(1,24),
(1,28),
(2,2),
(2,5),
(2,9),
(2,13),
(2,17),
(2,21),
(2,25),
(2,29),
(3,3),
(3,6),
(3,10),
(3,14),
(3,18),
(3,22),
(3,26),
(3,30);

GO

INSERT INTO products_categories(product_id, category_id)
VALUES
(1,33),
(1,35),
(2,34 ),
(2,35),
(3,31),
(3,33),
(3,36),
(4,32),
(4,34),
(4,36),
(5,31),
(5,33),
(5,36),
(6,32),
(6,34),
(6,36),
(7,31),
(7,34),
(7,36),
(8,32),
(8,33),
(8,35),
(9,38),
(9,42),
(9,43),
(10,38),
(10,41),
(10,44),
(11,37),
(11,40),
(11,43),
(12,38),
(12,40),
(12,44),
(13,38),
(13,42),
(13,43),
(14,39),
(14,42),
(14,44),
(15,37),
(15,40),
(15,43),
(16,37),
(16,40),
(16,44),
(17,45),
(17,47),
(17,49),
(18,45),
(18,48),
(18,50),
(19,45),
(19,48),
(19,49),
(20,45),
(20,48),
(20,50),
(21,45),
(21,47),
(21,49),
(22,45),
(22,48),
(22,49),
(23,46),
(23,47),
(23,50),
(24,46),
(24,48),
(24,50),
(25,51),
(25,53),
(25,56),
(26,52),
(26,54),
(26,56),
(27,51),
(27,53),
(27,55),
(28,52),
(28,54),
(28,55),
(29,52),
(29,53),
(29,56),
(30,52),
(30,53),
(30,55),
(31,57),
(31,59),
(31,60),
(32,57),
(32,59),
(32,61),
(33,58),
(33,60),
(33,61),
(34,58),
(34,60),
(34,62),
(35,57),
(35,60),
(35,61),
(36,58),
(36,60),
(36,62),
(37,57),
(37,59),
(37,61),
(38,58),
(38,60),
(38,62),
(39,64),
(39,66),
(39,67),
(40,64),
(40,65),
(40,67),
(41,63),
(41,65),
(41,68),
(42,64),
(42,65),
(42,68),
(43,63),
(43,66),
(43,68),
(44,64),
(44,65),
(44,68),
(45,64),
(45,66),
(45,67),
(46,64),
(46,66),
(46,68),
(47,69),
(47,70),
(47,74),
(48,69),
(48,72),
(48,73),
(49,69),
(49,71),
(49,74),
(50,70),
(50,72),
(50,73),
(51,70),
(51,71),
(51,74),
(52,70),
(52,72),
(52,73),
(53,69),
(53,71),
(53,74),
(54,69),
(54,72),
(54,73);


