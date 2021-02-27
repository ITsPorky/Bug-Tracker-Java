-- GRANT SELECT ON TABLE * TO public;

-- ALTER DATABASE "Bug-Tracker" SET search_path='public';

CREATE TABLE IF NOT EXISTS employees (
    emp_ID INTEGER NOT NULL PRIMARY KEY,
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
    bug_ID INTEGER NOT NULL PRIMARY KEY,
    bug_name VARCHAR(50) UNIQUE NOT NULL,
    bug_type VARCHAR(50) NOT NULL,
    bug_priority VARCHAR(50) NOT NULL,
    bug_status VARCHAR(50) NOT NULL
);

CREATE TABLE If NOT EXISTS projects (
    project_ID INTEGER NOT NULL PRIMARY KEY,
    project_name VARCHAR(50) UNIQUE NOT NULL,
    project_start VARCHAR(50) NOT NULL,
    project_duration VARCHAR(50) NOT NULL,
    project_priority VARCHAR(50) NOT NULL
);

-- DROP TABLE projects;

-- UPDATE projects COLUMN project_id INTEGER NOT NULL PRIMARY KEY;
-- UPDATE bugs COLUMN bug_id INTEGER NOT NULL PRIMARY KEY;
-- UPDATE employees COLUMN employee_id INTEGER NOT NULL PRIMARY KEY;

-- INSERT INTO projects(project_id, project_name, project_start, project_duration, project_priority)
-- VALUES(1,"Project1","10/02/2021","100","HIGH")

-- ALTER TABLE projects ADD COLUMN project_priority VARCHAR(50) NOT NULL;

-- SELECT * FROM employees;

-- SELECT * FROM bugs;

-- SELECT * FROM projects;