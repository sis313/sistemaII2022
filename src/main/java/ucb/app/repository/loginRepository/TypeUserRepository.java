package ucb.app.repository.loginRepository;

import ucb.app.model.loginModel.TypeUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("typeUserRepository")
public interface TypeUserRepository extends JpaRepository<TypeUserEntity, Integer> {

}
