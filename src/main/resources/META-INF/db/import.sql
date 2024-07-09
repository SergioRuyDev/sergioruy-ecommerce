
insert into `product` (id, name, price, description) values (1, 'Kindle', 499.0, 'Discover the new Kindle, now with adjustable built-in lighting, which allows you to read indoors or outdoors, at any time of the day.');
insert into `product` (id, name, price, description) values (3, 'Camera GoPro Hero 14', 1400.0, 'Be a hero with your videos.');

insert into `customer` (id, name) values (1, 'Sergio Ruy');
insert into `customer` (id, name) values (2, 'Julia Coutinho');

insert into `ordered` (id, customer_id, date_ordered, amount, status) values (1, 1, sysdate(), 100.0, 'WAITING');

insert into `item_ordered` (id, ordered_id, product_id, product_price, quantity) values (1, 1, 1, 5.0, 2);
