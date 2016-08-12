CREATE TABLE video (
    id BIGINT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    youtube_id VARCHAR(255) NOT NULL,
    product_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (youtube_id, product_id)
)
