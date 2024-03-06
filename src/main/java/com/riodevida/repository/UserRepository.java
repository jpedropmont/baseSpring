package com.riodevida.repository;

import com.riodevida.common.BaseRepository;
import com.riodevida.domain.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {

    UserDetails findByLogin(String login);

}
