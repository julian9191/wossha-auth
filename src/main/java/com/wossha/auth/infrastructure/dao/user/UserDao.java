package com.wossha.auth.infrastructure.dao.user;

import java.sql.Timestamp;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;

@Repository
public abstract  class UserDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@RegisterMapper(CompleteUserMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_USERS u JOIN TWSS_USERS_X_ROLES uxr ON u.USERNAME = uxr.USERNAME WHERE u.USERNAME = :username")
    public abstract List<UserRecord> findCompleteByUsername(@Bind("username") String username);
    
	@RegisterMapper(UserMapperJdbi.class)
    @SqlQuery("SELECT USERNAME,FIRST_NAME,LAST_NAME,EMAIL,GENDER,BIRTHDAY,ABOUT,COUNTRY_ID FROM TWSS_USERS u WHERE u.USERNAME = :username")
    public abstract UserRecord findByUsername(@Bind("username") String username);
    
	@RegisterMapper(UserMapperJdbi.class)
    @SqlQuery("SELECT * FROM TWSS_USERS u WHERE u.USERNAME = :username OR u.EMAIL = :email")
    public abstract UserRecord findByUsernameOrEmail(@Bind("username") String username, @Bind("email") String email);
    
    
    //INSERTS--------------------------------------------------------------------------------------------------------------------------------------
    
	@RegisterMapper(UserMapperJdbi.class)
    @SqlUpdate("Insert into TWSS_USERS (USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,EMAIL,COUNTRY_ID,GENDER,BIRTHDAY) values (:user.username, :user.password, :user.firstName, :user.lastName, :user.email, :user.country, :user.gender, :user.birthday)")
    public abstract void addUser(@BindBean("user") UserRecord user);
    
    @RegisterMapper(UserRoleMapperJdbi.class)
    @SqlUpdate("Insert into TWSS_USERS_X_ROLES (USERNAME,ROLE_NAME) values (:user.username, :user.roleName)")
    public abstract void addUserRole(@BindBean("user") UserRoleRecord user);
    
    @Transaction
    public void add(UserRecord user, UserRoleRecord useRole) {
    	addUser(user);
    	addUserRole(useRole);
    }
    
    //UPDATES----------------------------------------------------------------------------------------------------------------------------------------
    
    @RegisterMapper(UserMapperJdbi.class)
    @SqlUpdate("UPDATE TWSS_USERS SET FIRST_NAME=:user.firstName, LAST_NAME=:user.lastName, EMAIL=:user.email, BIRTHDAY=:user.birthday, ABOUT=:user.about, COUNTRY_ID=:user.country, GENDER=:user.gender, MODIFIED=SYSDATE WHERE USERNAME=:user.username")
    public abstract void update(@BindBean("user") UserRecord user);

    
    public abstract void close();

}