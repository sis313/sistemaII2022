package ucb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public List<Comment> findByIdBusiness(Integer idBusiness);

    // GRUPO 3 ROUTE
    public List<Comment> findByIdUser(Integer idUser);

    // GRUPO 3 ROUTE
    public List<Comment> findByIdUserAndIdComment(Integer idUser, Integer idComment);
}
