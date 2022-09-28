DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES ('Bob'), ('Jack'), ('John');


DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price integer);
INSERT INTO products (title, price) VALUES('Demon Souls', 10), ('Dark Souls', 80), ('Dark Souls2', 80);

DROP TABLE IF EXISTS products_buyers CASCADE;
CREATE TABLE products_buyers (product_id bigint, customer_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO products_buyers (product_id, customer_id) VALUES (1, 1), (1, 1);