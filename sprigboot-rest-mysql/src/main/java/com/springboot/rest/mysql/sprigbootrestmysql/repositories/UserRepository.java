package com.springboot.rest.mysql.sprigbootrestmysql.repositories;

import com.springboot.rest.mysql.sprigbootrestmysql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
