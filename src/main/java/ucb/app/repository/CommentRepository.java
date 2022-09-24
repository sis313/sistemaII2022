package ucb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public List<Comment> findByIdBusiness(Integer idBusiness);
}
