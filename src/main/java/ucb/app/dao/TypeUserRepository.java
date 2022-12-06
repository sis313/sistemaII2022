package ucb.app.dao;

import ucb.app.dto.TypeUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("typeUserRepository")
public interface TypeUserRepository extends JpaRepository<TypeUserEntity,Integer> {

}
