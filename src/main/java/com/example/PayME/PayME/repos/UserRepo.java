package com.example.PayME.PayME.repos;

import com.example.PayME.PayME.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
