CREATE TABLE "products"
(
    "id"    SERIAL PRIMARY KEY,
    "name"  VARCHAR(50)   NOT NULL,
    "price" DECIMAL(6, 2) NOT NULL
);