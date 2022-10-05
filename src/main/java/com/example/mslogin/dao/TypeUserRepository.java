package com.example.mslogin.dao;

import com.example.mslogin.dto.TypeUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("typeUserRepository")
public interface TypeUserRepository extends JpaRepository<TypeUserEntity,Integer> {

}
