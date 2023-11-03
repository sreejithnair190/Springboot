package com.aiven.mysql.demo.repositories;

import com.aiven.mysql.demo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
