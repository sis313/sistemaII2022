
package ucb.edu.bo.demo.api;

import ucb.edu.bo.demo.bl.CommentBl;
import ucb.edu.bo.demo.dto.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class CommentApi {

    CommentBl CommentBl;

    @Autowired
    public CommentApi(CommentBl CommentBl) {
        this.CommentBl = CommentBl;
    }

    @GetMapping(value = "/Comments")
    public List<Comment> getAll(){
        return CommentBl.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/Comments/user/{id}")
    public List<Comment> getAllByUser(@PathVariable(name = "id") int id){
        return CommentBl.getAllByUser(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/Comments/id/{id}")
    public List<Comment> getById(@PathVariable(name = "id") int id){
        return CommentBl.getById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/Business/IdAndUser/{id_user}/{id_comment}"
    )
    public List<Comment> getByIdAndUser(@PathVariable(name = "id_user") int id_user, @PathVariable(name = "id_comment") int id_comment){
        return CommentBl.getByIdAndUser(id_user, id_comment);
    }
}

