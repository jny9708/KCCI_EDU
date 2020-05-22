DROP TABLE employee;
DROP TABLE department;

CREATE TABLE department
    ( id    NUMBER(4) PRIMARY KEY
    , dept_name  VARCHAR2(30)
    );

CREATE TABLE employee
    ( id    NUMBER(6) PRIMARY KEY
    , name      VARCHAR2(25) NOT NULL
    , hire_date      DATE
    , phone_no     VARCHAR2(20)	
    , email     VARCHAR2(50)
    , dept_id  NUMBER(4)
    ,CONSTRAINT     member_departmentid_fk
                     FOREIGN KEY (dept_id)
                      REFERENCES department);


INSERT INTO department VALUES (10,'총무부');
INSERT INTO department VALUES (20,'인사부');
INSERT INTO department VALUES (30,'영업부');
INSERT INTO department VALUES (40,'감사팀');
INSERT INTO department VALUES (50,'전산팀');

INSERT INTO employee VALUES(100,'배기수', TO_DATE('1987-05-04', 'yyyy-mm-dd'),'123-1234', 'go100c@gmail.com', 40);