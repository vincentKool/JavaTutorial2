CREATE TABLE product (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product_list (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product_list_products (
    lists_id BIGINT NOT NULL,
    products_id BIGINT NOT NULL,
    UNIQUE KEY (lists_id, products_id)
);
