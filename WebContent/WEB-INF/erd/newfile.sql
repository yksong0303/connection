
/* Drop Triggers */

DROP TRIGGER TRI_User_info_ui_num;



/* Drop Tables */

DROP TABLE User_info CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_User_info_ui_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_User_info_ui_num INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE User_info
(
	ui_num number(5,0) NOT NULL,
	ui_name varchar2(100) NOT NULL,
	ui_age number(3,0) NOT NULL,
	PRIMARY KEY (ui_num)
);



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_User_info_ui_num BEFORE INSERT ON User_info
FOR EACH ROW
BEGIN
	SELECT SEQ_User_info_ui_num.nextval
	INTO :new.ui_num
	FROM dual;
END;

/




