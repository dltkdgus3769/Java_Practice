CREATE SEQUENCE id_seq
START WITH 1
INCREMENT BY 1;

CREATE TABLE employee (
id NUMBER PRIMARY KEY,
name VARCHAR(100),
department VARCHAR(100),
birthdate VARCHAR(100),
address VARCHAR(100),
telNum VARCHAR(30),
sex VARCHAR(10)
);
insert into employee (id,name,department,birthdate,address,telNum,sex) values(id_seq,'lsh','연구소',
'1995-07-08','Busan','010-1234-4567','Male');


select * from employee;

commit;