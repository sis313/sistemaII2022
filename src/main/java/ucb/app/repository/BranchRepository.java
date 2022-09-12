package ucb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
