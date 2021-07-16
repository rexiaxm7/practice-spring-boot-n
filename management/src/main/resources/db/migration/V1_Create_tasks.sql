CREATE TABLE task_management (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    status int NOT NULL,
    deadline date NOT NULL
);