CREATE TABLE IF NOT EXISTS "productPrice"(
    id SERIAL PRIMARY KEY,
    unitPrice DOUBLE PRECISION,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);