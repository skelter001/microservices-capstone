CREATE TABLE IF NOT EXISTS product (
    uniq_id VARCHAR(100) NOT NULL UNIQUE,
    sku VARCHAR(100),
    name_title TEXT,
    description TEXT,
    list_price VARCHAR(20),
    sale_price VARCHAR(20),
    category TEXT,
    category_tree TEXT,
    average_product_rating VARCHAR(30),
    product_url TEXT,
    brand VARCHAR(100)
)