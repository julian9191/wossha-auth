package com.wossha.auth.infrastructure.dao.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.IDBI;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.springframework.stereotype.Repository;
import com.wossha.auth.dto.ChatUserStatus;
import com.wossha.auth.dto.UserMinimumDTO;
import com.wossha.auth.infrastructure.dao.BaseDao;

@Repository
@UseStringTemplate3StatementLocator
public abstract  class UserDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@RegisterMapper(CompleteUserMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_USERS u JOIN TWSS_USERS_X_ROLES uxr ON u.USERNAME = uxr.USERNAME WHERE u.USERNAME = :username")
    public abstract List<UserRecord> findCompleteByUsername(@Bind("username") String username);
    
	@RegisterMapper(UserMapperJdbi.class)
    @SqlQuery("SELECT USERNAME,FIRST_NAME,LAST_NAME,EMAIL,GENDER,BIRTHDAY,ABOUT,COUNTRY_ID,PROFILE_PICTURE,COVER_PICTURE FROM TWSS_USERS u WHERE u.USERNAME = :username")
    public abstract UserRecord findByUsername(@Bind("username") String username);
    
	@RegisterMapper(UserMapperJdbi.class)
    @SqlQuery("SELECT * FROM TWSS_USERS u WHERE u.USERNAME = :username OR u.EMAIL = :email")
    public abstract UserRecord findByUsernameOrEmail(@Bind("username") String username, @Bind("email") String email);
    
	@RegisterMapper(UserMinimumMapperJdbi.class)
	@SqlQuery("SELECT USERNAME, CONCAT(FIRST_NAME, CONCAT(' ',LAST_NAME)) AS NAME, PROFILE_PICTURE "
			+ "FROM TWSS_USERS WHERE upper(USERNAME) LIKE upper(:word) order by NAME FETCH FIRST 5 ROWS ONLY")
    public abstract List<UserMinimumDTO> searchUser(@Bind("word") String word);
	
	
	public List<ChatUserStatus> getChatFriendsStatus(IDBI dbi, List<String> usernames) {

		BaseDao<ChatUserStatus> baseDao = new BaseDao<>();
		String query = "SELECT USERNAME, CONCAT(CONCAT(FIRST_NAME, ' '), LAST_NAME) AS NAME, PROFILE_PICTURE, IS_ONLINE FROM WSSAUTHCXN1.TWSS_USERS "
				+ "WHERE USERNAME IN (<usernames>)";

		Map<String, List<String>> typesBindMap = new HashMap<>();
		typesBindMap.put("usernames", usernames);
		query = baseDao.generateBingIdentifier(query, typesBindMap);

		Handle h = dbi.open();
		@SuppressWarnings("unchecked")
		Query<ChatUserStatus> q = h.createQuery(query).map(new ChatUserStatusMapperJdbi());

		q = baseDao.addInClauseBind(q, typesBindMap);
		List<ChatUserStatus> output = (List<ChatUserStatus>) q.list();

		return output;
	}
	
	public List<UserMinimumDTO> getMinimumUsersInfo(IDBI dbi, List<String> usernames) {

		BaseDao<UserMinimumDTO> baseDao = new BaseDao<>();
		
		String query = "SELECT USERNAME, CONCAT(FIRST_NAME, CONCAT(' ',LAST_NAME)) AS NAME, PROFILE_PICTURE "
				+ "FROM TWSS_USERS WHERE USERNAME IN (<usernames>)";

		Map<String, List<String>> typesBindMap = new HashMap<>();
		typesBindMap.put("usernames", usernames);
		query = baseDao.generateBingIdentifier(query, typesBindMap);

		Handle h = dbi.open();
		@SuppressWarnings("unchecked")
		Query<UserMinimumDTO> q = h.createQuery(query).map(new UserMinimumMapperJdbi());

		q = baseDao.addInClauseBind(q, typesBindMap);
		List<UserMinimumDTO> output = (List<UserMinimumDTO>) q.list();

		return output;
	}
	
	
    
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
    @SqlUpdate("UPDATE TWSS_USERS SET FIRST_NAME=:user.firstName, LAST_NAME=:user.lastName, EMAIL=:user.email, BIRTHDAY=:user.birthday, ABOUT=:user.about, COUNTRY_ID=:user.country, GENDER=:user.gender, MODIFIED=SYSDATE, PROFILE_PICTURE=:user.profilePicture, COVER_PICTURE=:user.coverPicture WHERE USERNAME=:user.username")
    public abstract void update(@BindBean("user") UserRecord user);
    
    @SqlUpdate("UPDATE TWSS_USERS SET IS_ONLINE=:status WHERE USERNAME=:username")
    public abstract void updateOnlineStatus(@Bind("username") String username, @Bind("status") int status);

    
    public abstract void close();

}