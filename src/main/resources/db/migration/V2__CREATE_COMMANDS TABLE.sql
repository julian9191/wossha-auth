CREATE TABLE TWSS_COMMANDS(
    NAME VARCHAR2(250 BYTE) NOT NULL,
    DESCRIPTION VARCHAR2(250 BYTE) NOT NULL,
    CONSTRAINT TWSS_COMMANDS_PK PRIMARY KEY (NAME) ENABLE
);

---------------------------------------------------------------------

CREATE TABLE TWSS_ROLES_X_COMMANDS(
    ID NUMBER NOT NULL,
    ROL_NAME VARCHAR2(250 BYTE) NOT NULL,
    CMD_NAME VARCHAR2(250 BYTE) NOT NULL,
	CONSTRAINT FK_RXC_ROLES
    	FOREIGN KEY (ROL_NAME)
    	REFERENCES TWSS_ROLES(NAME),
	CONSTRAINT FK_RXC_COMMANDS
    	FOREIGN KEY (CMD_NAME)
    	REFERENCES TWSS_COMMANDS(NAME)
);
 
CREATE SEQUENCE TWSS_ROLE_CMD_SEQ;
 
CREATE TRIGGER TWSS_ROLE_X_COMMAND_TRG
BEFORE INSERT ON TWSS_ROLES_X_COMMANDS
FOR EACH ROW
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT TWSS_ROLE_CMD_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/