package ucb.edu.bo.demo.bl;

import ucb.edu.bo.demo.dto.Comment;
import ucb.edu.bo.demo.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentBl {
    private final CommentDao CommentDao;

    @Autowired
    public CommentBl(CommentDao CommentDao) {this.CommentDao = CommentDao;}

    public List<Comment> getAll (){
        return CommentDao.getAll();
    }

    public List<Comment> getAllByUser (int id_user){
        return CommentDao.getAllByUser(id_user);
    }

    public List<Comment> getByIdAndUser (int id_user, int id_comment){
        return CommentDao.getByIdAndUser(id_user, id_comment);
    }

    public List<Comment> getById (int id_comment){
        return CommentDao.getById(id_comment);
    }
    
}
