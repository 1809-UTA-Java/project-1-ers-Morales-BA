DROP USER P1 CASCADE;

CREATE USER P1
IDENTIFIED BY P1
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect, resource, create session, create table, create view to P1;