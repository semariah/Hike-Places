SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS hikes (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    hikeLength INTEGER,
    state VARCHAR,

);

CREATE TABLE IF NOT EXISTS visitors (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
);
