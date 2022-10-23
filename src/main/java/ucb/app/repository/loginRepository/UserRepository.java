package ucb.app.repository.loginRepository;

import ucb.app.model.loginModel.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
        @Query(value = "SELECT u \n" +
                        "FROM UserEntity u\n" +
                        "WHERE u.email = ?1")
        UserEntity findUserByEmail(String email);

        @Query(value = "SELECT u \n" +
                        "FROM UserEntity u\n" +
                        "WHERE u.nickname = ?1")
        UserEntity findUserByUser(String nickname);

        @Query(value = "SELECT u \n" +
                        "FROM UserEntity u\n" +
                        "WHERE u.idUser = ?1")
        UserEntity findUserByID(int id);

        @Query(value = "SELECT u \n" +
                        "FROM UserEntity u\n" +
                        "WHERE u.nickname = ?1")
        Optional<UserEntity> findByUsername(String user);

        boolean existsByEmail(String email);

        boolean existsByNickname(String nickname);

        @Query(value = "SELECT a.*" +
                        "   FROM user a" +
                        "   WHERE a.id_type_user = :typeUser" +
                        "   AND a.status = :status", nativeQuery = true)
        public List<UserEntity> findAllByTypeAndStatus(@Param("typeUser") Integer tipo,
                        @Param("status") Integer status);
}