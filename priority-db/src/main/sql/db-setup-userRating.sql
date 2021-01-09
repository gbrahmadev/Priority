-- # Step 1 - USERS table

DROP TABLE IF EXISTS priority.USERS_RATING ;
CREATE TABLE IF NOT EXISTS priority.USERS_RATING (
    user_id BIGINT NOT NULL,
    priority_id BIGINT NOT NULL,
    rating int NOT NULL,

    INDEX (user_id),
    INDEX (priority_id),

    FOREIGN KEY (user_id)
        REFERENCES USERS(ID),

    FOREIGN KEY (priority_id)
        REFERENCES customer(id)
);

-- # Step 2 - Commit Transaction
COMMIT;

-- ********** End of setup **********