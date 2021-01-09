-- # Step 1 - USERS table

DROP TABLE IF EXISTS priority.PRIORITY_AREAS;
CREATE TABLE IF NOT EXISTS priority.PRIORITY_AREAS (
	ID SERIAL PRIMARY KEY,
	PRIORITY_NAME VARCHAR(255) not null unique
);

-- # Step 2 - Add Priorites
INSERT INTO priority.PRIORITY_AREAS VALUES(1,'Connection');
INSERT INTO priority.PRIORITY_AREAS VALUES(2,'Relationships');
INSERT INTO priority.PRIORITY_AREAS VALUES(3,'Career');
INSERT INTO priority.PRIORITY_AREAS VALUES(4,'Wealth');


-- # Step 3 - Commit Transaction
COMMIT;

-- ********** End of setup **********