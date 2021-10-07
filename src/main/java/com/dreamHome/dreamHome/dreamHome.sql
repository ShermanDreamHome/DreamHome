CREATE DATABASE IF NOT EXISTS dream_home_db;

CREATE USER shy_admin@localhost IDENTIFIED BY 'pass0324';

GRANT ALL ON dream_home_db.* TO shy_admin@localhost;

DROP DATABASE dream_home_db;