package ucb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
    public List<Branch> findByIdBusiness(Integer idBusiness);
}
