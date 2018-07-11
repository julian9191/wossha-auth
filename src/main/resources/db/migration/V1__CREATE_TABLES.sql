CREATE TABLE TWSS_USERS(
    USERNAME VARCHAR2(250 BYTE) NOT NULL,
    PASSWORD VARCHAR2(250 BYTE) NOT NULL,
    FIRST_NAME VARCHAR2(250 BYTE) NOT NULL,
    LAST_NAME VARCHAR2(250 BYTE) NOT NULL,
    EMAIL VARCHAR2(250 BYTE) NOT NULL,
    GENDER VARCHAR2(6 BYTE) NOT NULL,
    ENABLED NUMBER(1) DEFAULT (1) NOT NULL,
    BIRTHDAY TIMESTAMP(6) NOT NULL,
    CREATED TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    MODIFIED TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT TWSS_USERS_PK PRIMARY KEY (USERNAME) ENABLE
);
 
---------------------------------------------------------------------

CREATE TABLE TWSS_ROLES(
    NAME VARCHAR2(250 BYTE) NOT NULL,
    DESCRIPTION VARCHAR2(250 BYTE) NOT NULL,
    CONSTRAINT TWSS_ROLES_PK PRIMARY KEY (NAME) ENABLE
);
 
---------------------------------------------------------------------

CREATE TABLE TWSS_USERS_X_ROLES(
    ID NUMBER NOT NULL,
    USERNAME VARCHAR2(250 BYTE) NOT NULL,
    ROLE_NAME VARCHAR2(250 BYTE) NOT NULL,
    CONSTRAINT TWSS_U_X_R_PK PRIMARY KEY (ID) ENABLE,
	CONSTRAINT FK_USERS
    	FOREIGN KEY (USERNAME)
    	REFERENCES TWSS_USERS(USERNAME),
	CONSTRAINT FK_ROLES
    	FOREIGN KEY (ROLE_NAME)
    	REFERENCES TWSS_ROLES(NAME)
);
 
CREATE SEQUENCE TWSS_USER_ROLE_SEQ;
 
CREATE TRIGGER TWSS_USER_X_ROLE_TRG
BEFORE INSERT ON TWSS_USERS_X_ROLES
FOR EACH ROW
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT TWSS_USER_ROLE_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/