-- # Step 1 - Drop the existing schema and reassign permissions

DROP SCHEMA IF EXISTS priority ;
CREATE SCHEMA priority AUTHORIZATION root;
GRANT ALL PRIVILEGES ON SCHEMA priority TO root;
COMMIT;

-- ********** End of setup **********
