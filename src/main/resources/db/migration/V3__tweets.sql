CREATE TABLE tweet (
    id BIGINT AUTO_INCREMENT,
    id_str VARCHAR(255) NOT NULL,
    text VARCHAR(255) NOT NULL,
    created_at DATE NOT NULL,
    product_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (id_str, product_id)
)
