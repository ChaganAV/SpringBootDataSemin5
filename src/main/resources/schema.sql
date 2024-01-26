CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description varchar(2000) NOT NULL,
    status varchar(80) NOT NULL,
    date_begin date NOT NULL
);