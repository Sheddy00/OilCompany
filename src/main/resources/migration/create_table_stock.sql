CREATE TABLE IF NOT EXISTS "stock"(
     id SERIAL PRIMARY KEY,
     evaporationRate DOUBLE PRECISION,
     dateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     quantity DOUBLE PRECISION,
     product INT REFERENCES "product"(id),
     gasStation INT REFERENCES "gasStation"(id)
);