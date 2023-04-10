CREATE TABLE PRICES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    PRODUCT_ID INT NOT NULL,
    BRAND_ID INT NOT NULL,
    PRICE_LIST INT NOT NULL,
    START_DATE TIMESTAMP NOT NULL,
    END_DATE TIMESTAMP NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE DECIMAL(8,2) NOT NULL,
    CURRENCY VARCHAR(3) NOT NULL
);
