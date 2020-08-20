package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity , Long> {

}
