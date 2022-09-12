package com.example.mslogin.dao;

import com.example.mslogin.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Query(
            value = "SELECT u \n" +
                    "FROM UserEntity u\n" +
                    "WHERE u.email = ?1"
    )
    public UserEntity findUserByEmail(String email);

    @Query(
            value = "SELECT u \n" +
                    "FROM UserEntity u\n" +
                    "WHERE u.idUser = ?1"
    )
    public UserEntity findUserByID(int id);
}