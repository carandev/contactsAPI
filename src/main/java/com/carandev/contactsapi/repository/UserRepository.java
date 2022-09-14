package com.carandev.contactsapi.repository;

import com.carandev.contactsapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
