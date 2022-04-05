CREATE TABLE product (
    uniq_id VARCHAR(100) NOT NULL UNIQUE,
    sku VARCHAR(100),
    name_title VARCHAR(255),
    description VARCHAR(255),
    list_price VARCHAR(40),
    sale_price VARCHAR(40),
    category VARCHAR(50),
    category_tree VARCHAR(255),
    average_product_price VARCHAR(30),
    product_url VARCHAR(100)
)