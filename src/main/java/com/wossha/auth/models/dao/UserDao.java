package com.wossha.auth.models.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;

@Repository
@RegisterMapper(UserMapperJdbi.class)
public interface UserDao {

    @SqlQuery("SELECT * FROM WSSAUTHCXN1.TWSS_USERS u JOIN WSSAUTHCXN1.TWSS_USERS_X_ROLES uxr ON u.USERNAME = uxr.USERNAME WHERE u.USERNAME = :username")
    List<UserRecord> findByUsername(@Bind("username") String username);

    void close();

}