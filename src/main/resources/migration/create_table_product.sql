CREATE TABLE IF NOT EXISTS "product"(
     id SERIAL PRIMARY KEY,
     productName VARCHAR(50) NOT NULL,
     productPrice INT REFERENCES "productPrice"(id)
);