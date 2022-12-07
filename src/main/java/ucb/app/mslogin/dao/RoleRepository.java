package ucb.app.mslogin.dao;

import ucb.app.mslogin.dto.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByName(RoleName name);
}
