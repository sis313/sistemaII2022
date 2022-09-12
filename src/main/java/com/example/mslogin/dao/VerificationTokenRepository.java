package com.example.mslogin.dao;

import com.example.mslogin.dto.UserEntity;
import com.example.mslogin.dto.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity,Integer>{
    @Query(
            value = "SELECT vt \n" +
                    "FROM VerificationTokenEntity vt\n" +
                    "WHERE vt.token = ?1"
    )
    public VerificationTokenEntity findToken(String tk);
}
