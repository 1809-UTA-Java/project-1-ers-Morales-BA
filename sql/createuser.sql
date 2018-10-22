CREATE USER P1 IDENTIFIED BY proj DEFAULT TABLESPACE users TEMPORARY TABLESPACE temp QUOTA 10M ON users;
GRANT connect, resource, create session, create table, create view to P1;