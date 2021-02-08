-- GRANT SELECT ON TABLE * TO public;

-- ALTER DATABASE "Bug-Tracker" SET search_path='public';

CREATE TABLE IF NOT EXISTS employees (
    emp_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START 1 INCREMENT 1 ) PRIMARY KEY,
    emp_fname VARCHAR(50) NOT NULL,
    emp_lname VARCHAR(50) NOT NULL,
    emp_email VARCHAR(50) NOT NULL,
    emp_phone VARCHAR(50) NOT NULL,
    emp_state VARCHAR(50) NOT NULL,
    emp_city VARCHAR(50) NOT NULL,
    emp_postcode VARCHAR(50) NOT NULL,
    emp_role VARCHAR(50) NOT NULL
);

CREATE TABLE If NOT EXISTS bugs (
    bug_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START 1 INCREMENT 1 ) PRIMARY KEY,
    bug_name VARCHAR(50) UNIQUE NOT NULL,
    bug_type VARCHAR(50) NOT NULL,
    bug_priority VARCHAR(50) NOT NULL,
    bug_status VARCHAR(50) NOT NULL
);

SELECT * FROM employees;

SELECT * FROM bugs;