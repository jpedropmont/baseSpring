package com.base.repository;

import com.base.common.BaseRepository;
import com.base.domain.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {

    UserDetails findByLogin(String login);

}
