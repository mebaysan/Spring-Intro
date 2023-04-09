create sequence employee_seq start with 1 increment by 50;
create table employee (id integer not null, age integer, name varchar(255), primary key (id));
