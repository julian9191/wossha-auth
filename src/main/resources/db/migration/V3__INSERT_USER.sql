/*password=123*/
Insert into TWSS_USERS (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, GENDER, BIRTHDAY) values ('julian','$2a$10$vEHVYcj/sIDxYOmdt0sUpuyqPnyimSwik4mVvN27C3BCvie/j2Bky','Julián','Giraldo','julian@gmail.com', 'M', TO_DATE('01/09/1991', 'dd/mm/yyyy'));

Insert into TWSS_ROLES (NAME,DESCRIPTION) values ('USER','NORMAL USER');
Insert into TWSS_ROLES (NAME,DESCRIPTION) values ('ADMIN','ADMINISTRATOR');

Insert into TWSS_USERS_X_ROLES (ID,USERNAME,ROLE_NAME) values (1,'julian','USER');
Insert into TWSS_USERS_X_ROLES (ID,USERNAME,ROLE_NAME) values (2,'julian','ADMIN');