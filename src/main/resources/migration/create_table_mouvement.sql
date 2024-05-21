CREATE TABLE IF NOT EXISTS "mouvement"(
     id SERIAL PRIMARY KEY,
     dateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     type VARCHAR(100) CHECK(type IN ('Supply', 'Sales')),
     quantity DOUBLE PRECISION,
     product INT REFERENCES "product"(id),
     gasStation INT REFERENCES "gasStation"(id)
);