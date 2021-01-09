-- # Step 1 - USERS table

DROP TABLE IF EXISTS priority.USERS ;
CREATE TABLE IF NOT EXISTS priority.USERS (
	ID SERIAL PRIMARY KEY,
	USER_NAME varchar(255) not null unique,
	IS_ADMIN BOOLEAN DEFAULT FALSE

);

-- # Step 2 - Commit Transaction
COMMIT;

-- ********** End of setup **********