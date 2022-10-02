package com.example.mslogin.dao;

import com.example.mslogin.dto.UserEntity;
import com.example.mslogin.dto.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity,Integer>{
    @Query(
            value = "SELECT vt \n" +
                    "FROM VerificationTokenEntity vt\n" +
                    "WHERE vt.token = ?1"
    )
    public VerificationTokenEntity findToken(String tk);

    @Query(
            value = "SELECT vt \n" +
                    "FROM VerificationTokenEntity vt\n" +
                    "WHERE vt.idUser = ?1"
    )
    public VerificationTokenEntity findTokenByIdUser(int id);

    @Modifying
    @Query("delete from VerificationTokenEntity t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);
}
